package br.com.kumabe.handson01.adapter.out.persistence.impl;

import br.com.kumabe.handson01.adapter.out.persistence.SpringDataEnderecoRepository;
import br.com.kumabe.handson01.adapter.out.persistence.entity.EnderecoEntity;
import br.com.kumabe.handson01.adapter.out.persistence.mapper.EnderecoPersistenceMapper;
import br.com.kumabe.handson01.domain.model.Endereco;
import br.com.kumabe.handson01.domain.model.port.out.EnderecoRepositoryPort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoRepositoryPortImpl implements EnderecoRepositoryPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoRepositoryPortImpl.class);
    private final SpringDataEnderecoRepository springDataEnderecoRepository;
    private final EnderecoPersistenceMapper enderecoPersistenceMapper;

    public EnderecoRepositoryPortImpl(SpringDataEnderecoRepository springDataEnderecoRepository, EnderecoPersistenceMapper enderecoPersistenceMapper) {
        this.springDataEnderecoRepository = springDataEnderecoRepository;
        this.enderecoPersistenceMapper = enderecoPersistenceMapper;
    }
    
    @Override
    public Endereco criar(Endereco endereco) {
        return null;
    }

    @Override
    public Endereco obter(String cep) {
        return null;
    }

    @Override
    public void atualizar(String cep, Endereco endereco) {

    }

    @Override
    public void deletar(String cep) {

    }

    @Override
    public List<Endereco> listar() {
        List<EnderecoEntity> entities = springDataEnderecoRepository.findAll();
        List<Endereco> enderecos = entities.stream()
                .map(enderecoPersistenceMapper::toDomain)
                .toList();
        return enderecos;
    }
}
