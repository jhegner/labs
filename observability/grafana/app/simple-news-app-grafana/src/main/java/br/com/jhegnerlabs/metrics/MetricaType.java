package br.com.jhegnerlabs.metrics;

public enum MetricaType {

    NOTICIAS("noticias", "Total de noticias publicadas por determinado autor com a informacao do ano e mes"),
    FAKE_NEWS("fakenews", "Total de noticias identificadas como fakenews e o autor da noticia"),
    CANAL_PUBLICACAO("canal", "Total de publicacoes num determinado canal");


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
