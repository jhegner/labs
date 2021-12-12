package br.com.jhegnerlabs.payload;

import br.com.jhegnerlabs.domain.Leitor;
import br.com.jhegnerlabs.domain.Noticia;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PayloadLeitor {

    private final String leitorId;
    private final String nome;
    private final String noticiaId;
    private final String canal;

    public PayloadLeitor(Leitor leitor, Noticia noticia) {
        this.leitorId = leitor.getLeitorId();
        this.nome = leitor.getNome();
        this.noticiaId = noticia.getNoticiaId();
        this.canal = noticia.getPublicacao().getCanal().toString().toLowerCase();
    }

    public String getLeitorId() {
        return leitorId;
    }

    public String getNome() {
        return nome;
    }

    public String getNoticiaId() {
        return noticiaId;
    }

    public String getCanal() {
        return canal;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
