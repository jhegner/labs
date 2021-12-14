package br.com.jhegnerlabs.metrics;

import br.com.jhegnerlabs.domain.Autor;
import br.com.jhegnerlabs.domain.Canal;
import br.com.jhegnerlabs.domain.Noticia;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Tag;

import java.util.List;

public class Metrica {

    public void registraMetrica(MetricaType metrica, Noticia noticia) {
        Counter counter = Counter.builder(metrica.getMetrica())
                .description(metrica.getDescricao())
                .tags(List.of(
                        Tag.of("autor", noticia.getAutor().getNome().toLowerCase()),
                        Tag.of("mes", String.valueOf(noticia.getDataPublicacao().getMonthValue())),
                        Tag.of("ano", String.valueOf(noticia.getDataPublicacao().getYear()))
                ))
                .register(MetricaConfig.configure());
        counter.increment();
    }

    public void registraMetrica(MetricaType metrica, Autor autor) {
        Counter counter = Counter.builder(metrica.getMetrica())
                .description(metrica.getDescricao())
                .tags(List.of(
                        Tag.of("autor", autor.getNome().toLowerCase())
                ))
                .register(MetricaConfig.configure());
        counter.increment();
    }

    public void registraMetrica(MetricaType metrica, Canal canal) {
        Counter counter = Counter.builder(metrica.getMetrica())
                .description(metrica.getDescricao())
                .tags(List.of(
                        Tag.of("canal", canal.name().toLowerCase())
                ))
                .register(MetricaConfig.configure());
        counter.increment();
    }

}
