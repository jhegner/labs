package br.com.jhegnerlabs;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetricaTest {

    @Test
    public void deveIncrementarMetricaComSucesso() {
        SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        Counter counter1 = Counter.builder("pessoa")
                .description("pessoas na sala")
                .tags("idade", "20", "pais", "brasil")
                .register(simpleMeterRegistry);

        counter1.increment();

        assertEquals(1, counter1.count());

        Counter counter2 = Counter.builder("pessoa")
                .description("pessoas na sala")
                .tags("idade", "22", "pais", "peru")
                .register(simpleMeterRegistry);

        counter2.increment();

        assertEquals(1, counter1.count());

    }

}
