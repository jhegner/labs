# Grafana (monitoramento / observabilidade)

https://www.youtube.com/watch?v=0n2UNzk2OaI

### Links uteis

https://eclipse-ee4j.github.io/jersey/
https://www.youtube.com/watch?v=0n2UNzk2OaI
https://www.youtube.com/watch?v=7gW5pSM6dlU
https://www.youtube.com/watch?v=HIUoeLYWo7o
https://www.youtube.com/watch?v=ldeb_DaH49U
https://micrometer.io/docs/registry/prometheus#_configuring
https://www.tutorialworks.com/spring-boot-prometheus-micrometer/
https://medium.com/@luanrubensf/monitoring-spring-applications-with-prometheus-and-grafana-ae50bbdd1920
https://www.baeldung.com/micrometer
https://prometheus.io/docs/visualization/grafana/
https://www.mokkapps.de/blog/monitoring-spring-boot-application-with-micrometer-prometheus-and-grafana-using-custom-metrics/

### Configuracao

prometheus.yaml (arquivo de configuracao)

global:
    scrape_interval: 10s # How frequently to scrape targets by default
  
scrape_configs:
    - job_name: 'simple_news_app_micrometer'  # The job name is assigned to scraped metrics by default.
      metrics_path: '/metrics'    # The HTTP resource path on which to fetch metrics from targets.
      scrape_interval: 5s                     # How frequently to scrape targets from this job.
      static_configs:                         # A static_config allows specifying a list of targets and a common label set for them
        - targets: ['192.168.0.10:8080']

---- fim conf

docker run \
    -p 9090:9090 \
    -v /path/to/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus
	
docker run -d -p 3000:3000 grafana/grafana
