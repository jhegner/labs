package br.com.jhegnerlabs.dynamodb.repository;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;

import br.com.jhegnerlabs.dynamodb.entity.Processo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class LowLevelRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";

    public Processo consultaProcesso(String idCliente, String idProcesso) {

        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName()
        );

//        var client = AmazonDynamoDBClient.builder()
//                .withEndpointConfiguration(endpoint)
//                .withRegion(Regions.SA_EAST_1).build();

            var client = AmazonDynamoDBClientBuilder
                    .standard()
                    .withEndpointConfiguration(endpointConfig).build();

        var request = new GetItemRequest()
                .withTableName("tb_controle_processo_pessoa_juridica")
                .withKey(Map.of(
                        "IdPessoaJuridica", new AttributeValue().withS(idCliente),
                        "SK", new AttributeValue().withS("PROCESSO#" + idProcesso)));
//                .with;;

        try {

            var result = client.getItem(request);
            log.info("Processo - {}", result);

        } catch (Exception ex) {
           log.error("Erro ao consultar base do DynamoDB", ex);
        }

        return new Processo();
    }

}