package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.ApoliceDtoMapper;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.port.in.ApoliceUseCase;
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
public class ApoliceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApoliceController.class);
    private final ApoliceUseCase apoliceUseCase;
    private final ApoliceDtoMapper apoliceDtoMapper;

    public ApoliceController(final ApoliceUseCase apoliceUseCase,
            final ApoliceDtoMapper apoliceDtoMapper) {
        this.apoliceUseCase = apoliceUseCase;
        this.apoliceDtoMapper = apoliceDtoMapper;
    }

//    @PostMapping(path = "/v1/apolices", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @Transactional
//    public ResponseEntity<Void> criar(@RequestBody ApoliceRequest apoliceRequest,
//            UriComponentsBuilder uriComponentsBuilder) {
//        Apolice apolice = apoliceDtoMapper.toDomain(apoliceRequest);
//        var db = apoliceUseCase.criar(apolice);
//        URI location = uriComponentsBuilder.path("/api/v1/apolices/{numero}").buildAndExpand(db.getNumero()).toUri();
//        return ResponseEntity.created(location).build();
//    }

    // obter
    // atualizar
    // deletar

    @GetMapping(path = "/v1/apolices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApoliceResponse>> listar() {
        List<Apolice> apolices = apoliceUseCase.listar();
        List<ApoliceResponse> apoliceResponses = apolices.stream()
                .map(apoliceDtoMapper::toResponse)
                .toList();
        return ResponseEntity.ok(apoliceResponses);
    }
}
