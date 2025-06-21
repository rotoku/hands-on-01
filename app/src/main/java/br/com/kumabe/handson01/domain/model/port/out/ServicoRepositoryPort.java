package br.com.kumabe.handson01.domain.model.port.out;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Servico;

public interface ServicoRepositoryPort {
    Servico criar(Servico servico);
    Servico obter(Integer codigo);
    void atualizar(Integer codigo, Servico servico);
    void deletar(Integer codigo);
    List<Servico> listar();
}
