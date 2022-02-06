package br.com.jhegnerlabs.fixturefactory;

import br.com.jhegnerlabs.fixturefactory.template.PromocaoTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class FixtureTest {

    @BeforeAll
    public static void beforeAll() {
        FixtureFactoryLoader.loadTemplates("br.com.jhegnerlabs.fixturefactory.template");
    }

    @Test
    public void nao_deve_ofertecer_promocao_cliente() {

        // GiVEN
        Cliente cliente1 = Fixture.from(Cliente.class).gimme(PromocaoTemplate.CLIENTE_MENOR_IDADE_INVALIDO);
        Cliente cliente2 = Fixture.from(Cliente.class).gimme(PromocaoTemplate.CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_COM_MENOS_DEZ_ANOS_CADASTRO);

        var promocao = new Promocao();

        // WHEN
        var ofertas1 = promocao.confereOferta(cliente1);
        var ofertas2 = promocao.confereOferta(cliente2);

        // THEN
        Assertions.assertEquals(1, ofertas1.size());
        Assertions.assertEquals(Promocao.Oferta.SEM_OFERTA, ofertas1.get(0));

        Assertions.assertEquals(1, ofertas2.size());
        Assertions.assertEquals(Promocao.Oferta.SEM_OFERTA, ofertas2.get(0));

    }

    @Test
    public void deve_ofertecer_promocao_cliente() {


        // GiVEN
        Cliente cliente2 = Fixture.from(Cliente.class).gimme(PromocaoTemplate.CLIENTE_MAIOR_COM_CIDADE_NA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES);

        var promocao = new Promocao();

        // WHEN
        var ofertas2 = promocao.confereOferta(cliente2);

        // THEN
        Assertions.assertEquals(2, ofertas2.size());
        Assertions.assertEquals(Stream.of(Promocao.Oferta.DEZ_ANOS_COMO_CLIENTE, Promocao.Oferta.VERAO_NA_SUA_CIDADE).sorted().toList(), ofertas2.stream().sorted().toList());

    }

}