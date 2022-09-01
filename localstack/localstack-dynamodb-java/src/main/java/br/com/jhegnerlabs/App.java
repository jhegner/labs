package br.com.jhegnerlabs;

import br.com.jhegnerlabs.dynamodb.repository.EnhancedClientRepository;
import br.com.jhegnerlabs.dynamodb.repository.ProcessoRepository;
import br.com.jhegnerlabs.dynamodb.repository.builder.CodigoChaveOrdenacao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {

//        var empresa = new HigherLevelRepository().findEmpresa("7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c");

//        var empresa = new HigherLevelRepository().findProcesso(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937");
//
        var objs = new ProcessoRepository().findProcesso(
                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
                "9817be8b-309c-417f-8ff9-fac96655a937");

        log.info("Controle processo empresa - {}", objs);

//        OrdemAssinaturaRepository ordemAssinaturaRepository = new OrdemAssinaturaRepository();
//
//        var ordem = ordemAssinaturaRepository.findOrdemAssinatura(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937",
//                "c68f5bfe-fe7e-4c22-9db4-364eb894d9d0");
//
//        ordem.setDataHoraAssinatura(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//
//        var ordemAtualizada =
//                ordemAssinaturaRepository.updateOrdemAssinatura(ordem,"9817be8b-309c-417f-8ff9-fac96655a937");
//
//        System.out.println(ordemAtualizada);

//        new LowLevelRepository().consultaProcesso(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937");
//        new DocumentRepository().consultaProcesso(
//                "e86fcdfb-c200-4737-8b1c-7923e25e0843",
//                "9817be8b-309c-417f-8ff9-fac96655a937");

//        EnhancedClientRepository enhancedClientRepository = new EnhancedClientRepository();

//        var cpe = enhancedClientRepository.consultaProcesso(
//                "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c",
//                "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8");
//        log.info("Controle do Processo - {}", cpe);

//        var documento = enhancedClientRepository.consultaDocumento(
//                "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c",
//                CodigoChaveOrdenacao.builder()
//                        .withIdProcesso("89e27526-3de1-4dd1-bbc4-50f0eb6604b8")
//                        .withIdDocumento("585f658a-5609-4608-8d14-66c0172d0bec")
//                        .build()
////                "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#DOCUMENTO#585f658a-5609-4608-8d14-66c0172d0bec"
//        );

//        log.info("Documento do processo - {}", documento);


    }
}
