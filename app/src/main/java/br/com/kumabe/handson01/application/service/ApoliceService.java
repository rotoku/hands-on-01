package br.com.kumabe.handson01.application.service;

import br.com.kumabe.handson01.application.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.application.port.out.ApoliceRepository;
import br.com.kumabe.handson01.domain.model.Apolice;
import java.util.List;



public class ApoliceService implements ApoliceUseCase {
    private final ApoliceRepository apoliceRepository;

    public ApoliceService(final ApoliceRepository apoliceRepository){
        this.apoliceRepository = apoliceRepository;
    }

    @Override
    public Apolice create(Apolice apolice) {
        return apoliceRepository.create(apolice);
    }

    @Override
    public Apolice retrieve(Integer numero) {
        return apoliceRepository.retrieve(numero);
    }

    @Override
    public void update(Integer numero, Apolice apolice) {
        apoliceRepository.update(numero, apolice);
    }

    @Override
    public void delete(Integer numero) {
        apoliceRepository.delete(numero);
    }

    @Override
    public List<Apolice> list() {
        return apoliceRepository.list();
    }
}
