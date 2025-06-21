package br.com.kumabe.handson01.adapter.in.rest.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.domain.model.Apolice;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.SeguradoPersistenceMapper;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.ServicoPersistenceMapper;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.TipoApolice;

@Mapper(componentModel = "spring", uses = {ServicoDtoMapper.class, SeguradoDtoMapper.class})
public interface ApoliceDtoMapper {
    ApoliceResponse toResponse(Apolice domain);
    Apolice toDomain(ApoliceResponse response);
//    public Apolice toDomain(ApoliceRequest apoliceRequest) {
//        if (apoliceRequest == null)
//            return null;
//        return null;
//    }
//
//    public ApoliceResponse toResponse(Apolice apolice) {
//        if (apolice == null)
//            return null;
//        return new ApoliceResponse(
//                apolice.getNumero(),
//                apolice.getTipoApolice().name(),
//                apolice.getDataVigencia(),
//                apolice.getServicos() != null ?
//                    apolice.getServicos().stream()
//                        .map(servico -> new ServicoResponse(
//                            servico.getCodigo(),
//                            servico.getDescricao(),
//                            servico.getValor()))
//                        .collect(Collectors.toList())
//                    : List.of());
//    }
    
}