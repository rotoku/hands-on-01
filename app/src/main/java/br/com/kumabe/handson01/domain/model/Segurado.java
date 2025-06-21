package br.com.kumabe.handson01.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="cpf")
@ToString
public class Segurado {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
    private String numero;
    private String complemento;
    private LocalDate dataNascimento;
    private List<Apolice> apolices;
}
