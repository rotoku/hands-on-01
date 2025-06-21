package br.com.kumabe.handson01.domain.model.port.in;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Segurado;

public interface SeguradoUseCase {
    Segurado criar(Segurado segurado);
    Segurado obter(String cpf);
    void atualizar(String cpf, Segurado segurado);
    void deletar(String cpf);
    List<Segurado> listar();
}
