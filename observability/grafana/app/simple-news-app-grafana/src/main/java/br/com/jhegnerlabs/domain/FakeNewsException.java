package br.com.jhegnerlabs.domain;

public class FakeNewsException extends Exception {

    private final Noticia noticia;

    public FakeNewsException(String message, Noticia noticia) {
        super(message);
        this.noticia = noticia;
    }

    public Noticia getNoticia() {
        return noticia;
    }
}
