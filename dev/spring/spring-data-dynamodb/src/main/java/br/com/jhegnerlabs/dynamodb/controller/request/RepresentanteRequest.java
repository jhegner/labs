package br.com.jhegnerlabs.dynamodb.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepresentanteRequest {

    private String idPessoaFisica;

    private String nome;

    private Integer idade;

    private String cpf;

    private String rg;

    private String dataNascimento;

    private String sexo;

    private String mae;

    private String pai;

    private String email;

}
