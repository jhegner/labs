package br.com.jhegnerlabs.regex;

import javax.swing.text.MaskFormatter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Formatter;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) throws ParseException {

        var cpf_v1 = "00024698756332";

        System.out.println(cpf_v1);

        var cpf_v2 = cpf_v1.substring(3);

        System.out.println(cpf_v2);

        var centralPart = cpf_v2.substring(3, 9);

        System.out.println(centralPart);

        var replacedCpf = cpf_v2.replace(centralPart, "******");

        System.out.println(replacedCpf);

        MaskFormatter formatter = new MaskFormatter("###.###.###-##");
        formatter.setValueContainsLiteralCharacters(false);

        var formated = formatter.valueToString(cpf_v2);

        System.out.println(formated);

        var formated_v1_parts = formated.split("\\.");

        var formated_final = formated_v1_parts[0] + "." +
                "***.***-" + formated.split("-")[1];

        System.out.println(formated_final);

    }
}
