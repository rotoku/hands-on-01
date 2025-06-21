package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApoliceResponse(
                @JsonProperty("numero") Integer numero,
                @JsonProperty("tipo_apolice") String tipoApolice,
                @JsonProperty("data_vigencia") LocalDate dataVigencia,
                @JsonProperty("servicos") List<ServicoResponse> servicos) {
}