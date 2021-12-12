package br.com.jhegnerlabs.metrics;

public enum MetricaTypeEnum {

    NOTICIAS("noticias", "quantidade de noticias publicadas");


    private final String metrica;
    private final String descricao;

    MetricaTypeEnum(String metrica, String descricao) {
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
