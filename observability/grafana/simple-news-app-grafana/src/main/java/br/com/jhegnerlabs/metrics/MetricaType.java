package br.com.jhegnerlabs.metrics;

public enum MetricaType {

    NOTICIAS("noticias", "quantidade de noticias publicadas");


    private final String metrica;
    private final String descricao;

    MetricaType(String metrica, String descricao) {
        this.metrica = metrica;
        this.descricao = descricao;
    }

    public String getMetrica() {
        return metrica;
    }

    public String getDescricao() {
        return descricao;
    }

}
