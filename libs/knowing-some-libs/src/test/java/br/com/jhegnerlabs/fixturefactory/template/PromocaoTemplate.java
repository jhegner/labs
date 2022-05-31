package br.com.jhegnerlabs.fixturefactory.template;

import br.com.jhegnerlabs.fixturefactory.Cliente;
import br.com.jhegnerlabs.fixturefactory.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.time.LocalDate;

public class PromocaoTemplate implements TemplateLoader {

    public static final String CLIENTE_MENOR_IDADE_INVALIDO = "CLIENTE_MENOR_IDADE_INVALIDO";
    public static final String CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_COM_MENOS_DEZ_ANOS_CADASTRO = "CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_COM_MENOS_DEZ_ANOS_CADASTRO";
    public static final String CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES = "CLIENTE_MAIOR_COM_CIDADE_FORA_OFERTA_FAZENDO_ANIVERSARIO";
    public static final String CLIENTE_MAIOR_COM_CIDADE_NA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES = "CLIENTE_MAIOR_COM_CIDADE_NA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES";
    public static final String ENDERECO_COM_CIDADE_DA_PROMOCAO_VALIDO = "ENDERECO_COM_CIDADE_DA_PROMOCAO_VALIDO";
    public static final String ENDERECO_COM_CIDADE_FORA_PROMOCAO = "ENDERECO_COM_CIDADE_PROMOCAO_VALIDO";

    @Override
    public void load() {

        Fixture.of(Cliente.class).addTemplate(CLIENTE_MENOR_IDADE_INVALIDO, new Rule() {
            {
                add("dataNascimento", LocalDate.of(2005, 5, 10));
            }
        });

//        Fixture.of(Cliente.class).addTemplate(CLIENTE_MENOR_IDADE_INVALIDO, new Rule() {
//            {
//                add("id", random("1111111111", "22222222222", "33333333"));
//                add("nome", random("Paulo Caroso", "Lina Alves"));
//                add("apelido", random("Paulo Caroso", "Lina Alves"));
//                add("email", "${apelido}@gmail.com");
//                add("dataNascimento", LocalDate.of(2005, 5, 10));
//                add("dataCadastro", LocalDate.of(2012, 8, 5));
//                add("endereco", one(Endereco.class, ENDERECO_COM_CIDADE_DA_PROMOCAO_VALIDO));
//            }
//        });

        Fixture.of(Cliente.class).addTemplate(CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES, new Rule() {
            {
                add("dataNascimento", LocalDate.of(1993, 2, 10));
                add("dataCadastro", LocalDate.of(2019, 5, 14));
                add("endereco", one(Endereco.class, ENDERECO_COM_CIDADE_FORA_PROMOCAO));
            }
        });

        Fixture.of(Cliente.class).addTemplate(CLIENTE_MAIOR_COM_CIDADE_FORA_PROMOCAO_COM_MENOS_DEZ_ANOS_CADASTRO, new Rule() {
            {
                add("dataNascimento", LocalDate.of(1993, 10, 10));
                add("dataCadastro", LocalDate.of(2015, 5, 14));
                add("endereco", one(Endereco.class, ENDERECO_COM_CIDADE_FORA_PROMOCAO));
            }
        });

        Fixture.of(Cliente.class).addTemplate(CLIENTE_MAIOR_COM_CIDADE_NA_PROMOCAO_FAZENDO_ANIVERSARIO_NO_MES, new Rule() {
            {
                add("dataNascimento", LocalDate.of(1970, 12, 16));
                add("dataCadastro", LocalDate.of(1999, 1, 22));
                add("endereco", one(Endereco.class, ENDERECO_COM_CIDADE_DA_PROMOCAO_VALIDO));
            }
        });

        Fixture.of(Endereco.class).addTemplate(ENDERECO_COM_CIDADE_DA_PROMOCAO_VALIDO, new Rule() {{
            add("id", random("33333333", "4444444", "555555"));
            add("rua", random("Rua do Cala Boca", "Avenida do Fundo"));
            add("cidade", "São Paulo");
            add("estado", "${cidade}");
            add("pais", "Brasil");
            add("cep", random("06608000", "17720000"));
        }});

        Fixture.of(Endereco.class).addTemplate(ENDERECO_COM_CIDADE_FORA_PROMOCAO, new Rule() {{
            add("id", random("2353252", "554222", "2532323"));
            add("rua", random("Rua do 2 Palito", "Estrada Engº Arruda", "PQ Vila Antonio"));
            add("cidade", "Belo Horizonte");
            add("estado", "${cidade}");
            add("pais", "Brasil");
            add("cep", random("234234234", "543543532", "323542545"));
        }});
    }
}
