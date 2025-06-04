package br.com.kumabe.handson01.adapter.out.persistence;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name="servicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
