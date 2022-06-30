package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.OrdemAssinatura;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class OrdemAssinaturaRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";

    private final DynamoDBMapper dbMapper ;

    {
        dbMapper = getDynamoDBMapper();
    }


    public OrdemAssinatura findOrdemAssinatura(final String idPessoaJuridica, final String idProcesso, String idOrdemAssinatura) {

        final var pk = OrdemAssinatura.builder().withIdPessoaJuridica(idPessoaJuridica).build();

        final var rangeKey = "PROCESSO#" + idProcesso + "#" + "ORDEMASSINATURA" + "#" + idOrdemAssinatura;

        // opcao 2

        return dbMapper.load(OrdemAssinatura.class, idPessoaJuridica, rangeKey);

        // opcao 1

//        Condition rangeKeyCondition = new Condition()
//                .withComparisonOperator(ComparisonOperator.EQ)
//                .withAttributeValueList(
//                        new AttributeValue(rangeKey));
//
//        final DynamoDBQueryExpression<OrdemAssinatura> queryExpression
//                = new DynamoDBQueryExpression<OrdemAssinatura>()
//                .withRangeKeyCondition("sort_key", rangeKeyCondition)
//                .withHashKeyValues(pk);
//
//        List<OrdemAssinatura> ordens = dbMapper.query(OrdemAssinatura.class, queryExpression);
//
//        return ordens.stream().findAny()
//                .orElseThrow(() -> new IllegalStateException("Nao encontrado item para o filtro informado"));

    }

    public OrdemAssinatura updateOrdemAssinatura(OrdemAssinatura ordemAssinatura, final String idProcesso) {

        dbMapper.save(ordemAssinatura);

        final var rangeKey = "PROCESSO#" + idProcesso + "#" + "ORDEMASSINATURA" + "#" + ordemAssinatura.getIdAssinatura();

        return dbMapper.load(OrdemAssinatura.class, ordemAssinatura.getIdPessoaJuridica(), rangeKey);

    }

    private DynamoDBMapper getDynamoDBMapper() {
        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(
                SERVICE_ENDPOINT,
                Regions.US_EAST_1.getName());

        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig).build();

        return new DynamoDBMapper(client);
    }
}
