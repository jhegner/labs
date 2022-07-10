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
public class OrdemAssinatura {

    @JsonProperty("id_pessoa_juridica")
    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @JsonProperty("sort_key")
    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @JsonProperty("id_documento")
    @DynamoDBAttribute(attributeName = "id_documento")
    private String idDocumento;

    @JsonProperty("id_assinatura")
    @DynamoDBAttribute(attributeName = "id_assinatura")
    private String idAssinatura;

    @JsonProperty("data_hora_assinatura")
    @DynamoDBAttribute(attributeName = "data_hora_assinatura")
    private String dataHoraAssinatura;

//    @JsonIgnore
//    @DynamoDBIgnore
//    private Documento documento;

//    @JsonIgnore
//    @DynamoDBIgnore
//    private List<Signatario> signatarios;
}
