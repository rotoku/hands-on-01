package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.EnderecoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.EnderecoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.EnderecoDtoMapper;
import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;
import br.com.kumabe.handson01.adapter.out.persistence.entity.EnderecoEntity;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Endereco;
import br.com.kumabe.handson01.domain.model.port.in.EnderecoUseCase;
import jakarta.transaction.Transactional;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/api")
public class EnderecoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoController.class);
    private final EnderecoUseCase enderecoUseCase;
    private final EnderecoDtoMapper enderecoDtoMapper;

    public EnderecoController(final EnderecoUseCase enderecoUseCase, 
                              final EnderecoDtoMapper enderecoDtoMapper) {
        this.enderecoUseCase = enderecoUseCase;
        this.enderecoDtoMapper = enderecoDtoMapper;
    }

    // @PostMapping(path="/v1/enderecos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    // @Transactional
    // public ResponseEntity<Void> create(@RequestBody EnderecoRequest enderecoRequest, UriComponentsBuilder uriComponentsBuilder){
    //     Endereco endereco = new Endereco(
    //             null,
    //             enderecoRequest.tipoEndereco(),
    //             enderecoRequest.dataVigencia(),null, null
    //     );
    //     var db = enderecoUseCase.create(endereco);
    //     URI location = uriComponentsBuilder.path("/api/v1/enderecos/{numero}").buildAndExpand(db.getNumero()).toUri();
    //     return ResponseEntity.created(location).build();
    // }
    // obter
    // atualizar
    // deletar
    @GetMapping(path="/v1/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EnderecoResponse>> listar(){
        List<Endereco> enderecos = enderecoUseCase.listar();
        List<EnderecoResponse> enderecoResponses = enderecos.stream()
                .map(enderecoDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(enderecoResponses);
    }
}