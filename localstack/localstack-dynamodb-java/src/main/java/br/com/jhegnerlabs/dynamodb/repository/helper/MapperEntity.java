package br.com.jhegnerlabs.dynamodb.repository.helper;

import br.com.jhegnerlabs.dynamodb.entity.Documento;
import br.com.jhegnerlabs.dynamodb.entity.OrdemAssinatura;
import br.com.jhegnerlabs.dynamodb.entity.Processo;
import br.com.jhegnerlabs.dynamodb.entity.Signatario;
import br.com.jhegnerlabs.dynamodb.enums.EntityType;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.internal.PageIterable;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public final class MapperEntity {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public Processo mapItemToEntity(PageIterable<Item, QueryOutcome> pages) {

        for (Page<Item, QueryOutcome> page : pages) {

            return mapItemToEntity(page);

        }

        return Processo.builder().build();
    }

    private Processo mapItemToEntity(Page<Item, QueryOutcome> itensPage) {

//        Processo processo = new Processo();
//        List<Documento> documentos = new ArrayList<>();
//        OrdemAssinatura ordemAssinatura = new OrdemAssinatura();
//        List<Signatario> signatarios = new ArrayList<>();
//
//        for (Item item : itensPage) {
//
//            if (!item.hasAttribute("sort_key")) {
//                throw new IllegalStateException("Item da tabela nao possui atributo sort_key");
//            }
//
//            try {
//
//                final var sk = item.getString("sort_key");
//
//                if (sk.contains(EntityType.PROCESSO.getIdentifier())) {
//                    processo = objectMapper.readValue(item.toJSON(), Processo.class);
//                }
//                else if (sk.contains(EntityType.DOCUMENTO.getIdentifier())){
//                    documentos.add(objectMapper.readValue(item.toJSON(), Documento.class));
//                }
//                else if (sk.contains(EntityType.ORDEMASSINATURA.getIdentifier())){
//                     ordemAssinatura = objectMapper.readValue(item.toJSON(), OrdemAssinatura.class);
//                }
//                else if (sk.contains(EntityType.SIGNATARIO.getIdentifier())){
//                    signatarios.add(objectMapper.readValue(item.toJSON(), Signatario.class));
//                }
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        ordemAssinatura.setSignatarios(signatarios);
//        documentos.stream().findFirst()
//                .orElseThrow(() -> new IllegalStateException("Documentos nao encontrados para o processo informado"))
//                .setOrdemAssinatura(ordemAssinatura);
//        processo.setDocumentos(documentos);

        return new Processo();

    }


}
