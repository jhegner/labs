package br.com.jhegnerlabs;

import br.com.jhegnerlabs.dynamodb.repository.DocumentRepository;
import br.com.jhegnerlabs.dynamodb.repository.LowLevelRepository;

public class App {
    public static void main(String[] args) {
        new DocumentRepository().consultaProcesso(
                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
                "9817be8b-309c-417f-8ff9-fac96655a937");
    }
}
