package br.com.kumabe.handson01.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.kumabe.handson01.adapter.out.persistence.entity.SeguradoEntity;
import br.com.kumabe.handson01.domain.model.Segurado;


@Mapper(componentModel = "spring", uses = {ApolicePersistenceMapper.class, EnderecoPersistenceMapper.class})
public interface SeguradoPersistenceMapper {
    SeguradoEntity toEntity(Segurado domain);
    //@Mapping(source="apolices", target = "apolices", ignore = true)
    Segurado toDomain(SeguradoEntity entity);
}
