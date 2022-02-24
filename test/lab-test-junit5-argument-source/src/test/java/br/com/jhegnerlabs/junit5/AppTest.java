package br.com.jhegnerlabs.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @ParameterizedTest
    @CsvSource({
            "banana, 10",
            "pera, 5",
            "uva, 14"
    })
    void test_com_csv_source_1(String fruta, int quantidade) {
        assertNotNull(fruta);
        assertNotEquals(0, quantidade);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "banana#10",
            "pera#5",
            "uva#14"
    }, delimiter = '#')
    void test_com_csv_source_2(String fruta, int quantidade) {
        assertNotNull(fruta);
        assertNotEquals(0, quantidade);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "banana@10",
            "pera@5",
            "uva@14"
    }, delimiterString = "@")
    void test_com_csv_source_3(String fruta, int quantidade) {
        assertNotNull(fruta);
        assertNotEquals(0, quantidade);
    }

    @ParameterizedTest
//    @CsvSource(value = {"uva, abacaxi"})
    @CsvSource({ "apple, 'lemon, lime'" })
    void test_com_csv_source_4(String fruta1, String fruta2) {
        assertNotEquals(fruta1, fruta2);
    }

    @ParameterizedTest
    @CsvSource({"'pera', "})
    void test_com_csv_source_5(String fruta1, String fruta2) {
        assertNotEquals(fruta1, fruta2);
        assertNull(fruta2);
    }

    @ParameterizedTest
    @CsvSource(value = { " maça, kiwi, ###, NULL, uva" }, nullValues = {"AAA", "###", "NULL"})
    void test_com_csv_source_6(String fruta1, String fruta2, String fruta3, String fruta4, String fruta5) {
        assertNotNull(fruta1);
        assertNotNull(fruta2);
        assertNull(fruta3);
        assertNull(fruta4);
        assertNotNull(fruta5);
    }

    @ParameterizedTest
    @CsvSource(value = {"'pera      ', 'pera'"}, ignoreLeadingAndTrailingWhitespace = false)
    void test_com_csv_source_7(String fruta1, String fruta2) {
        assertNotEquals(fruta1, fruta2);
    }




}