package br.com.kumabe.handson01.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeguradoResponse(
                @JsonProperty("cpf") String cpf,
                @JsonProperty("nome") String nome,
                @JsonProperty("email") String email,
                @JsonProperty("telefone") String telefone,
                @JsonProperty("endereco") EnderecoResponse endereco,
                @JsonProperty("numero") String numero,
                @JsonProperty("complemento") String complemento,
                @JsonProperty("data_nascimento") LocalDate dataNascimento,
                @JsonProperty("apolices") List<ApoliceResponse> apolices) {
}