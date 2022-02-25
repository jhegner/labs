package br.com.jhegnerlabs.junit5;

import br.com.jhegnerlabs.junit5.data.Fruta;
import br.com.jhegnerlabs.junit5.provider.JsonFileSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppJsonFileSourceTest {

    @ParameterizedTest
    @JsonFileSource(resources = "/frutas.json")
    void test_com_json_file_source_1(List<Fruta> frutas) {
        assertNotNull(frutas);
    }

}
