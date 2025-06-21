package br.com.kumabe.handson01.domain.service;

import br.com.kumabe.handson01.domain.model.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.domain.model.port.out.SeguradoRepositoryPort;
import br.com.kumabe.handson01.domain.exception.SeguradoNotFoundException;
import br.com.kumabe.handson01.domain.model.Segurado;
import java.util.List;



public class SeguradoService implements SeguradoUseCase {
    private final SeguradoRepositoryPort seguradoRepositoryPort;

    public SeguradoService(SeguradoRepositoryPort seguradoRepositoryPort){
        this.seguradoRepositoryPort = seguradoRepositoryPort;
    }

    @Override
    public Segurado criar(Segurado segurado) {
        return seguradoRepositoryPort.criar(segurado);
    }

    @Override
    public Segurado obter(String cpf) {
        Segurado segurado = seguradoRepositoryPort.obter(cpf);
        if(segurado == null) {
            String message = String.format("Segurado com o CPF %s não foi encontrado!", cpf);
            throw new SeguradoNotFoundException(message);
        }else{
            return segurado;
        }
    }

    @Override
    public void atualizar(String cpf, Segurado segurado) {
        seguradoRepositoryPort.atualizar(cpf, segurado);
    }

    @Override
    public void deletar(String cpf) {
        seguradoRepositoryPort.deletar(cpf);
    }

    @Override
    public List<Segurado> listar() {
        return seguradoRepositoryPort.listar();
    }
}
