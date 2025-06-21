package br.com.kumabe.handson01.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString
public class Servico {
    private Integer codigo;
    private String descricao;
    private BigDecimal valor;
    private List<Apolice> apolices;
}
