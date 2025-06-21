package br.com.kumabe.handson01.domain.service;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Endereco;
import br.com.kumabe.handson01.domain.model.port.in.EnderecoUseCase;
import br.com.kumabe.handson01.domain.model.port.out.EnderecoRepositoryPort;

public class EnderecoService implements EnderecoUseCase {
    private final EnderecoRepositoryPort enderecoRepositoryPort;

    public EnderecoService(EnderecoRepositoryPort enderecoRepositoryPort) {
        this.enderecoRepositoryPort = enderecoRepositoryPort;
    }

    @Override
    public Endereco criar(Endereco endereco) {
        return this.enderecoRepositoryPort.criar(endereco);
    }

    @Override
    public Endereco obter(String cep) {
        return this.enderecoRepositoryPort.obter(cep);
    }

    @Override
    public void atualizar(String cep, Endereco endereco) {
        this.enderecoRepositoryPort.atualizar(cep, endereco);
    }

    @Override
    public void deletar(String cep) {
        this.enderecoRepositoryPort.deletar(cep);
    }

    @Override
    public List<Endereco> listar() {
        return this.enderecoRepositoryPort.listar();
    }
    
}
