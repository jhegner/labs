package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.ControleProcessoEmpresa;
import br.com.jhegnerlabs.dynamodb.entity.Documento;
import br.com.jhegnerlabs.dynamodb.entity.Processo;
import br.com.jhegnerlabs.dynamodb.enums.EntityType;
import br.com.jhegnerlabs.dynamodb.exception.EntityNotFoundException;
import br.com.jhegnerlabs.dynamodb.repository.builder.CodigoChaveOrdenacao;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;

import java.net.URI;
import java.util.Map;
import java.util.Set;

@Slf4j
public class EnhancedClientRepository {

    public static final String SERVICE_ENDPOINT = "http://localhost:4566";
    public static final String TB_CONTROLE_PROCESSO_PESSOA_JURIDICA = "tb_controle_processo_pessoa_juridica";

    public Documento consultaDocumento(String idCliente, CodigoChaveOrdenacao sortedKey) {

        DynamoDbEnhancedClient ddbEnhancedClient = getDynamoDbEnhancedClient(getDynamoDbClient(getAwsCredentialsProvider()));

        var dynamoDbTable = ddbEnhancedClient.table(TB_CONTROLE_PROCESSO_PESSOA_JURIDICA,
                TableSchema.fromBean(Documento.class));

        var key = Key.builder()
                .partitionValue(idCliente)
                .sortValue(sortedKey.toString())
                .build();

        return dynamoDbTable.getItem(key);

    }

    public ControleProcessoEmpresa consultaProcesso(String idCliente, String sortedKey) {

        DynamoDbClient ddbClient = getDynamoDbClient(getAwsCredentialsProvider());

        final var pkAtributeValue = AttributeValue.builder()
                .s(idCliente)
                .build();

        final var skAtributeValue = AttributeValue.builder()
                .s(sortedKey)
                .build();

        // Query com funcao begins_with do dynamodb
        var queryRequest = QueryRequest.builder()
                .tableName("tb_controle_processo_pessoa_juridica")
                .keyConditionExpression("#pk = :pk and begins_with(#sk, :sk)")
                .expressionAttributeNames(Map.of(
                        "#pk", "id_pessoa_juridica",
                        "#sk", "sort_key"))
                .expressionAttributeValues(Map.of(
                        ":pk", pkAtributeValue,
                        ":sk", skAtributeValue
                ))
                .build();

        // classe wrapper com todas as entidades
        final var cpeBuilder = ControleProcessoEmpresa.builder();

        var queryResponse = ddbClient.query(queryRequest);

        if (!queryResponse.hasItems() || queryResponse.items().isEmpty()) {
            throw new EntityNotFoundException("Recurso nao encontrado para o filtro");
        }

        queryResponse.items().forEach(item -> {

            var itemSortKeyAttributeValue = item.get("sort_key");

            var entityType = EntityType.getBySortKeyValue(itemSortKeyAttributeValue.s());

            switch (entityType) {
                case PROCESSO -> cpeBuilder.withProcesso(TableSchema.fromBean(Processo.class).mapToItem(item));
                case DOCUMENTO -> cpeBuilder.withDocumentos(Set.of(TableSchema.fromBean(Documento.class).mapToItem(item)));
                //case SIGNATARIO -> ...
                //case ORDEMASSINATURA -> ...
            }

        });

        return cpeBuilder.build();
    }

    private DynamoDbEnhancedClient getDynamoDbEnhancedClient(DynamoDbClient ddbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddbClient)
                .build();
    }

    private DynamoDbClient getDynamoDbClient(AwsCredentialsProvider awsCredentialProvider) {
        return DynamoDbClient.builder()
                .credentialsProvider(awsCredentialProvider)
                .region(Region.US_EAST_1)
                .endpointOverride(URI.create(SERVICE_ENDPOINT))
                .build();
    }

    private AwsCredentialsProvider getAwsCredentialsProvider() {
        return DefaultCredentialsProvider.builder().build();
    }


}
