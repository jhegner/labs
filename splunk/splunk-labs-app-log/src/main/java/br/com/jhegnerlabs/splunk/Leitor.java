package br.com.jhegnerlabs.splunk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Leitor {

    static Logger logger = LoggerFactory.getLogger(Leitor.class);

    private final String leitorId;
    private final String nome;

    Leitor(String nome) {
        this.leitorId = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getLeitorId() {
        return leitorId;
    }

    public void le(Noticia noticia, Canal canal) {
        logger.info("Noticia recebida pelo leitorId={} - canal={} - noticiaId={} - dataNoticia={} - noticia:{}",
                this.leitorId, canal.name().toLowerCase(),
                noticia.getNoticiaId(),
                noticia.getDataPublicacao(),
                noticia);
    }

}
