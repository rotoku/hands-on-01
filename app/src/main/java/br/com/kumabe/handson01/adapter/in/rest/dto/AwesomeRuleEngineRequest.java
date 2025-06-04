package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record AwesomeRuleEngineRequest(
        String cpf, String servico
) {
}
