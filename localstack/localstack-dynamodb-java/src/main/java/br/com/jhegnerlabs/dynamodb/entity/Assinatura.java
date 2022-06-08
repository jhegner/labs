package br.com.jhegnerlabs.dynamodb.entity;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Assinatura {
    
    private String idAssinatura;

    private Signatario signatario;

    private LocalDate dataExpiracao;

}
