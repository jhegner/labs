package br.com.jhegnerlabs.dynamodb.entity;

import br.com.jhegnerlabs.dynamodb.enums.StatusAssinatura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Signatario extends Representante{

    private Assinatura assinatura;

    private StatusAssinatura statusAssinatura;
    
}
