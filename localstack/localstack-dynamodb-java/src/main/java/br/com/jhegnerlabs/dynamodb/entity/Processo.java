package br.com.jhegnerlabs.dynamodb.entity;

import br.com.jhegnerlabs.dynamodb.enums.StatusProcessoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Processo {

    private String pK;

    private String sK;
    
    private String idPessoaJuridica;

    private String idProcesso;

    private String tipoProcesso;

    private String dataInicio;

    private String dataFim;

    private StatusProcessoEnum status;

    private String descricao;
}
