package br.com.jhegnerlabs.openfeign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Desejo {

    private String id;
    private String nome;

}
