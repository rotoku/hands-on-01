package br.com.kumabe.handson01.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import br.com.kumabe.handson01.adapter.out.persistence.entity.ServicoEntity;
import br.com.kumabe.handson01.domain.model.Servico;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicoPersistenceMapper {
    @Mapping(source = "apolices", target = "apolices", ignore = true) // Assuming apolices are handled separately
    ServicoEntity toEntity(Servico domain);
    @Mapping(source = "apolices", target = "apolices", ignore = true) // Assuming apolices are handled separately
    Servico toDomain(ServicoEntity entity);
}
