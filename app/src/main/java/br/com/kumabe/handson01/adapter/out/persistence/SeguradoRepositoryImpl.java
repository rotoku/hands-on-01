package br.com.kumabe.handson01.adapter.out.persistence;

import br.com.kumabe.handson01.application.port.out.SeguradoRepository;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.TipoApolice;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SeguradoRepositoryImpl implements SeguradoRepository {
    private final SpringDataSeguradoRepository springDataSeguradoRepository;

    public SeguradoRepositoryImpl(final SpringDataSeguradoRepository springDataSeguradoRepository) {
        this.springDataSeguradoRepository = springDataSeguradoRepository;
    }

    @Override
    public Segurado create(Segurado segurado) {
        SeguradoEntity seguradoEntity = new SeguradoEntity(
            segurado.getCpf(),
                segurado.getNome(),
                segurado.getApolices().stream()
                        .map(apolice -> new ApoliceEntity(
                                apolice.getNumero(),
                                apolice.getTipoApolice().name(),
                                apolice.getDataVigencia(),
                                null,
                                null
                        )).collect(Collectors.toList()),
                segurado.getDataNascimento()
        );
        SeguradoEntity db = this.springDataSeguradoRepository.saveAndFlush(seguradoEntity);
        return new Segurado(
                db.getCpf(),
                db.getNome(),
                db.getApolices().stream()
                        .map(apoliceEntity -> new Apolice(
                                apoliceEntity.getNumero(),
                                TipoApolice.valueOf(apoliceEntity.getTipoApolice()),
                                apoliceEntity.getDataVigencia(),
                                null,null
                        )).collect(Collectors.toList()),
                db.getDataNascimento()
        );
    }

    @Override
    public Segurado retrieve(String cpf) {
        Segurado segurado = null;
        Optional<SeguradoEntity> optional = this.springDataSeguradoRepository.findById(cpf);
        if(optional.isPresent()){
            SeguradoEntity entity = optional.get();
            segurado =  new Segurado(
                    entity.getCpf(),
                    entity.getNome(),
                    entity.getApolices().stream()
                            .map(apoliceEntity -> new Apolice(
                                    apoliceEntity.getNumero(),
                                    TipoApolice.valueOf(apoliceEntity.getTipoApolice()),
                                    apoliceEntity.getDataVigencia(),
                                    null,
                                    List.of(
                                            new Servico(1, "Cobertura de colisão", new BigDecimal(1500.00), null),
                                            new Servico(2, "Proteção contra roubo", new BigDecimal(1200.00), null)
                                    )
                            )).collect(Collectors.toList()),
                    entity.getDataNascimento()
            );
            return segurado;
        }else{
            return null;
        }
    }

    @Override
    public void update(String cpf, Segurado segurado) {

    }

    @Override
    public void delete(String cpf) {

    }

    @Override
    public List<Segurado> list() {
        return this.springDataSeguradoRepository.findAll().stream()
                .map(entity -> new Segurado(
                        entity.getCpf(),
                        entity.getNome(),
                        entity.getApolices().stream()
                                .map(apoliceEntity -> new Apolice(
                                        apoliceEntity.getNumero(),
                                        TipoApolice.valueOf(apoliceEntity.getTipoApolice()),
                                        apoliceEntity.getDataVigencia(),
                                        null,
                                        null
                                )).collect(Collectors.toList()),
                        entity.getDataNascimento()
                ))
                .collect(Collectors.toList());
    }
}
