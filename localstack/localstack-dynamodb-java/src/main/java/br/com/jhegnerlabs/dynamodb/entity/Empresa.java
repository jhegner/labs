package br.com.jhegnerlabs.dynamodb.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empresa {

    private String idPessoaJuridica;

    private List<Processo> processos;

}
