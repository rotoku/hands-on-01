package br.com.kumabe.handson01.domain.model;

import br.com.kumabe.handson01.adapter.out.persistence.entity.SeguradoEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="numero")
@ToString
public class Apolice {
    private Integer numero;
    private TipoApolice tipoApolice;
    private LocalDate dataVigencia;
    private List<Segurado> segurados;
    private List<Servico> servicos;
}
