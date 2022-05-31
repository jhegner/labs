package br.com.jhegnerlabs.fixturefactory;

import java.time.LocalDate;
import java.util.*;

import static br.com.jhegnerlabs.fixturefactory.Promocao.Oferta.SEM_OFERTA;

public class Promocao {

    private static final int IDADE_MENOR = 18;
    private static final Set<String> CIDADES_PROMOCAO = Set.of("São Paulo", "Rio de Janeiro", "Salvador");
    private static final int DEZ_ANOS = 10;

    public enum Oferta {SEM_OFERTA, VERAO_NA_SUA_CIDADE, MES_ANIVERSARIO, DEZ_ANOS_COMO_CLIENTE}

    public List<Oferta> confereOferta(Cliente cliente) {

        if (null == cliente || clienteMenorIdade(cliente)) {
            return List.of(SEM_OFERTA);
        }

        return oferta(cliente);

    }

    private List<Oferta> oferta(Cliente cliente) {

        var ofertas = new LinkedList<Oferta>();

        if (cliente.getEnderecoOptional().isPresent()
                && possuiCidadeCadastrada(cliente.getEnderecoOptional().get())
                && CIDADES_PROMOCAO.stream().anyMatch(e ->
                Objects.equals(e, cliente.getEnderecoOptional().orElseGet(Endereco::new).getCidade()))) {
            ofertas.add(Oferta.VERAO_NA_SUA_CIDADE);
        }

        if (mesAniversarioCliente(cliente)) {
            ofertas.add(Oferta.MES_ANIVERSARIO);
        }

        if (possuiDezAnosComoCliente(cliente)) {
            ofertas.add(Oferta.DEZ_ANOS_COMO_CLIENTE);
        }

        return (ofertas.isEmpty() ? List.of(SEM_OFERTA) : ofertas);
    }

    private boolean possuiDezAnosComoCliente(Cliente cliente) {
        return (LocalDate.now().getYear() - cliente.getDataCadastro().getYear()) >= DEZ_ANOS;
    }

    private boolean mesAniversarioCliente(Cliente cliente) {
        return cliente.getDataNascimento() != null &&
                LocalDate.now().getMonth() == cliente.getDataNascimento().getMonth();
    }

    private boolean possuiCidadeCadastrada(Endereco endereco) {
        return !endereco.getCidade().isEmpty();
    }

    private boolean clienteMenorIdade(Cliente cliente) {
        return (LocalDate.now().getYear() - cliente.getDataNascimento().getYear()) <= IDADE_MENOR;
    }

}
