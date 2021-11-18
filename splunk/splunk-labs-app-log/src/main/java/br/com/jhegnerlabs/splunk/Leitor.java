package br.com.jhegnerlabs.splunk;

import br.com.jhegnerlabs.payload.PayloadLeitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

public class Leitor {

    static Logger logger = LoggerFactory.getLogger(Leitor.class);

    private final String leitorId;
    private final String nome;

    public Leitor(String nome) {
        this.leitorId = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getLeitorId() {
        return leitorId;
    }

    public String getNome() {
        return nome;
    }

    public void le(Noticia noticia) {

        logger.info("Noticia recebida... lendo o text da noticia - {}", noticia.getTexto());

        MDC.put("payload", new PayloadLeitor(this, noticia).toString());
        logger.info("Payload leitor");
        MDC.remove("payload");

    }

}
