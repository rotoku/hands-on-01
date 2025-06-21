package br.com.kumabe.handson01.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import br.com.kumabe.handson01.adapter.out.persistence.entity.EnderecoEntity;
import br.com.kumabe.handson01.adapter.out.persistence.entity.SeguradoEntity;
import br.com.kumabe.handson01.domain.model.Endereco;
import br.com.kumabe.handson01.domain.model.Segurado;

@Mapper(componentModel = "spring")
public interface EnderecoPersistenceMapper {
    EnderecoEntity toEntity(Endereco domain);
    Endereco toDomain(EnderecoEntity entity);
}
