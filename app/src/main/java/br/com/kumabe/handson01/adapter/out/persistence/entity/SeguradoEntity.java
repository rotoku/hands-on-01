package br.com.kumabe.handson01.adapter.out.persistence.entity;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Endereco;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Table(name="segurados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="cpf")
@ToString
public class SeguradoEntity {
    @Id
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "endereco_cep")
    private EnderecoEntity endereco;

    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToMany
    @JoinTable(
            name = "apolices_segurados",
            joinColumns = @JoinColumn(name = "cpf_segurado", referencedColumnName = "cpf"),
            inverseJoinColumns = @JoinColumn(name = "numero_apolice", referencedColumnName = "numero")
    )
    private List<ApoliceEntity> apolices;







}
