package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeguradoRequest(
                @NotBlank
                @JsonProperty("cpf") String cpf,
                @NotBlank
                @JsonProperty("nome") String nome,
                @Email
                @JsonProperty("email") String email,
                @JsonProperty("telefone") String telefone,
                @JsonProperty("endereco") EnderecoRequest endereco,
                @JsonProperty("numero") String numero,
                @JsonProperty("complemento") String complemento,
                @JsonProperty("data_nascimento") LocalDate dataNascimento,
                @JsonProperty("apolices") List<ApoliceRequest> apolices) {
}
