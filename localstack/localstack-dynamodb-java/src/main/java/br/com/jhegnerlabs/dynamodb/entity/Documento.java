package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_controle_processo_pessoa_juridica")
public class Documento {

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @JsonProperty("sort_key")
    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @JsonProperty("id_documento")
    @DynamoDBRangeKey(attributeName = "id_documento")
    private String idDocumento;

    @JsonProperty("nome_documento")
    @DynamoDBRangeKey(attributeName = "nome_documento")
    private String nomeDocumento;

    @JsonProperty("formato")
    @DynamoDBAttribute(attributeName = "formato")
    private String formato;

    @JsonProperty("tamanho")
    @DynamoDBAttribute(attributeName = "tamanho")
    private String tamanho;

    @JsonProperty("data_hora_entrega")
    @DynamoDBAttribute(attributeName = "data_hora_entrega")
    private String dataHoraEntrega;

//    @JsonIgnore
//    @DynamoDBIgnore
//    private Empresa empresa;

    @JsonIgnore
    @DynamoDBIgnore
    private OrdemAssinatura ordemAssinatura;

}
