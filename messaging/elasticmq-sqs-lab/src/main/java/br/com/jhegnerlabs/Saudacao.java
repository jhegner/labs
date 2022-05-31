package br.com.jhegnerlabs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.util.ImmutableMapParameter;
import org.elasticmq.rest.sqs.SQSRestServer;
import org.elasticmq.rest.sqs.SQSRestServerBuilder;

import java.util.Arrays;

public class Saudacao {

    private static final String QUEUE_URL = "http://localhost:4566/000000000000/mensagem-de-saudacao-em-varios-idiomas";
//    private static final String QUEUE_URL = "https://sqs.sa-east-1.amazonaws.com/000000000000/mensagem-de-saudacao-em-varios-idiomas";
    private static final String QUEUE_NAME = "mensagem-de-saudacao-em-varios-idiomas";

    private SQSRestServer serverElasticMQ;
    private AmazonSQS amazonSqsClient;

    public void enviarSaudacao() {

        configurarSqsClient("local");

        System.out.println("Enviando as mensagens da fila");

        Arrays.stream(Mensagem.values()).forEach(mensagem -> {
            SendMessageRequest messageRequest = new SendMessageRequest()
                    .withMessageAttributes(
                            ImmutableMapParameter.of("idioma",
                                    new MessageAttributeValue()
                                            .withDataType("String")
                                            .withStringValue(mensagem.getIdioma())))
                    .withQueueUrl(QUEUE_URL)
                    .withMessageBody(mensagem.getTexto());

            amazonSqsClient.sendMessage(messageRequest);

        });

    }

    public void receberSaudacao() {

        ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMessageAttributeNames("All")
                .withVisibilityTimeout(30)
                .withMaxNumberOfMessages(10);

        var messagesResult = this.amazonSqsClient.receiveMessage(receiveRequest);

        System.out.println("Lendo as mensagens da fila");

        messagesResult.getMessages().forEach(messageResult -> {

            System.out.println("Idioma: " + messageResult.getMessageAttributes().get("idioma").getStringValue());
            System.out.println("Texto: " + messageResult.getBody());

            apagarMensagem(messageResult);

        });

        pararServidor();

    }

    private void configurarSqsClient(@org.jetbrains.annotations.NotNull String env) {

        switch (env) {

            case "local" -> {

                iniciarServidor();

                String endpoint = "http://localhost:4566";
                String region = "elasticmq";
                String accessKey = "x";
                String secretKey = "x";

                this.amazonSqsClient = AmazonSQSClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                        .build();

                criarFilaPadrao();
            }

            case "aws" ->{

                this.amazonSqsClient = AmazonSQSClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();

            }

            default -> throw new IllegalStateException("Unexpected value: " + env);
        }

    }

    private void apagarMensagem(Message messageResult) {
        DeleteMessageRequest deleteRequest = new DeleteMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withReceiptHandle(messageResult.getReceiptHandle());
        amazonSqsClient.deleteMessage(deleteRequest);
    }

    private void pararServidor() {
        limparFila();
//        removerFila();
        this.serverElasticMQ.stopAndWait();
    }

    private void removerFila() {
        this.amazonSqsClient.deleteQueue(QUEUE_URL);
    }

    private void limparFila() {
        PurgeQueueRequest purgeRequest = new PurgeQueueRequest().withQueueUrl(QUEUE_URL);
        this.amazonSqsClient.purgeQueue(purgeRequest);
    }

    private void iniciarServidor() {

        this.serverElasticMQ = SQSRestServerBuilder
                .withPort(4566)
                .withInterface("localhost")
                .start();
    }

    private void criarFilaPadrao() {
        var createQueueRequest = new CreateQueueRequest().withQueueName(QUEUE_NAME);
        amazonSqsClient.createQueue(createQueueRequest);
    }

}
