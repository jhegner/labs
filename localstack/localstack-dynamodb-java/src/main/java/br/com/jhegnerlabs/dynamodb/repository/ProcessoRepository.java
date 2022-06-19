package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.Processo;
import br.com.jhegnerlabs.dynamodb.repository.helper.MapperEntity;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class ProcessoRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";

    public Processo findProcesso(String idCliente, String idProcesso) {

        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig).build();

        var documentClient = new DynamoDB(client);

        var table = documentClient.getTable("tb_controle_processo_pessoa_juridica");

//        var outcome = table.getItemOutcome(
//                "id_pessoa_juridica", idCliente,
//                "sort_key", "PROCESSO#" + idProcesso
//        );
//        log.info("GetItemOutcome {}", outcome);

        RangeKeyCondition rangeKeyCondition = new RangeKeyCondition("sort_key");
        rangeKeyCondition.beginsWith("PROCESSO#" + idProcesso);

        ItemCollection<QueryOutcome> items = table.query(
                "id_pessoa_juridica", idCliente, rangeKeyCondition);

//        if(items.getAccumulatedItemCount() <= 0) {
////            throw new IllegalStateException("Nao encontrado processo para o filtro informado");
//        }

        return new MapperEntity().mapItemToEntity(items.pages());
    }




}
