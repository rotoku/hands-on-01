package br.com.kumabe.handson01.adapter.out.persistence.impl;

import br.com.kumabe.handson01.adapter.out.persistence.SpringDataApoliceRepository;
import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;
import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.ApolicePersistenceMapper;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.port.out.ApoliceRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApoliceRepositoryPortImpl implements ApoliceRepositoryPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApoliceRepositoryPortImpl.class);
    private final SpringDataApoliceRepository springDataApoliceRepository;
    private final ApolicePersistenceMapper apolicePersistenceMapper;

    public ApoliceRepositoryPortImpl(SpringDataApoliceRepository springDataApoliceRepository, ApolicePersistenceMapper apolicePersistenceMapper){
        this.springDataApoliceRepository = springDataApoliceRepository;
        this.apolicePersistenceMapper = apolicePersistenceMapper;
    }

    @Override
    public Apolice criar(Apolice apolice) {
        ApoliceEntity apoliceEntity = apolicePersistenceMapper.toEntity(apolice);
        return apolicePersistenceMapper.toDomain(springDataApoliceRepository.save(apoliceEntity));
    }

    @Override
    public Apolice obter(Integer numero) {
        return null;
    }

    @Override
    public void atualizar(Integer numero, Apolice apolice) {

    }

    @Override
    public void deletar(Integer numero) {

    }

    @Override
    public List<Apolice> listar() {
        List<ApoliceEntity> entities = springDataApoliceRepository.findAll();
        List<Apolice> apolices = entities.stream()
                .map(apolicePersistenceMapper::toDomain)
                .toList();
        return apolices;
    }
}
