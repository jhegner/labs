package br.com.jhegnerlabs.domain;

import java.util.ArrayList;
import java.util.List;

public class Assinatura {

    private final Canal canal;
    private final List<Leitor> leitores;

    public Assinatura(Canal canal, List<Leitor> leitores) {
        this.canal = canal;
        this.leitores = leitores;
    }

    public Canal getCanal() {
        return canal;
    }

    public List<Leitor> getLeitores() {
        return new ArrayList<>(this.leitores);
    }

    public boolean novoAssinante(Leitor leitor) {
       return this.leitores.add(leitor);
    }
}
