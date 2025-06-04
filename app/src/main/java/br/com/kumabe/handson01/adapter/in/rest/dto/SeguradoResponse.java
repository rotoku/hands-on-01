package br.com.kumabe.handson01.adapter.in.rest.dto;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeguradoResponse(
        @JsonProperty("cpf")
        String cpf,
        @JsonProperty("nome")
        String nome,
        @JsonProperty("apolices")
        List<ApoliceResponse> apolices,
        @JsonProperty("data_nascimento")
        LocalDate dataNascimento
) {
}
