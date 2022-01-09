package br.com.jhegnerlabs;

public enum Mensagem {

    MENSAGEM_1("PT", "Ola Mundo!!"),
    MENSAGEM_2("EN", "Hello World!!"),
    MENSAGEM_3("IT", "Ciao mondo!!"),
    MENSAGEM_4("FR", "Bonjour le monde!!"),
    MENSAGEM_5("ES", "Hola mundo!!");

    private final String idioma;
    private final String texto;

    Mensagem(String idioma, String texto) {
        this.idioma = idioma;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public String getIdioma() {
        return idioma;
    }
}
