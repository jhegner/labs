package br.com.jhegnerlabs.metrics;

import br.com.jhegnerlabs.httpserver.AppHttpServer;
import com.sun.net.httpserver.HttpServer;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Metrica {

    private final static PrometheusMeterRegistry prometheusRegistry;

    static {
        prometheusRegistry = AppHttpServer.getPrometheusRegistry();
    }

    public void registraMetrica(MetricaType metrica, String autor, LocalDate dataNoticia) {
        Counter counter = Counter.builder(metrica.getMetrica())
                .description(metrica.getDescricao())
                .tags(List.of(
                        Tag.of("autor", autor.toLowerCase()),
                        Tag.of("data", dataNoticia.format(DateTimeFormatter.ISO_DATE))
                ))
                .register(prometheusRegistry);
        counter.increment();
    }

}
