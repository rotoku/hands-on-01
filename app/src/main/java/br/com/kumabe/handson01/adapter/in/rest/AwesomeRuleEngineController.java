package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.AwesomeRuleEngineRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.AwesomeRuleEngineResponse;
import br.com.kumabe.handson01.application.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Segurado;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AwesomeRuleEngineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AwesomeRuleEngineController.class);
    private static final String RECUSADO = "Recusado";
    private static final String APROVADO = "Aprovado";
    private final SeguradoUseCase seguradoUseCase;

    public AwesomeRuleEngineController(SeguradoUseCase seguradoUseCase) {
        this.seguradoUseCase = seguradoUseCase;
    }

    @PostMapping(path="/v1/evaluations")
    public ResponseEntity<AwesomeRuleEngineResponse> evaluation(@RequestBody AwesomeRuleEngineRequest awesomeRuleEngineRequest) {
        Segurado segurado = seguradoUseCase.retrieve(awesomeRuleEngineRequest.cpf());
        if (segurado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AwesomeRuleEngineResponse(
                    awesomeRuleEngineRequest.cpf(),
                    awesomeRuleEngineRequest.servico(),
                    RECUSADO
            ));
        }

        for (Apolice apolice : segurado.getApolices()) {
            boolean vigente = apolice.getDataVigencia().isAfter(LocalDate.now());
            LOGGER.info("Apolice {} vigente: {}", apolice.getNumero(), vigente);
            boolean contemServico = apolice.getServicos() == null ? false : apolice.getServicos().isEmpty() ? false : apolice.getServicos().stream()
                    .anyMatch(servico -> servico.getDescricao().equals(awesomeRuleEngineRequest.servico()));
            LOGGER.info("Serviço {} encontrado na apólice: {}", awesomeRuleEngineRequest.servico(), contemServico);
            if (vigente && contemServico) {
                return ResponseEntity.status(HttpStatus.CREATED).body(new AwesomeRuleEngineResponse(
                        awesomeRuleEngineRequest.cpf(),
                        awesomeRuleEngineRequest.servico(),
                        APROVADO
                ));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AwesomeRuleEngineResponse(
                awesomeRuleEngineRequest.cpf(),
                awesomeRuleEngineRequest.servico(),
                RECUSADO
        ));
    }
}
