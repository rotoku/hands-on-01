package br.com.kumabe.handson01.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="cpf")
@ToString
public class Segurado {
    private String cpf;
    private String nome;
    private List<Apolice> apolices = new ArrayList<>();
    private LocalDate dataNascimento;
}
