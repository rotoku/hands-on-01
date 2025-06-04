package br.com.kumabe.handson01.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="apolices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApoliceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "tipo_apolice")
    private String tipoApolice;

    @Column(name = "data_vigencia")
    private LocalDate dataVigencia;

    @ManyToMany(mappedBy = "apolices")
    private List<SeguradoEntity> segurados = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "apolices_servicos",
            joinColumns = @JoinColumn(name = "numero_apolice", referencedColumnName = "numero"),
            inverseJoinColumns = @JoinColumn(name = "codigo_servico", referencedColumnName = "codigo")
    )
    private List<ServicoEntity> servicos = new ArrayList<>();
}
