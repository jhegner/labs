package br.com.jhegnerlabs.junit5.provider;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(JsonFileArgumentsProvider2.class)
public @interface JsonFileSource {

    String[] resources() default {};

    String[] files() default {};

    String encoding() default "UTF-8";

}
