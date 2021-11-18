package br.com.jhegnerlabs.payload;

import br.com.jhegnerlabs.splunk.Noticia;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PayloadNoticia {

    private final String noticiaId;
    private final String publicacaoId;
    private final String autor;
    private final String dataPublicacao;
    private final String canal;
    private final String texto;

    public PayloadNoticia(Noticia noticia) {
        this.noticiaId = noticia.getNoticiaId();
        this.publicacaoId = noticia.getPublicacao().getPublicacaoId();
        this.autor = noticia.getAutor().getNome();
        this.dataPublicacao = noticia.getDataPublicacao().toString();
        this.canal = noticia.getPublicacao().getCanal().toString().toLowerCase();
        this.texto = noticia.getTexto();
    }

    public String getNoticiaId() {
        return noticiaId;
    }

    public String getPublicacaoId() {
        return publicacaoId;
    }

    public String getAutor() {
        return autor;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCanal() {
        return canal;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
