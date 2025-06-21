package br.com.kumabe.handson01.adapter.out.persistence.impl;

import br.com.kumabe.handson01.adapter.out.persistence.SpringDataServicoRepository;
import br.com.kumabe.handson01.adapter.out.persistence.entity.ServicoEntity;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.ServicoPersistenceMapper;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.port.out.ServicoRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoRepositoryPortImpl implements ServicoRepositoryPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoRepositoryPortImpl.class);
    private final SpringDataServicoRepository springDataServicoRepository;
    private final ServicoPersistenceMapper servicoPersistenceMapper;

    public ServicoRepositoryPortImpl(SpringDataServicoRepository springDataServicoRepository, ServicoPersistenceMapper servicoPersistenceMapper){
        this.springDataServicoRepository = springDataServicoRepository;
        this.servicoPersistenceMapper = servicoPersistenceMapper;
    }

    @Override
    public void atualizar(Integer codigo, Servico servico) {

    }

    @Override
    public Servico criar(Servico servico) {
        return null;
    }

    @Override
    public Servico obter(Integer codigo) {
        return null;
    }

    @Override
    public void deletar(Integer codigo) {

    }

    @Override
    public List<Servico> listar() {
        List<ServicoEntity> entities = springDataServicoRepository.findAll();
        List<Servico> servicos = entities.stream()
                .map(servicoPersistenceMapper::toDomain)
                .toList();
        return servicos;
    }
}
