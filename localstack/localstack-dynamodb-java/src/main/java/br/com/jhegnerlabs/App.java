package br.com.jhegnerlabs;

import br.com.jhegnerlabs.dynamodb.repository.DocumentRepository;
import br.com.jhegnerlabs.dynamodb.repository.HigherLevelRepository;
import br.com.jhegnerlabs.dynamodb.repository.LowLevelRepository;

public class App {

    public static void main(String[] args) {

        var empresa = new HigherLevelRepository().findEmpresa("7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c");
        System.out.println(empresa);

//        new LowLevelRepository().consultaProcesso(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937");
//        new DocumentRepository().consultaProcesso(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937");
    }
}
