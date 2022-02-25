package br.com.jhegnerlabs.junit5.provider;

import java.nio.charset.Charset;

public class JsonParserFactory {

    public static JsonParser createParseFor(JsonFileSource annotation, Charset charset) {
        return new JsonParser(charset);
    }

}
