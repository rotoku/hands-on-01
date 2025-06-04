package br.com.kumabe.handson01.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString
public class Servico {
    private Integer codigo;
    private String descricao;
    private BigDecimal valor;
    private List<Apolice> apolices = new ArrayList<>();
}
