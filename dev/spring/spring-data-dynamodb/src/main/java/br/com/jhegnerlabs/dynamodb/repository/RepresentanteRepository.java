package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.Representante;
import br.com.jhegnerlabs.dynamodb.entity.id.RepresentanteId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepresentanteRepository extends CrudRepository<Representante, RepresentanteId> {

    Optional<Representante> findByRg(String rg);

    Optional<Representante> findByIdPessoaJuridicaAndCpf(String idPessoaJuridica, String cpf);

}
