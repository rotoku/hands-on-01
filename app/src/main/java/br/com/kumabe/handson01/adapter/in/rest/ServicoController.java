package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.ServicoDtoMapper;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.port.in.ServicoUseCase;
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
public class ServicoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoController.class);
    private final ServicoUseCase servicoUseCase;
    private final ServicoDtoMapper servicoDtoMapper;

    public ServicoController(final ServicoUseCase servicoUseCase, final ServicoDtoMapper servicoDtoMapper){
        this.servicoUseCase = servicoUseCase;
        this.servicoDtoMapper = servicoDtoMapper;
    }

    // @PostMapping(path="/v1/servicos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    // @Transactional
    // public ResponseEntity<Void> create(@RequestBody ServicoRequest servicoRequest, UriComponentsBuilder uriComponentsBuilder){
    //     Servico servico = new Servico(
    //         null,
    //             servicoRequest.descricao(),
    //             servicoRequest.valor(),
    //             null
    //     );
    //     var db = servicoUseCase.create(servico);
    //     URI location = uriComponentsBuilder.path("/api/v1/servicos/{codigo}").buildAndExpand(db.getCodigo()).toUri();
    //     return ResponseEntity.created(location).build();
    // }
    // obter
    // atualizar
    // deletar
    @GetMapping(path="/v1/servicos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServicoResponse>> listar(){
        List<Servico> servicos = servicoUseCase.listar();
        List<ServicoResponse> servicoResponses = servicos.stream()
                .map(servicoDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(servicoResponses);
    }
}
