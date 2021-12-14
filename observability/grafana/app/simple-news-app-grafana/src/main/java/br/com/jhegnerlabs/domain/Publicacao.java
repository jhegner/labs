package br.com.jhegnerlabs.domain;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public class Publicacao {

    static final Logger logger = LoggerFactory.getLogger(Publicacao.class);

    private final String publicacaoId;
    private final Canal canal;

    public Publicacao(Canal canal) {
        this.publicacaoId = UUID.randomUUID().toString();
        this.canal = canal;
    }

    private static final Autor[] autores = new Autor[5];

    static {
        autores[0] = new Autor("Cebolinha");
        autores[1] = new Autor("Monica");
        autores[2] = new Autor("Chico Bento");
        autores[3] = new Autor("Magali");
        autores[4] = new Autor("Bidu");
    }

    public Noticia nova() throws FakeNewsException {

        Noticia noticia = new Noticia(getDataPublicacao(), getTexto(), getAutor());

        logger.info("Publicando nova noticia");

        if (isFakeNews(noticia)) {
            throw new FakeNewsException("Noticia identificada como fakenews", noticia);
        }

        logger.info("Publicacao realizada com suceso");

        noticia.setPublicacao(this);

        return noticia;
    }

    private boolean isFakeNews(Noticia noticia) {
        logger.info("Verificando se noticia eh fakenews");
        return RandomUtils.nextBoolean();
    }

    private String getTexto() {
        return new Faker().chuckNorris().fact();
    }

    private LocalDate getDataPublicacao() {

        final LocalDate hoje = LocalDate.now();
        final LocalDate trintaDiasAtras = hoje.minusDays(30L);

        final Date dateHoje = Date.from(hoje.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        final Date dateTrintaDiasAtras = Date.from(trintaDiasAtras.atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());

        final Date fakeDate = new Faker().date().between(dateTrintaDiasAtras, dateHoje);

        return Instant.ofEpochMilli(fakeDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private Autor getAutor() {
        return autores[RandomUtils.nextInt(0, 5)];
    }

    public Canal getCanal() {
        return canal;
    }

    public String getPublicacaoId() {
        return publicacaoId;
    }
}
