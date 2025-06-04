package br.com.kumabe.handson01.adapter.in.rest.dto;

import br.com.kumabe.handson01.domain.model.TipoApolice;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApoliceResponse(
        @JsonProperty("numero")
        Integer numero,
        @JsonProperty("tipo_apolice")
        TipoApolice tipoApolice,
        @JsonProperty("data_vigencia")
        LocalDate dataVigencia
) {
}
