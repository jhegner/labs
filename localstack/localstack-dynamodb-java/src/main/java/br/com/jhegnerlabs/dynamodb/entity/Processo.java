package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_controle_processo_pessoa_juridica")
public class Processo {

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @JsonProperty("sort_key")
    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @JsonProperty("id_processo")
    @DynamoDBAttribute(attributeName = "id_processo")
    private String idProcesso;

    @JsonProperty("tipo_processo")
    @DynamoDBAttribute(attributeName = "tipo_processo")
    private String tipoProcesso;

    @JsonProperty("data_inicio")
    @DynamoDBAttribute(attributeName = "data_inicio")
    private String dataInicio;

    @JsonProperty("data_expiracao")
    @DynamoDBAttribute(attributeName = "data_expiracao")
    private String dataExpiracao;

    @JsonProperty("data_fim")
    @DynamoDBAttribute(attributeName = "data_fim")
    private String dataFim;

    @JsonProperty("status")
    @DynamoDBAttribute(attributeName = "status")
    private String status;

    @JsonProperty("descricao")
    @DynamoDBAttribute(attributeName = "descricao")
    private String descricao;

    @JsonIgnore
    @DynamoDBIgnore
    private List<Documento> documentos;

}
