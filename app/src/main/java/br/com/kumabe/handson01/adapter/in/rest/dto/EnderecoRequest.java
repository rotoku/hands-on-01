package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EnderecoRequest(
                @JsonProperty("cep") String cep,
                @JsonProperty("logradouro") String logradouro,
                @JsonProperty("bairro") String bairro,
                @JsonProperty("cidade") String cidade,
                @JsonProperty("estado") String estado) {
}
