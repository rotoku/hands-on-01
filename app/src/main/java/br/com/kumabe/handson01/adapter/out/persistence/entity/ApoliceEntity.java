package br.com.kumabe.handson01.adapter.out.persistence.entity;

import br.com.kumabe.handson01.domain.model.TipoApolice;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="apolices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="numero")
@ToString
public class ApoliceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_apolice")
    private TipoApolice tipoApolice;

    @Column(name = "data_vigencia")
    private LocalDate dataVigencia;

    @ManyToMany(mappedBy = "apolices")
    private List<SeguradoEntity> segurados;

    @ManyToMany
    @JoinTable(
            name = "apolices_servicos",
            joinColumns = @JoinColumn(name = "numero_apolice", referencedColumnName = "numero"),
            inverseJoinColumns = @JoinColumn(name = "codigo_servico", referencedColumnName = "codigo")
    )
    private List<ServicoEntity> servicos;
}
