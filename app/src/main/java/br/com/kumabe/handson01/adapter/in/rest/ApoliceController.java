package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.application.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.domain.model.Apolice;
import java.net.URI;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/api")
public class ApoliceController {
    private final ApoliceUseCase apoliceUseCase;

    public ApoliceController(final ApoliceUseCase apoliceUseCase){
        this.apoliceUseCase = apoliceUseCase;
    }

    @PostMapping(path="/v1/apolices", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody ApoliceRequest apoliceRequest, UriComponentsBuilder uriComponentsBuilder){
        Apolice apolice = new Apolice(
                null,
                apoliceRequest.tipoApolice(),
                apoliceRequest.dataVigencia(),null, null
        );
        var db = apoliceUseCase.create(apolice);
        URI location = uriComponentsBuilder.path("/api/v1/apolices/{numero}").buildAndExpand(db.getNumero()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/v1/apolices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApoliceResponse>> list(){
        return ResponseEntity.ok(apoliceUseCase.list().stream().map(apolice -> new ApoliceResponse(
                        apolice.getNumero(),
                        apolice.getTipoApolice(),
                        apolice.getDataVigencia()))
                .toList());
    }
}
