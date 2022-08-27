package br.com.jhegnerlabs.dynamodb.entity;

import br.com.jhegnerlabs.dynamodb.entity.id.RepresentanteId;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_representante_empresa")
//@IdClass(RepresentanteId.class)
public class Representante {

    @Id
    private RepresentanteId id;

//    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
//    private String idPessoaJuridica;

//    @DynamoDBRangeKey(attributeName = "id_pessoa_fisica")
//    private String idPessoaFisica;


    public Representante() {
        if(null == this.id) {
            this.id = new RepresentanteId();
        }
    }

    public Representante(RepresentanteId id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "idade")
    private Integer idade;

    @DynamoDBIndexRangeKey(attributeName = "cpf", localSecondaryIndexName = "cpf-index")
    @DynamoDBAttribute(attributeName = "cpf")
    private String cpf;

    @DynamoDBIndexHashKey(attributeName = "rg", globalSecondaryIndexName = "rg-index")
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

    @DynamoDBHashKey(attributeName = "id_pessoa_juridica")
    public String getIdPessoaJuridica() {
        return id.getIdPessoaJuridica();
    }

    public void setIdPessoaJuridica(String idPessoaJuridica) {
        this.id.setIdPessoaJuridica(idPessoaJuridica);
    }

    @DynamoDBRangeKey(attributeName = "id_pessoa_fisica")
    public String getIdPessoaFisica() {
        return id.getIdPessoaFisica();
    }

    public void setIdPessoaFisica(String idPessoaFisica) {
        this.id.setIdPessoaFisica(idPessoaFisica);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
