package br.com.jhegnerlabs.splunk;

import java.time.LocalDate;
import java.util.UUID;

public class Noticia {

    private final String noticiaId;
    private final String texto;
    private final LocalDate dataPublicacao;
    private final Autor autor;

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

    @Override
    public String toString() {
        return "Noticia{" +
                "noticiaId='" + noticiaId + '\'' +
                ", texto='" + texto + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                '}';
    }
}
