package br.com.jhegnerlabs.junit5.provider;

import java.io.InputStream;

public interface JsonInputStreamProvider {

    InputStream openClasspathResource(Class<?> clazz, String var2);

    InputStream openFile(String var1);

    default JsonSource classPathResource(String path) {
        return (context -> this.openClasspathResource(context.getRequiredTestClass(), path));
    }

    default JsonSource file(String path) {
        return (context -> this.openFile(path));
    }


}
