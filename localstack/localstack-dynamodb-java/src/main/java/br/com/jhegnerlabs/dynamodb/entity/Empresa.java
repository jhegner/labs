package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Set;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_empresa")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Empresa {

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "cnpj")
    private String cnpj;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "inscricao_estadual")
    private String inscricaoEstadual;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "data_abertura")
    private String dataAbertura;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "site")
    private String site;

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBAttribute(attributeName = "email")
    private String email;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
