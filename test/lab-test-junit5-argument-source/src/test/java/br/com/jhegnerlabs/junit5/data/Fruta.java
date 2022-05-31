package br.com.jhegnerlabs.junit5.data;

public class Fruta {

    private final String nome;
    private final String calorias;

    public Fruta(String nome, String calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public String getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nome='" + nome + '\'' +
                ", calorias='" + calorias + '\'' +
                '}';
    }
}
