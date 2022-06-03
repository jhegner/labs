package br.com.jhegnerlabs.app;

import br.com.jhegnerlabs.domain.*;
import br.com.jhegnerlabs.httpserver.AppHttpServer;
import br.com.jhegnerlabs.metrics.Metrica;
import br.com.jhegnerlabs.metrics.MetricaType;
import br.com.jhegnerlabs.payload.PayloadNoticia;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Arrays;
import java.util.List;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    private static final Canal[] canais = new Canal[4];

    private static final Leitor[] leitores = new Leitor[6];

    static {

        canais[0] = Canal.EMAIL;
        canais[1] = Canal.SMS;
        canais[2] = Canal.JORNAL;
        canais[3] = Canal.REVISTA;

        leitores[0] = new Leitor("Dunga");
        leitores[1] = new Leitor("Bebeto");
        leitores[2] = new Leitor("Romario");
        leitores[3] = new Leitor("Cafu");
        leitores[4] = new Leitor("Ronaldo");
        leitores[5] = new Leitor("Kaka");
    }

    public static void main(String[] args) {

        logger.info("***** Iniciando a aplicacao *****");

        Assinatura assinatura1 = new Assinatura(Canal.EMAIL,
                Arrays.asList(leitores[0], leitores[1], leitores[2]));

        Assinatura assinatura2 = new Assinatura(Canal.SMS,
                Arrays.asList(leitores[1], leitores[3]));

        Assinatura assinatura3 = new Assinatura(Canal.REVISTA,
                Arrays.asList(leitores[2], leitores[4]));

        Assinatura assinatura4 = new Assinatura(Canal.JORNAL,
                Arrays.asList(leitores[5], leitores[4], leitores[1]));

        List<Assinatura> assinaturas = Arrays.asList(
                assinatura1,
                assinatura2,
                assinatura3,
                assinatura4);

        for (int i = 0; i < 2000; i++) {

            Publicacao publicacao = new Publicacao(getCanal());

            try {

                MDC.put("transaction_id", publicacao.getPublicacaoId());
                Noticia noticia = publicacao.nova();

                new Metrica().registraMetrica(MetricaType.CANAL_PUBLICACAO, noticia.getPublicacao().getCanal());

                MDC.put("payload", new PayloadNoticia(noticia).toString());
                logger.info("Payload da noticia");
                MDC.remove("payload");

                new Metrica().registraMetrica(MetricaType.NOTICIAS, noticia);

                assinaturas.forEach(assinatura -> {
                    if (assinatura.getCanal() == publicacao.getCanal()) {
                        assinatura.getLeitores().forEach(leitor -> leitor.le(noticia));
                    }
                });

            } catch (FakeNewsException ex) {
                logger.error("Erro na publicacao da noticia", ex);
                new Metrica().registraMetrica(MetricaType.FAKE_NEWS, ex.getNoticia().getAutor());
            }
        }
    }

    private static Canal getCanal() {
        return canais[RandomUtils.nextInt(0, 4)];
    }
}
