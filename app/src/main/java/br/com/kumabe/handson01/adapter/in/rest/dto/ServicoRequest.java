package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ServicoRequest(
        String descricao,
        BigDecimal valor
) {
}
