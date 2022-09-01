package br.com.jhegnerlabs.dynamodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Set;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class ControleProcessoEmpresa {

    private Processo processo;

    private Empresa empresa;

    private Set<Documento> documentos;

    private Set<Signatario> signatarios;

    private OrdemAssinatura ordemAssinatura;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
