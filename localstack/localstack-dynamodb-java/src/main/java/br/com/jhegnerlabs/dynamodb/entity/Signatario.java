package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_representante_empresa")
public class Signatario {

    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @DynamoDBAttribute(attributeName = "id_documento")
    private String idDocumento;

    @DynamoDBAttribute(attributeName = "status")
    private String statusAssinatura;

    @DynamoDBAttribute(attributeName = "id_pessoa_fisica")
    private String idPessoaFisica;

    @DynamoDBAttribute(attributeName = "nome_signatario")
    private String nomeSignatario;

}
