package br.com.jhegnerlabs.dynamodb.repository.helper;

import br.com.jhegnerlabs.dynamodb.entity.*;
import br.com.jhegnerlabs.dynamodb.enums.EntityType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.internal.PageIterable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class MapperEntity2 {


    public Optional<ControleProcessoEmpresa> mapItemToEntity(PageIterable<Item, QueryOutcome> pages) {

        for (Page<Item, QueryOutcome> page : pages) {
            return Optional.ofNullable(mapItemToEntity(page));
        }

        return Optional.empty();
    }

    private ControleProcessoEmpresa mapItemToEntity(Page<Item, QueryOutcome> itensPage) {

        var objectMapper = new ObjectMapper();

        Set<Documento> documentos = new HashSet<>();
        Set<Signatario> signatarios = new HashSet<>();

        var builder = ControleProcessoEmpresa.builder();

        for (Item item : itensPage) {

            if (!item.hasAttribute("sort_key")) {
                throw new IllegalStateException("Item da tabela nao possui atributo sort_key");
            }

            try {

                final var entityType = EntityType.getBySortKeyValue(item.getString("sort_key"));

                switch (entityType) {
                    case PROCESSO -> builder.withProcesso(objectMapper.readValue(item.toJSON(), Processo.class));
                    case DOCUMENTO -> documentos.add((objectMapper.readValue(item.toJSON(), Documento.class)));
                    case ORDEMASSINATURA ->
                            builder
                            .withOrdemAssinatura(objectMapper.readValue(item.toJSON(), OrdemAssinatura.class));
                    case SIGNATARIO -> signatarios.add((objectMapper.readValue(item.toJSON(), Signatario.class)));
                }

            } catch (IOException ex) {
                throw new IllegalStateException("Erro na consulta do processo da empresa", ex);
            }
        }

        return builder
                .withDocumentos(documentos)
                .withSignatarios(signatarios).build();

    }


}
