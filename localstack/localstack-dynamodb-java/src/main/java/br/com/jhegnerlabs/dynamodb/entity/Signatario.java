package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_representante_empresa")
public class Signatario {

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @JsonProperty("sort_key")
    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @JsonProperty("status")
    @DynamoDBAttribute(attributeName = "status")
    private String statusAssinatura;

    @JsonProperty("id_pessoa_fisica")
    @DynamoDBAttribute(attributeName = "id_pessoa_fisica")
    private String idPessoaFisica;

    @JsonProperty("nome_signatario")
    @DynamoDBAttribute(attributeName = "nome_signatario")
    private String nomeSignatario;

}
