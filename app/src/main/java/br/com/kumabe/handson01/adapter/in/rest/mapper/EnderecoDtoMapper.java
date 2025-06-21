package br.com.kumabe.handson01.adapter.in.rest.mapper;

import org.mapstruct.Mapper;

import br.com.kumabe.handson01.adapter.in.rest.dto.EnderecoResponse;
import br.com.kumabe.handson01.domain.model.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoDtoMapper {
    EnderecoResponse toResponse(Endereco domain);
    Endereco toDomain(EnderecoResponse response);
}
