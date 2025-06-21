package br.com.kumabe.handson01.adapter.in.rest.mapper;

import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoResponse;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.ApolicePersistenceMapper;
import br.com.kumabe.handson01.domain.model.Segurado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ApoliceDtoMapper.class, EnderecoDtoMapper.class})
public interface SeguradoDtoMapper {
    SeguradoResponse toResponse(Segurado domain);
    Segurado toDomain(SeguradoResponse response);
}
