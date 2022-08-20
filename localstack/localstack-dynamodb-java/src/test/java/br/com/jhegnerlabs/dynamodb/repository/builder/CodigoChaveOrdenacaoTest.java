package br.com.jhegnerlabs.dynamodb.repository.builder;

import org.junit.Assert;
import org.junit.Test;

public class CodigoChaveOrdenacaoTest {

    @Test
    public void deve_construir_chave_ordenacao_do_processo() {

        var chaveOrdenacao = CodigoChaveOrdenacao.builder()
                .withIdProcesso("89e27526-3de1-4dd1-bbc4-50f0eb6604b8")
                .withProcessoMetadata()
                .build().toString();

        Assert.assertEquals("PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#METADATA#", chaveOrdenacao);

    }

    @Test
    public void deve_construir_chave_ordenacao_do_documento() {

        var chaveOrdenacao = CodigoChaveOrdenacao.builder()
                .withIdDocumento("585f658a-5609-4608-8d14-66c0172d0bec")
                .withIdProcesso("89e27526-3de1-4dd1-bbc4-50f0eb6604b8")
                .build().toString();

        Assert.assertEquals(
                "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#DOCUMENTO#585f658a-5609-4608-8d14-66c0172d0bec",
                chaveOrdenacao);

    }

}