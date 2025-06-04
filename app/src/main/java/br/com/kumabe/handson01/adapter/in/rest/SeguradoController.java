package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoResponse;
import br.com.kumabe.handson01.application.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Segurado;
import java.net.URI;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class SeguradoController {
    private final SeguradoUseCase seguradoUseCase;

    public SeguradoController(final SeguradoUseCase seguradoUseCase){
        this.seguradoUseCase = seguradoUseCase;
    }

    @PostMapping(path="/v1/segurados", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody SeguradoRequest seguradoRequest, UriComponentsBuilder uriComponentsBuilder){
        Segurado segurado = new Segurado(
                seguradoRequest.cpf(),
                seguradoRequest.nome(),
                seguradoRequest.apolices().stream()
                        .map(apoliceRequest -> new Apolice(
                                null,
                                apoliceRequest.tipoApolice(),
                                apoliceRequest.dataVigencia(),null,null
                        )).toList(),
                seguradoRequest.dataNascimento()
        );
        var db = seguradoUseCase.create(segurado);
        URI location = uriComponentsBuilder.path("/api/v1/segurados/{cpf}").buildAndExpand(db.getCpf()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/v1/segurados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SeguradoResponse>> list() {
        List<SeguradoResponse> seguradoResponses = seguradoUseCase.list().stream()
                .map(segurado -> new SeguradoResponse(
                        segurado.getCpf(),
                        segurado.getNome(),
                        segurado.getApolices().stream()
                                .map(apolice -> new ApoliceResponse(
                                        apolice.getNumero(),
                                        apolice.getTipoApolice(),
                                        apolice.getDataVigencia()
                                )).toList(),
                        segurado.getDataNascimento()
                )).toList();
        return ResponseEntity.ok(seguradoResponses);
    }

}
