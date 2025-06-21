package br.com.kumabe.handson01.domain.model.port.in;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Apolice;

public interface ApoliceUseCase {
    Apolice criar(Apolice apolice);
    Apolice obter(Integer numero);
    void atualizar(Integer numero, Apolice apolice);
    void deletar(Integer numero);
    List<Apolice> listar();
}
