package br.com.kumabe.handson01.adapter.out.persistence;

import br.com.kumabe.handson01.application.port.out.ServicoRepository;
import br.com.kumabe.handson01.domain.model.Servico;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServicoRepositoryImpl implements ServicoRepository {
    private final SpringDataServicoRepository springDataServicoRepository;

    public ServicoRepositoryImpl(final SpringDataServicoRepository springDataServicoRepository) {
        this.springDataServicoRepository = springDataServicoRepository;
    }

    @Override
    public Servico create(Servico servico) {
        ServicoEntity servicoEntity = new ServicoEntity(
                null,
                servico.getDescricao(),
                servico.getValor(),
                null
        );
        ServicoEntity db = this.springDataServicoRepository.saveAndFlush(servicoEntity);
        return new Servico(
                db.getCodigo(),
                db.getDescricao(),
                db.getValor(),
                null
        );
    }

    @Override
    public Servico retrieve(Integer numero) {
        return null;
    }

    @Override
    public void update(Integer numero, Servico servico) {

    }

    @Override
    public void delete(Integer numero) {

    }

    @Override
    public List<Servico> list() {
        return this.springDataServicoRepository.findAll().stream()
                .map(servicoEntity -> new Servico(
                        servicoEntity.getCodigo(),
                        servicoEntity.getDescricao(),
                        servicoEntity.getValor(),
                        null
                ))
                .collect(Collectors.toList());
    }
}
