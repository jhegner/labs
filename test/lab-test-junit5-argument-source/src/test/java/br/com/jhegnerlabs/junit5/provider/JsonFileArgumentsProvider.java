package br.com.jhegnerlabs.junit5.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.Preconditions;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonFileArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonFileSource> {

    private final JsonInputStreamProvider inputStreamProvider;
    private JsonFileSource annotation;
    private List<JsonSource> sources;
    private JsonParser jsonParser;
    private Charset charset;

    JsonFileArgumentsProvider() {
        this(DefaultJsonInputStreamProvider.INSTANCE);
    }

    JsonFileArgumentsProvider(JsonInputStreamProvider inputStreamProvider) {
        this.inputStreamProvider = inputStreamProvider;
    }

    @Override
    public void accept(JsonFileSource annotation) {

        this.annotation = annotation;
        Stream<String> arquivosJsonPath = Arrays.stream(annotation.resources());
        JsonInputStreamProvider provider = this.inputStreamProvider;

        Objects.requireNonNull(arquivosJsonPath);

        Stream<JsonSource> recursos = arquivosJsonPath.map(provider::classPathResource);
        arquivosJsonPath = Arrays.stream(annotation.files());

        Objects.requireNonNull(arquivosJsonPath);

        this.charset = this.getCharset(annotation);
        Stream<JsonSource> arquivosJsonSource = arquivosJsonPath.map(provider::file);
        this.sources = Stream.concat(recursos, arquivosJsonSource).collect(Collectors.toList());
        this.jsonParser = JsonParserFactory.createParseFor(annotation, this.charset);
    }

    private Charset getCharset(JsonFileSource annotation) {
        try {
            return Charset.forName(annotation.encoding());
        } catch (Exception ex) {
            throw new PreconditionViolationException("O charset fornecido na anotacao [" + annotation + "] eh invalido", ex);
        }
    }

    @Override
    public Consumer<JsonFileSource> andThen(Consumer<? super JsonFileSource> after) {
        System.out.println(after);
        return AnnotationConsumer.super.andThen(after);
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return Preconditions.notEmpty(this.sources,
                        "Os recursos ou arquivos nao devem ser vazios")
                .stream()
                .map(source -> source.open(context))
                .map(this.jsonParser::readJsonStream);
    }
}
