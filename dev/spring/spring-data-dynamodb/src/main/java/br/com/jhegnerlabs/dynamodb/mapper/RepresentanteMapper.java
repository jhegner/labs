package br.com.jhegnerlabs.dynamodb.mapper;

import br.com.jhegnerlabs.dynamodb.controller.request.RepresentanteRequest;
import br.com.jhegnerlabs.dynamodb.entity.Representante;
import br.com.jhegnerlabs.dynamodb.entity.id.RepresentanteId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepresentanteMapper {

    RepresentanteMapper INSTANCE = Mappers.getMapper(RepresentanteMapper.class);

    @Mapping(target = "idPessoaJuridica", source = "idPessoaJuridica")
    Representante entityFromRequest(RepresentanteRequest request, String idPessoaJuridica);


}
