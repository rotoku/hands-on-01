package br.com.kumabe.handson01.adapter.out.persistence;

import br.com.kumabe.handson01.application.port.out.ApoliceRepository;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.TipoApolice;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApoliceRepositoryImpl implements ApoliceRepository {
    private final SpringDataApoliceRepository springDataApoliceRepository;

    public ApoliceRepositoryImpl(final SpringDataApoliceRepository springDataApoliceRepository) {
        this.springDataApoliceRepository = springDataApoliceRepository;
    }

    @Override
    public Apolice create(Apolice apolice) {
        ApoliceEntity apoliceEntity = new ApoliceEntity(
                null,
                apolice.getTipoApolice().name(),
                apolice.getDataVigencia(),
                null,
                null
        );
        ApoliceEntity db = this.springDataApoliceRepository.saveAndFlush(apoliceEntity);
        return new Apolice(
                db.getNumero(),
                TipoApolice.valueOf(db.getTipoApolice()),
                db.getDataVigencia(),
                null, null
        );
    }

    @Override
    public Apolice retrieve(Integer numero) {
        return null;
    }

    @Override
    public void update(Integer numero, Apolice apolice) {

    }

    @Override
    public void delete(Integer numero) {

    }

    @Override
    public List<Apolice> list() {
        return this.springDataApoliceRepository.findAll().stream()
                .map(entity -> new Apolice(
                        entity.getNumero(),
                        TipoApolice.valueOf(entity.getTipoApolice()),
                        entity.getDataVigencia(),
                        null,null
                ))
                .collect(Collectors.toList());
    }
}
