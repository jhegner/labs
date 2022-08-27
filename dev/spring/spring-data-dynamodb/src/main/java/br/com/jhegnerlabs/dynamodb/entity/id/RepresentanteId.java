package br.com.jhegnerlabs.dynamodb.entity.id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepresentanteId implements Serializable {

    @DynamoDBHashKey
    private String idPessoaJuridica;

    @DynamoDBRangeKey
    private String idPessoaFisica;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepresentanteId that = (RepresentanteId) o;

        if (!Objects.equals(idPessoaJuridica, that.idPessoaJuridica))
            return false;
        return Objects.equals(idPessoaFisica, that.idPessoaFisica);
    }

    @Override
    public int hashCode() {
        int result = idPessoaJuridica != null ? idPessoaJuridica.hashCode() : 0;
        result = 31 * result + (idPessoaFisica != null ? idPessoaFisica.hashCode() : 0);
        return result;
    }
}
