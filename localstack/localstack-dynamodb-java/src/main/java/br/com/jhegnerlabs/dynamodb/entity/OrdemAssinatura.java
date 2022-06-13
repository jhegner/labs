package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_controle_processo_pessoa_juridica")
public class OrdemAssinatura {

    @DynamoDBAttribute(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @DynamoDBAttribute(attributeName = "id_documento")
    private String idDocumento;

    @DynamoDBAttribute(attributeName = "id_assinatura")
    private String idAssinatura;

    @DynamoDBAttribute(attributeName = "data_hora_assinatura")
    private String dataHoraAssinatura;

    @DynamoDBIgnore
    private Documento documento;

    @DynamoDBIgnore
    private List<Signatario> signatarios;
}
