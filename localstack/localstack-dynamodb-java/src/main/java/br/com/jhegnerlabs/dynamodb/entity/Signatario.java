package br.com.jhegnerlabs.dynamodb.entity;

import java.time.LocalDateTime;

import br.com.jhegnerlabs.dynamodb.enums.StatusAssinatura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Signatario extends Representante{

    private LocalDateTime dataHoraAssinatura;

    private StatusAssinatura statusAssinatura;
    
}
