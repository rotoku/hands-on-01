package br.com.kumabe.handson01.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="numero")
@ToString
public class Apolice {
    private Integer numero;
    private TipoApolice tipoApolice;
    private LocalDate dataVigencia;
    private List<Segurado> segurados = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
}
