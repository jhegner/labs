package br.com.jhegnerlabs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.util.ImmutableMapParameter;
import org.elasticmq.rest.sqs.SQSRestServer;
import org.elasticmq.rest.sqs.SQSRestServerBuilder;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

class SaudacaoTest {

    private static final String QUEUE_NAME = "mensagem-de-saudacao-em-varios-idiomas";
    private static final String QUEUE_URL = "http://localhost:4599/000000000000/" + QUEUE_NAME;

    private static SQSRestServer serverElasticMQ;
    private static AmazonSQS amazonSqsClient;

    @BeforeAll
    static void beforeAll() {
        iniciarServidor();
        configurarAmazonSqsClient();
    }

    @AfterAll
    static void afterAll() {
        limparFila();
        removerFila();
        pararServidor();
    }

    @Test
    @Order(1)
    @DisplayName("Deve enviar mensagens da fila sqs com sucesso")
    public void test_deve_enviar_mensagem_fila_sqs_com_sucesso() {

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

        var queueAttributesResult = amazonSqsClient.getQueueAttributes(QUEUE_URL, List.of("All"));

        Assertions.assertEquals(String.valueOf(Mensagem.values().length), queueAttributesResult.getAttributes().get("ApproximateNumberOfMessages"));

    }

    @Order(2)
    @RepeatedTest(value = 3)
    @DisplayName("Deve receber mensagens da fila sqs com sucesso")
    public void test_deve_receber_mensagem_fila_sqs_com_sucesso() {

        ReceiveMessageRequest receiveRequest = new ReceiveMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMessageAttributeNames("All")
                .withVisibilityTimeout(30)
                .withMaxNumberOfMessages(2);

        List<Message> messages = amazonSqsClient.receiveMessage(receiveRequest).getMessages();
        messages.forEach(message -> {

            System.out.println("Idioma: " + message.getMessageAttributes().get("idioma").getStringValue());
            System.out.println("Texto: " + message.getBody());

            DeleteMessageRequest deleteRequest = new DeleteMessageRequest()
                    .withQueueUrl(QUEUE_URL)
                    .withReceiptHandle(message.getReceiptHandle());
            amazonSqsClient.deleteMessage(deleteRequest);

            Assertions.assertTrue(messages.size() > 1);
        });

        Assertions.assertNotNull(messages);
    }

    @Test
    @Order(3)
    @DisplayName("Deve encontrar 0 mensagens na fila sqs")
    public void test_deve_encontrar_zero_mensagens_na_fila_sqs() {

        var queueAttributesResult = amazonSqsClient.getQueueAttributes(QUEUE_URL, List.of("All"));

        Assertions.assertEquals("0", queueAttributesResult.getAttributes().get("ApproximateNumberOfMessages"));
    }

    private static synchronized void pararServidor() {
        serverElasticMQ.stopAndWait();
    }

    private static synchronized void removerFila() {
        amazonSqsClient.deleteQueue(QUEUE_URL);
    }

    private static synchronized void limparFila() {
        PurgeQueueRequest purgeRequest = new PurgeQueueRequest().withQueueUrl(QUEUE_URL);
        amazonSqsClient.purgeQueue(purgeRequest);
    }

    private static void configurarAmazonSqsClient() {
        String endpoint = "http://localhost:4599";
        String region = "elasticmq";
        String accessKey = "x";
        String secretKey = "x";

        amazonSqsClient = AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();

        var createQueueRequest = new CreateQueueRequest().withQueueName(QUEUE_NAME);
        amazonSqsClient.createQueue(createQueueRequest);
    }

    private static void iniciarServidor() {
        serverElasticMQ = SQSRestServerBuilder
                .withPort(4599)
                .withInterface("localhost")
                .start();
    }
}