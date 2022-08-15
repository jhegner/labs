package br.com.jhegnerlabs.dynamodb.controller;

import br.com.jhegnerlabs.dynamodb.entity.Empresa;
import br.com.jhegnerlabs.dynamodb.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dynamodb")
public class AppController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/{id_empresa}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id_empresa") String idEmpresa) {

        var result = empresaRepository.findById(idEmpresa);

        return ResponseEntity.of(result);

    }

}
