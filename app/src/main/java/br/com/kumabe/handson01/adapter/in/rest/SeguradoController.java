package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.SeguradoDtoMapper;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.port.in.SeguradoUseCase;
import jakarta.transaction.Transactional;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping("/api")
public class SeguradoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguradoController.class);
    private final SeguradoUseCase seguradoUseCase;
    private final SeguradoDtoMapper seguradoDtoMapper;
    
    public SeguradoController(final SeguradoUseCase seguradoUseCase,
                              final SeguradoDtoMapper seguradoDtoMapper) {
        this.seguradoUseCase = seguradoUseCase;
        this.seguradoDtoMapper = seguradoDtoMapper;
    }

//     @PostMapping(path="/v1/segurados", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//     @Transactional
//     public ResponseEntity<Void> create(@RequestBody SeguradoRequest seguradoRequest, UriComponentsBuilder uriComponentsBuilder){
//         Segurado segurado = new Segurado(
//                 seguradoRequest.cpf(),
//                 seguradoRequest.nome(),
//                 seguradoRequest.apolices().stream()
//                         .map(apoliceRequest -> new Apolice(
//                                 null,
//                                 apoliceRequest.tipoApolice(),
//                                 apoliceRequest.dataVigencia(),null,null
//                         )).toList(),
//                 seguradoRequest.dataNascimento()
//         );
//         var db = seguradoUseCase.create(segurado);
//         URI location = uriComponentsBuilder.path("/api/v1/segurados/{cpf}").buildAndExpand(db.getCpf()).toUri();
//         return ResponseEntity.created(location).build();
//     }
    // obter
    // atualizar
    // deletar
    @GetMapping(path="/v1/segurados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SeguradoResponse>> listar() {
        List<Segurado> segurados = seguradoUseCase.listar();
        List<SeguradoResponse> seguradoResponses = segurados.stream()
                .map(seguradoDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(seguradoResponses);
    }
}