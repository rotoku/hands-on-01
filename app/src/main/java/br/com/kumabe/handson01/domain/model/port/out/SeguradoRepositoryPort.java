package br.com.kumabe.handson01.domain.model.port.out;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Segurado;

public interface SeguradoRepositoryPort {
    Segurado criar(Segurado segurado);
    Segurado obter(String cpf);
    void atualizar(String cpf, Segurado segurado);
    void deletar(String cpf);
    List<Segurado> listar();
}
