package br.com.jhegnerlabs.junit5.provider;

import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultJsonInputStreamProvider implements JsonInputStreamProvider {

    protected static final DefaultJsonInputStreamProvider INSTANCE
            = new DefaultJsonInputStreamProvider();

    private DefaultJsonInputStreamProvider() {
        super();
    }

    @Override
    public InputStream openClasspathResource(Class<?> clazz, String path) {

        Preconditions.notBlank(path, () -> "O caminho do recurso [" + path + "] nao pode ser nulo ou vazio");

        var is = clazz.getResourceAsStream(path);

        return Preconditions.notNull(is, () -> "O caminho do recurso [" + path + "] nao existe");
    }

    @Override
    public InputStream openFile(String path) {

        Preconditions.notBlank(path, () -> "Arquivo [" + path + "] nao pode ser nulo ou vazio");

        try {
            return Files.newInputStream(Paths.get(path));
        } catch (IOException ex) {
            throw new JUnitException("Arquivo [" + path + "] nao pode ser lido ou carregado", ex);
        }
    }
}
