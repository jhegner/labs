package br.com.jhegnerlabs.openfeign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.net.URI;

import static java.util.Objects.isNull;

@SpringBootApplication
@EnableFeignClients
public class AppBoot implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(AppBoot.class);

    @Autowired
    AppFeignClient client;

    public static void main(String[] args) {

        logger.info("STARTING THE APPLICATION");
        SpringApplication.run(AppBoot.class, args);
        logger.info("APPLICATION FINISHED");


    }

    @Override
    public void run(String... args) {

        logger.info("Hello From Feign");

        var response = client.postDesejo(Desejo.builder()
                .nome("Novo Amigo").build());


        if (isNull(response.getHeaders().getLocation())
                || isNull(response.getHeaders().getLocation().getPath())) {
            throw new IllegalStateException("Desejo de novo amigo nao realizado :(");
        }

        var idAmigo = getIdFromLocation(response.getHeaders().getLocation());

        var responseEntity = client.getDesejo(idAmigo);

        System.out.println(responseEntity.getBody());

//        System.out.println(idAmigo);
//        System.out.println(response.getHeaders());

    }

    private String getIdFromLocation(URI location) {

        if(null != location) {
            final String[] valuesPath = location.getPath().split("/");
            return valuesPath[valuesPath.length - 1];
        }

        return "";
    }
}
