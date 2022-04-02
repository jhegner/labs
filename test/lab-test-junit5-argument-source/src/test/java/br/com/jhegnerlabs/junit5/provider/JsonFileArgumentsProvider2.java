package br.com.jhegnerlabs.junit5.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.PreconditionViolationException;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class JsonFileArgumentsProvider2 implements ArgumentsProvider, AnnotationConsumer<JsonFileSource> {

    private JsonFileSource annotation;
    private Set<File> sources;
    private Charset charset;

    @Override
    public void accept(JsonFileSource annotation) {
        this.annotation = annotation;
        this.charset = getCharset(annotation);
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return null;
    }

    private Charset getCharset(JsonFileSource annotation) {
        try {
            return Charset.forName(annotation.encoding());
        } catch (Exception ex) {
            throw new PreconditionViolationException("O charset fornecido na anotacao [" + annotation + "] eh invalido", ex);
        }
    }
}
