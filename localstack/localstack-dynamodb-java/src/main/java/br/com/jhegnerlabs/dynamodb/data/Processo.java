package br.com.jhegnerlabs.dynamodb.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Processo {

    private String PK;

    private String SK;
    
    private String IdPessoaJuridica;

    private String IdProcesso;

    private String TipoProcesso;

    private String DataInicio;

    private String DataFim;

    private String Status;

    private String Descricao;
}
