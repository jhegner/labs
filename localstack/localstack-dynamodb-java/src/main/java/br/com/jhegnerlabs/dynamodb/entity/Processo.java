package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_controle_processo_pessoa_juridica")
@DynamoDbBean // aws sdk v2
public class Processo {

    // DynamoDB - aws sdk v2

    // DynamoDb - aws sdk v2

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

//    @JsonIgnore
//    @DynamoDBIgnore
//    private List<Documento> documentos;

    @DynamoDbAttribute("id_pessoa_juridica")
    public String getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    @DynamoDbAttribute("sort_key")
    public String getSortKey() {
        return sortKey;
    }

    @DynamoDbAttribute("id_processo")
    public String getIdProcesso() {
        return idProcesso;
    }

    @DynamoDbAttribute("tipo_processo")
    public String getTipoProcesso() {
        return tipoProcesso;
    }

    @DynamoDbAttribute("data_inicio")
    public String getDataInicio() {
        return dataInicio;
    }

    @DynamoDbAttribute("data_expiracao")
    public String getDataExpiracao() {
        return dataExpiracao;
    }

    @DynamoDbAttribute("data_fim")
    public String getDataFim() {
        return dataFim;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }

    @DynamoDbAttribute("descricao")
    public String getDescricao() {
        return descricao;
    }
}
