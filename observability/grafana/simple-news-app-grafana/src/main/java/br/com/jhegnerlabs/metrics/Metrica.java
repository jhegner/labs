package br.com.jhegnerlabs.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Metrica {

    private final CompositeMeterRegistry registry;

    public Metrica() {
        CompositeMeterRegistry registry = new CompositeMeterRegistry();
        registry.add(new SimpleMeterRegistry());
        registry.add(new PrometheusMeterRegistry(configPrometheus()));
        this.registry = registry;
    }

    private static PrometheusConfig configPrometheus() {
        return PrometheusConfig.DEFAULT;
    }

    public void registraMetrica(MetricaTypeEnum metrica, String autor, LocalDate dataNoticia) {
        Counter counter = Counter.builder(metrica.getMetrica())
                .description(metrica.getDescricao())
                .tags(List.of(
                        Tag.of("autor", autor.toLowerCase()),
                        Tag.of("data", dataNoticia.format(DateTimeFormatter.ISO_DATE))
                ))
                .register(this.registry);
        counter.increment();
    }

}
