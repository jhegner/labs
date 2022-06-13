package br.com.jhegnerlabs.dynamodb.repository.helper;

import br.com.jhegnerlabs.dynamodb.entity.Processo;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.internal.PageIterable;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class MapperEntity {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private enum Entitys {

        PROCESSO("#METADATA#"),
        DOCUMENTO("#DOCUMENTO#"),
        ORDEMASSINATURA("#ORDEMASSINATURA#"),
        SIGNATARIO("#SIGNATARIO#");

        private final String identifier;

        Entitys(String identifier) {
            this.identifier = identifier;
        }
    }

    public Processo mapItemToEntity(PageIterable<Item, QueryOutcome> pages) {

        for (Page<Item, QueryOutcome> page : pages) {

            return mapItemToEntity(page);

        }

        return Processo.builder().build();
    }

    private Processo mapItemToEntity(Page<Item, QueryOutcome> itensPage) {

        var processo = Processo.builder().build();

        for (Item item : itensPage) {

            try {

                final var sk = item.getString("sort_key");

                if (sk.contains(Entitys.PROCESSO.identifier)) {
                    processo = this.objectMapper.readValue(item.toJSON(), Processo.class);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return processo;

    }

}
