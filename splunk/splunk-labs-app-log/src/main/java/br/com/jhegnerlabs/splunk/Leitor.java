package br.com.jhegnerlabs.splunk;

import br.com.jhegnerlabs.log.LogLeitorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        logger.info("Noticia recebida... lendo noticia");
        logger.info("Payload leitor - {}", new LogLeitorDTO(this, noticia));
    }

}
