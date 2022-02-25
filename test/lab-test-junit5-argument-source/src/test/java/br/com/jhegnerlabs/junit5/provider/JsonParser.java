package br.com.jhegnerlabs.junit5.provider;

import br.com.jhegnerlabs.junit5.data.Fruta;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JsonParser {

    private Charset charset;

    public JsonParser(Charset charset) {
        this.charset = charset;
    }

    public Arguments readJsonStream(InputStream is) {

        try {
            var reader = new JsonReader(new InputStreamReader(is, this.charset));
            return readPayloadArray(reader);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    private Arguments readPayloadArray(JsonReader reader) throws IOException {

        var frutas = new ArrayList<Fruta>();

//        reader.beginArray();

        while (reader.hasNext()) {
            frutas.add(getFrutaPayload(reader));
        }
//        reader.endArray();

        return Arguments.of(frutas);

    }

    private Fruta getFrutaPayload(JsonReader reader) throws IOException {

        String nome = "";
        String calorias = "";

        reader.beginObject();

        while (reader.hasNext()) {
            var fieldName = reader.nextName();
            if (fieldName.equals("nome")) {
                nome = reader.nextString();
            } else if (fieldName.equals("calorias")) {
                calorias = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Fruta(nome, calorias);
    }
}
