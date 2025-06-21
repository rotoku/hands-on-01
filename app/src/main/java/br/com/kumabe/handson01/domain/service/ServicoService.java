package br.com.kumabe.handson01.domain.service;

import br.com.kumabe.handson01.domain.model.port.in.ServicoUseCase;
import br.com.kumabe.handson01.domain.model.port.out.ServicoRepositoryPort;
import br.com.kumabe.handson01.domain.model.Servico;
import java.util.List;



public class ServicoService implements ServicoUseCase {
    private final ServicoRepositoryPort servicoRepositoryPort;

    public ServicoService(ServicoRepositoryPort servicoRepositoryPort){
        this.servicoRepositoryPort = servicoRepositoryPort;
    }

    @Override
    public Servico criar(Servico servico) {
        return servicoRepositoryPort.criar(servico);
    }

    @Override
    public Servico obter(Integer codigo) {
        return servicoRepositoryPort.obter(codigo);
    }

    @Override
    public void atualizar(Integer codigo, Servico servico) {
        servicoRepositoryPort.atualizar(codigo, servico);
    }

    @Override
    public void deletar(Integer codigo) {
        servicoRepositoryPort.deletar(codigo);
    }

    @Override
    public List<Servico> listar() {
        return servicoRepositoryPort.listar();
    }
}
