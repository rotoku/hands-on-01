package br.com.kumabe.handson01.application.service;

import br.com.kumabe.handson01.application.port.in.ServicoUseCase;
import br.com.kumabe.handson01.application.port.out.ServicoRepository;
import br.com.kumabe.handson01.domain.model.Servico;
import java.util.List;



public class ServicoService implements ServicoUseCase {
    private final ServicoRepository servicoRepository;

    public ServicoService(final ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    @Override
    public Servico create(Servico servico) {
        return servicoRepository.create(servico);
    }

    @Override
    public Servico retrieve(Integer codigo) {
        return servicoRepository.retrieve(codigo);
    }

    @Override
    public void update(Integer codigo, Servico servico) {
        servicoRepository.update(codigo, servico);
    }

    @Override
    public void delete(Integer codigo) {
        servicoRepository.delete(codigo);
    }

    @Override
    public List<Servico> list() {
        return servicoRepository.list();
    }
}
