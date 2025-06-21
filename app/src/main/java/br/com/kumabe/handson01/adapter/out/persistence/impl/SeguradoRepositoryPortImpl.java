package br.com.kumabe.handson01.adapter.out.persistence.impl;

import br.com.kumabe.handson01.adapter.out.persistence.SpringDataSeguradoRepository;
import br.com.kumabe.handson01.adapter.out.persistence.entity.SeguradoEntity;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.SeguradoPersistenceMapper;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.port.out.SeguradoRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeguradoRepositoryPortImpl implements SeguradoRepositoryPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeguradoRepositoryPortImpl.class);
    private final SpringDataSeguradoRepository springDataSeguradoRepository;
    private final SeguradoPersistenceMapper seguradoPersistenceMapper;

    public SeguradoRepositoryPortImpl(SpringDataSeguradoRepository springDataSeguradoRepository, SeguradoPersistenceMapper seguradoPersistenceMapper){
        this.springDataSeguradoRepository = springDataSeguradoRepository;
        this.seguradoPersistenceMapper = seguradoPersistenceMapper;
    }

    @Override
    public Segurado criar(Segurado segurado) {
        return null;
    }

    @Override
    public Segurado obter(String cpf) {
        return null;
    }

    @Override
    public void atualizar(String cpf, Segurado segurado) {

    }

    @Override
    public void deletar(String cpf) {

    }

    @Override
    public List<Segurado> listar() {
        List<SeguradoEntity> entities = springDataSeguradoRepository.findAll();
        List<Segurado> segurados = entities.stream()
                .map(seguradoPersistenceMapper::toDomain)
                .toList();
        return segurados;
    }
}