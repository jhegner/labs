package br.com.jhegnerlabs.dynamodb.repository;

import br.com.jhegnerlabs.dynamodb.entity.Empresa;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@EnableScan
public interface EmpresaRepository extends CrudRepository<Empresa, String> {

    List<Empresa> findByCnpj(String cnpj);

    List<Empresa> findByNome(String nome);

}
