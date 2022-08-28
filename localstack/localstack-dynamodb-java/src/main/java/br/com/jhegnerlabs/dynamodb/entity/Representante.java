package br.com.jhegnerlabs.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

//@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamoDBTable(tableName = "tb_representante_empresa")
public class Representante {

    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    private String idPessoaJuridica;

    @DynamoDBRangeKey(attributeName = "id_pessoa_fisica")
    private String idPessoaFisica;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "idade")
    private Integer idade;

    @DynamoDBAttribute(attributeName = "cpf")
    private String cpf;

    @DynamoDBAttribute(attributeName = "rg")
    private String rg;

    @DynamoDBAttribute(attributeName = "data_nasc")
    private String dataNascimento;

    @DynamoDBAttribute(attributeName = "sexo")
    private String sexo;

    @DynamoDBAttribute(attributeName = "mae")
    private String mae;

    @DynamoDBAttribute(attributeName = "pai")
    private String pai;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

}
