package br.com.jhegnerlabs.metrics;

import br.com.jhegnerlabs.httpserver.AppHttpServer;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.logging.LogbackMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public final class MetricaConfig {

    private static PrometheusMeterRegistry prometheusRegistry;

    private MetricaConfig() {
        super();
    }

    public static MeterRegistry configure() {

        if (null != prometheusRegistry) return prometheusRegistry;

        prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

        configureClassLoaderMetrics();
        configureJvmMemoryMetrics();
        configureJvmGcMetrics();
        configureJvmThreadMetrics();
        configureProcessorMetrics();
        configureLogBackMetrics();

        AppHttpServer.start(prometheusRegistry);

        return prometheusRegistry;
    }

    private static void configureLogBackMetrics() {
        LogbackMetrics logbackMetrics = new LogbackMetrics();
        logbackMetrics.bindTo(prometheusRegistry);
    }

    private static void configureProcessorMetrics() {
        ProcessorMetrics processorMetrics = new ProcessorMetrics();
        processorMetrics.bindTo(prometheusRegistry);
    }

    private static void configureJvmThreadMetrics() {
        JvmThreadMetrics jvmThreadMetrics = new JvmThreadMetrics();
        jvmThreadMetrics.bindTo(prometheusRegistry);
    }

    private static void configureJvmGcMetrics() {
        JvmGcMetrics jvmGcMetrics = new JvmGcMetrics();
        jvmGcMetrics.bindTo(prometheusRegistry);
    }

    private static void configureJvmMemoryMetrics() {
        JvmMemoryMetrics jvmMemoryMetrics = new JvmMemoryMetrics();
        jvmMemoryMetrics.bindTo(prometheusRegistry);
    }

    private static void configureClassLoaderMetrics() {
        ClassLoaderMetrics classLoaderMetrics = new ClassLoaderMetrics();
        classLoaderMetrics.bindTo(prometheusRegistry);
    }


}
