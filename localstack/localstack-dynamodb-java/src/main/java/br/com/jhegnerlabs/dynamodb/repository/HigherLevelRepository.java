package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.Empresa;
import br.com.jhegnerlabs.dynamodb.entity.Processo;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.document.RangeKeyCondition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

import java.util.List;

public class HigherLevelRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";

    public Empresa findEmpresa(final String idPessoaJuridica) {

        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig).build();

        DynamoDBMapper dbMapper = new DynamoDBMapper(client);

        final var pk = Empresa.builder()
                .withIdPessoaJuridica(idPessoaJuridica)
                .build();

        final DynamoDBQueryExpression<Empresa> queryExpression
                = new DynamoDBQueryExpression<Empresa>()
                .withHashKeyValues(pk);

        List<Empresa> empresas = dbMapper.query(Empresa.class, queryExpression);

        return empresas.stream().findAny()
                .orElseThrow(() -> new IllegalStateException("Nao encontrado item para o filtro informado"));

    }

    public Processo findProcesso(final String idEmpresa, final String idProcesso){

        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig).build();

        DynamoDBMapper dbMapper = new DynamoDBMapper(client);

        final var pk = Processo.builder()
                .withIdPessoaJuridica(idEmpresa)
                .build();

        Condition rangeKeyCondition = new Condition()
                .withComparisonOperator(ComparisonOperator.BEGINS_WITH)
                .withAttributeValueList(new AttributeValue("PROCESSO#" + idProcesso));

        final DynamoDBQueryExpression<Processo> queryExpression
                = new DynamoDBQueryExpression<Processo>()
                .withRangeKeyCondition("sort_key", rangeKeyCondition)
                .withHashKeyValues(pk);

        List<Processo> processos = dbMapper.query(Processo.class, queryExpression);

        return processos.stream().findFirst().orElse(Processo.builder().build());

    }


}
