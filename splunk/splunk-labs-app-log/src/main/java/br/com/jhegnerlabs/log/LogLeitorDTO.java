package br.com.jhegnerlabs.log;

import br.com.jhegnerlabs.splunk.Leitor;
import br.com.jhegnerlabs.splunk.Noticia;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LogLeitorDTO {

    private final String leitorId;
    private final String nome;
    private final String noticiaId;
    private final String canal;

    public LogLeitorDTO(Leitor leitor, Noticia noticia) {
        this.leitorId = leitor.getLeitorId();
        this.nome = leitor.getNome();
        this.noticiaId = noticia.getNoticiaId();
        this.canal = noticia.getPublicacao().getCanal().toString().toLowerCase();
    }

    public String getLeitorId() {
        return leitorId;
    }

    public String getNome() {
        return nome;
    }

    public String getNoticiaId() {
        return noticiaId;
    }

    public String getCanal() {
        return canal;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
