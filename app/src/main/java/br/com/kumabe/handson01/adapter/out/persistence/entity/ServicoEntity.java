package br.com.kumabe.handson01.adapter.out.persistence.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Table(name="servicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="codigo")
@ToString
public class ServicoEntity {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @ManyToMany(mappedBy = "servicos")
    private List<ApoliceEntity> apolices;
}
