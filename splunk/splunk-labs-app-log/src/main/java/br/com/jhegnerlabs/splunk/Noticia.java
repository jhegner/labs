package br.com.jhegnerlabs.splunk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.UUID;

public class Noticia {

    private final String noticiaId;
    private final String texto;
    private final LocalDate dataPublicacao;
    private final Autor autor;
    private Publicacao publicacao;

    public Noticia(LocalDate dataPublicacao, String texto, Autor autor) {
        this.noticiaId = UUID.randomUUID().toString();
        this.dataPublicacao = dataPublicacao;
        this.texto = texto;
        this.autor = autor;
    }

    public String getNoticiaId() {
        return noticiaId;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
