package br.com.jhegnerlabs.junit5.provider;

import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.InputStream;

@FunctionalInterface
public interface JsonSource {

    InputStream open(ExtensionContext context);

}
