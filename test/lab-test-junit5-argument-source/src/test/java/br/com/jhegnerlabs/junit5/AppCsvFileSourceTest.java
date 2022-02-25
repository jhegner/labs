package br.com.jhegnerlabs.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppCsvFileSourceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/frutas.csv", numLinesToSkip = 1)
    void test_com_csv_file_source_1(String fruta, String calorias, String header) {
        assertNotNull(fruta);
        assertNotNull(calorias);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/frutas2.csv", numLinesToSkip = 1, delimiter = ';')
    void test_com_csv_file_source_2(String fruta, String calorias) {
        assertNotNull(fruta);
        assertNotNull(calorias);
    }

}
