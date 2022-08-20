package br.com.jhegnerlabs.dynamodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class ControleProcessoEmpresa {

    private Processo processo;

    private Empresa empresa;

    private Set<Documento> documentos;

    private Set<Signatario> signatarios;

}
