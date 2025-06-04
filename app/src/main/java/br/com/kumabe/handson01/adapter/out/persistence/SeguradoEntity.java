package br.com.kumabe.handson01.adapter.out.persistence;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name="segurados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SeguradoEntity {
    @Id
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @ManyToMany
    @JoinTable(
            name = "apolices_segurados",
            joinColumns = @JoinColumn(name = "cpf_segurado", referencedColumnName = "cpf"),
            inverseJoinColumns = @JoinColumn(name = "numero_apolice", referencedColumnName = "numero")
    )
    private List<ApoliceEntity> apolices;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
