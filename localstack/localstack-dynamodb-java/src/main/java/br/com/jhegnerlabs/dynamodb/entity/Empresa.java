package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Set;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_empresa")
public class Empresa {

    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "cnpj")
    private String cnpj;

    @DynamoDBAttribute(attributeName = "inscricao_estadual")
    private String inscricaoEstadual;

    @DynamoDBAttribute(attributeName = "data_abertura")
    private String dataAbertura;

    @DynamoDBAttribute(attributeName = "site")
    private String site;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
