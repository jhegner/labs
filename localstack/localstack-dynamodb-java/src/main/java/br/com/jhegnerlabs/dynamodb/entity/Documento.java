package br.com.jhegnerlabs.dynamodb.entity;

import java.time.LocalDateTime;
import java.util.List;

import br.com.jhegnerlabs.dynamodb.enums.Formato;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Documento {

    private String idDocumento;

    private List<Assinatura> assinaturas;

    private Processo processo;

    private String nome;

    private Formato formato;

    private int tamanho;

    private LocalDateTime dataHoraEntrega;
    
}
