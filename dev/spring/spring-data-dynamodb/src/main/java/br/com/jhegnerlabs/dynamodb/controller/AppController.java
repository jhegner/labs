package br.com.jhegnerlabs.dynamodb.controller;

import br.com.jhegnerlabs.dynamodb.controller.request.RepresentanteRequest;
import br.com.jhegnerlabs.dynamodb.entity.Empresa;
import br.com.jhegnerlabs.dynamodb.entity.Representante;
import br.com.jhegnerlabs.dynamodb.entity.id.RepresentanteId;
import br.com.jhegnerlabs.dynamodb.mapper.RepresentanteMapper;
import br.com.jhegnerlabs.dynamodb.repository.EmpresaRepository;
import br.com.jhegnerlabs.dynamodb.repository.RepresentanteRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNullElse;
import static org.apache.commons.lang3.StringUtils.EMPTY;

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

        if (nonNull(nome)) {
            result = empresaRepository.findByNome(nome);
        } else if (nonNull(cnpj)) {
            result = empresaRepository.findByCnpj(cnpj);
        }

        return result.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }


    @GetMapping("/empresas/{id_empresa}/representantes/{id_representante}")
    public ResponseEntity<Representante> getRepresentante(
            @PathVariable("id_empresa") String idEmpresa,
            @PathVariable("id_representante") String idRepresentante) {

        log.info("Consultando representante - empresa:{}, representante:{}", idEmpresa, idRepresentante);

        var result = representanteRepository.findById(RepresentanteId.builder()
                .withIdPessoaJuridica(idEmpresa).withIdPessoaFisica(idRepresentante).build());

        return ResponseEntity.of(result);


    }

    @PostMapping("/empresas/{id_empresa}/representantes")
    public ResponseEntity<Void> postRepresentante(
            @PathVariable("id_empresa") String idEmpresa,
            @RequestBody RepresentanteRequest request) {

        var entity = RepresentanteMapper.INSTANCE.entityFromRequest(request, idEmpresa);

        this.representanteRepository.save(entity);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/representantes")
    public ResponseEntity<Representante> getRepresentantePorFiltros(
            @RequestParam(value = "id_empresa", required = false) String idEmpresa,
            @RequestParam(value = "id_representante", required = false) String idRepresentante,
            @RequestParam(value = "rg", required = false) String rg,
            @RequestParam(value = "cpf", required = false) String cpf) {

        Optional<Representante> entity;

        if (nonNull(rg)) {
            entity = this.representanteRepository.findByRg(rg);
        } else if (nonNull(cpf) && nonNull(idEmpresa)) {
            entity = this.representanteRepository.findByIdPessoaJuridicaAndCpf(idEmpresa, cpf);
        } else {
            entity = representanteRepository.findById(RepresentanteId.builder()
                    .withIdPessoaJuridica(requireNonNullElse(idEmpresa, "EMPTY"))
                    .withIdPessoaFisica(requireNonNullElse(idRepresentante, "EMPTY"))
                    .build());
        }

        return ResponseEntity.of(entity);

    }
}