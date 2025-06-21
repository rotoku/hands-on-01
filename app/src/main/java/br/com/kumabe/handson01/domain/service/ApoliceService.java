package br.com.kumabe.handson01.domain.service;

import br.com.kumabe.handson01.domain.model.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.domain.model.port.out.ApoliceRepositoryPort;
import br.com.kumabe.handson01.domain.model.Apolice;

import java.util.List;

public class ApoliceService implements ApoliceUseCase {
    private final ApoliceRepositoryPort apoliceRepositoryPort;

    public ApoliceService(ApoliceRepositoryPort apoliceRepositoryPort){
        this.apoliceRepositoryPort = apoliceRepositoryPort;
    }

    @Override
    public Apolice criar(Apolice apolice) {
        return apoliceRepositoryPort.criar(apolice);
    }

    @Override
    public Apolice obter(Integer numero) {
        return apoliceRepositoryPort.obter(numero);
    }

    @Override
    public void atualizar(Integer numero, Apolice apolice) {
        apoliceRepositoryPort.atualizar(numero, apolice);
    }

    @Override
    public void deletar(Integer numero) {
        apoliceRepositoryPort.deletar(numero);
    }

    @Override
    public List<Apolice> listar() {
        return apoliceRepositoryPort.listar();
    }
}
