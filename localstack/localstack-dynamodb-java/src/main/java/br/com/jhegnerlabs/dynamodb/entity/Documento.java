package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
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

    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @DynamoDBRangeKey(attributeName = "sort_key")
    private String sortKey;

    @DynamoDBRangeKey(attributeName = "id_documento")
    private String idDocumento;

    @DynamoDBAttribute(attributeName = "formato")
    private String formato;

    @DynamoDBAttribute(attributeName = "tamanho")
    private String tamanho;

    @DynamoDBAttribute(attributeName = "data_hora_entrega")
    private String dataHoraEntrega;

    @DynamoDBIgnore
    private Empresa empresa;

    @DynamoDBIgnore
    private OrdemAssinatura ordemAssinatura;

}
