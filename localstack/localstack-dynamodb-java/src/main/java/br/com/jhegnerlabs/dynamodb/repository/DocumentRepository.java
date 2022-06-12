package br.com.jhegnerlabs.dynamodb.repository;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import br.com.jhegnerlabs.dynamodb.entity.Processo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";

    public Processo consultaProcesso(String idCliente, String idProcesso) {
    
        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
            SERVICE_ENDPOINT,
            Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(endpointConfig).build();
            
        var documentClient = new DynamoDB(client);

        var table = documentClient.getTable("tb_controle_processo_pessoa_juridica");

        var outcome = table.getItemOutcome(
            "IdPessoaJuridica", "e86fcdfb-c200-4737-8b1c-7923e25e0843",
            "SK", "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937"
        );

        log.info("Campo - IdPessoaJuridica {}", outcome.getItem().get("IdPessoaJuridica"));


        return new Processo();
    }

    
}
