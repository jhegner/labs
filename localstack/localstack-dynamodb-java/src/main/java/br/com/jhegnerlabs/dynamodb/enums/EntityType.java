package br.com.jhegnerlabs.dynamodb.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EntityType {

    PROCESSO("#METADATA#"),
    DOCUMENTO("#DOCUMENTO#"),
    ORDEMASSINATURA("#ORDEMASSINATURA#"),
    SIGNATARIO("#SIGNATARIO#");

    private final String identifier;

    EntityType(String identifier) {
        this.identifier = identifier;
    }

    public static EntityType getBySortKeyValue(String sortedKey) {

        return Arrays.stream(EntityType.values())
                .filter(entityType -> sortedKey.contains(entityType.identifier))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException("Nao foi possivel identificar o type do item. valor do sortedkey invalido"));

    }
}
