package br.com.jhegnerlabs.dynamodb.repository.helper;

import br.com.jhegnerlabs.dynamodb.entity.Documento;
import br.com.jhegnerlabs.dynamodb.entity.OrdemAssinatura;
import br.com.jhegnerlabs.dynamodb.entity.Processo;
import br.com.jhegnerlabs.dynamodb.entity.Signatario;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.internal.PageIterable;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        Processo processo = new Processo();
        List<Documento> documentos = new ArrayList<>();
        OrdemAssinatura ordemAssinatura = new OrdemAssinatura();
        List<Signatario> signatarios = new ArrayList<>();

        for (Item item : itensPage) {

            if (!item.hasAttribute("sort_key")) {
                throw new IllegalStateException("Item da tabela nao possui atributo sort_key");
            }

            try {

                final var sk = item.getString("sort_key");

                if (sk.contains(Entitys.PROCESSO.identifier)) {
                    processo = this.objectMapper.readValue(item.toJSON(), Processo.class);
                }
                else if (sk.contains(Entitys.DOCUMENTO.identifier)){

                    var documento = this.objectMapper.readValue(item.toJSON(), Documento.class);
                    documentos.add(documento);
                }
                else if (sk.contains(Entitys.ORDEMASSINATURA.identifier)){

                     ordemAssinatura = this.objectMapper.readValue(item.toJSON(), OrdemAssinatura.class);

                }
                else if (sk.contains(Entitys.SIGNATARIO.identifier)){

                    var signatario = this.objectMapper.readValue(item.toJSON(), Signatario.class);
                    signatarios.add(signatario);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        ordemAssinatura.setSignatarios(signatarios);
        documentos.stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Documentos nao encontrados para o processo informado"))
                .setOrdemAssinatura(ordemAssinatura);
        processo.setDocumentos(documentos);

        return processo;

    }


}
