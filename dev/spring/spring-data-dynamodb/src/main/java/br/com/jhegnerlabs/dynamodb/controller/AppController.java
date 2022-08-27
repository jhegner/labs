package br.com.jhegnerlabs.dynamodb.controller;

import br.com.jhegnerlabs.dynamodb.entity.Empresa;
import br.com.jhegnerlabs.dynamodb.entity.Representante;
import br.com.jhegnerlabs.dynamodb.entity.id.RepresentanteId;
import br.com.jhegnerlabs.dynamodb.repository.EmpresaRepository;
import br.com.jhegnerlabs.dynamodb.repository.RepresentanteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/dynamodbspringdata")
public class AppController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private RepresentanteRepository representanteRepository;

    @GetMapping("/empresas/{id_empresa}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id_empresa") String idEmpresa) {

        log.info("Consultando a empresa - {}", idEmpresa);

        var result = empresaRepository.findById(idEmpresa);

        return ResponseEntity.of(result);

    }

    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> getEmpresas(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "cnpj", required = false) String cnpj) {

        log.info("Consultando a empresa por filtros");

        List<Empresa> result = null;

        if (Objects.nonNull(nome)) {
            result = empresaRepository.findByNome(nome);
        } else if (Objects.nonNull(cnpj)) {
            result = empresaRepository.findByCnpj(cnpj);
        }

        return result.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }


    @GetMapping("/empresas/{id_empresa}/representantes/{id_representante}")
    public ResponseEntity<Representante> getRepresentante(
            @PathVariable("id_empresa") String idEmpresa,
            @PathVariable("id_representante") String idRepresentante) {

        log.info("Consultando representante - empresa:{}, representante:{}", idEmpresa, idRepresentante);

        var result = representanteRepository.findByIdPessoaJuridicaAndIdPessoaFisica(idEmpresa, idRepresentante);

        var result2 = representanteRepository.findById(RepresentanteId.builder()
                .withIdPessoaJuridica(idEmpresa).withIdPessoaFisica(idRepresentante).build());

        return ResponseEntity.of(result);

//        return  null;

    }

}
