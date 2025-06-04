package br.com.kumabe.handson01.application.service;

import br.com.kumabe.handson01.application.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.application.port.out.SeguradoRepository;
import br.com.kumabe.handson01.application.service.exception.SeguradoNotFoundException;
import br.com.kumabe.handson01.domain.model.Segurado;
import java.util.List;



public class SeguradoService implements SeguradoUseCase {
    private final SeguradoRepository seguradoRepository;

    public SeguradoService(final SeguradoRepository seguradoRepository){
        this.seguradoRepository = seguradoRepository;
    }

    @Override
    public Segurado create(Segurado segurado) {
        return seguradoRepository.create(segurado);
    }

    @Override
    public Segurado retrieve(String cpf) {
        Segurado segurado = seguradoRepository.retrieve(cpf);
        if(segurado == null) {
            String message = String.format("Segurado with CPF %s not found", cpf);
            throw new SeguradoNotFoundException(message);
        }else{
            return segurado;
        }
    }

    @Override
    public void update(String cpf, Segurado segurado) {
        seguradoRepository.update(cpf, segurado);
    }

    @Override
    public void delete(String cpf) {
        seguradoRepository.delete(cpf);
    }

    @Override
    public List<Segurado> list() {
        return seguradoRepository.list();
    }
}
