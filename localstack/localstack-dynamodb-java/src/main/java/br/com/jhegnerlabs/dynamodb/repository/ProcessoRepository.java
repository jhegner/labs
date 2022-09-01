package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.ControleProcessoEmpresa;
import br.com.jhegnerlabs.dynamodb.entity.Processo;
import br.com.jhegnerlabs.dynamodb.repository.helper.MapperEntity;
import br.com.jhegnerlabs.dynamodb.repository.helper.MapperEntity2;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class ProcessoRepository {

//    public static final String SERVICE_ENDPOINT = "http://localhost:4566";
    public static final String SERVICE_ENDPOINT = "https://dynamodb.us-east-1.amazonaws.com";

    public ControleProcessoEmpresa findProcesso(String idCliente, String idProcesso) {

        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .withEndpointConfiguration(endpointConfig).build();

        var documentClient = new DynamoDB(client);

        var table = documentClient.getTable("tb_controle_processo_pessoa_juridica");

        RangeKeyCondition rangeKeyCondition = new RangeKeyCondition("sort_key");
        rangeKeyCondition.beginsWith("PROCESSO#" + idProcesso);

        ItemCollection<QueryOutcome> items = table.query(
                "id_pessoa_juridica", idCliente, rangeKeyCondition);

        return new MapperEntity2().mapItemToEntity(items.pages()).orElseThrow(
                () -> new IllegalStateException("Nao foi possivel encontrar nenhum registro"));
    }




}
