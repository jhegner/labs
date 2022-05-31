package br.com.jhegnerlabs.junit5;

import br.com.jhegnerlabs.junit5.provider.MyArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppArgumentsSourceTest {

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void test_com_argument_source_1(String argument) {
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01-01-2017", "31-12-2017"})
    void test_com_argument_source_2(@JavaTimeConversionPattern("dd-MM-yyyy") LocalDate argument) {
        assertNotNull(argument);
    }

}
