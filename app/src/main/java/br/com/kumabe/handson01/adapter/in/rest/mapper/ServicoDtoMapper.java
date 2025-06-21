package br.com.kumabe.handson01.adapter.in.rest.mapper;

import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.domain.model.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoDtoMapper {
    ServicoResponse toResponse(Servico domain);
    Servico toDomain(ServicoResponse response);
}
