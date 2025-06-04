package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.application.port.in.ServicoUseCase;
import br.com.kumabe.handson01.domain.model.Servico;
import java.net.URI;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/api")
public class ServicoController {
    private final ServicoUseCase servicoUseCase;

    public ServicoController(final ServicoUseCase servicoUseCase){
        this.servicoUseCase = servicoUseCase;
    }

    @PostMapping(path="/v1/servicos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody ServicoRequest servicoRequest, UriComponentsBuilder uriComponentsBuilder){
        Servico servico = new Servico(
            null,
                servicoRequest.descricao(),
                servicoRequest.valor(),
                null
        );
        var db = servicoUseCase.create(servico);
        URI location = uriComponentsBuilder.path("/api/v1/servicos/{codigo}").buildAndExpand(db.getCodigo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/v1/servicos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServicoResponse>> list(){
        return ResponseEntity.ok(servicoUseCase.list().stream().map(servico -> new ServicoResponse(
                servico.getCodigo(),
                servico.getDescricao(),
                servico.getValor()
        )).toList());
    }
}
