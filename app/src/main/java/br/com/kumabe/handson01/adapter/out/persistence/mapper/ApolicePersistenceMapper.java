package br.com.kumabe.handson01.adapter.out.persistence.mapper;

import br.com.kumabe.handson01.adapter.out.persistence.entity.ApoliceEntity;
import br.com.kumabe.handson01.domain.model.Apolice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ServicoPersistenceMapper.class, SeguradoPersistenceMapper.class})
public interface ApolicePersistenceMapper {
    @Mapping(source = "segurados", target = "segurados", ignore = true) // Assuming apolices are handled separately
    ApoliceEntity toEntity(Apolice domain);
    @Mapping(source = "segurados", target = "segurados", ignore = true) // Assuming apolices are handled separately
    Apolice toDomain(ApoliceEntity entity);
/*

    @ManyToMany(mappedBy = "apolices")
    private List<SeguradoEntity> segurados = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "apolices_servicos",
            joinColumns = @JoinColumn(name = "numero_apolice", referencedColumnName = "numero"),
            inverseJoinColumns = @JoinColumn(name = "codigo_servico", referencedColumnName = "codigo")
    )
    private List<ServicoEntity> servicos = new ArrayList<>();
**/


    // public ApoliceEntity toEntity(Apolice apolice) {
    //     return new ApoliceEntity(
    //             apolice.getNumero(),
    //             apolice.getTipoApolice().name(),
    //             apolice.getDataVigencia(),
    //             null,
    //             null
    //     );
    // }

    // public Apolice toDomain(ApoliceEntity apoliceEntity) {
    //     return new Apolice(apoliceEntity.getNumero(),
    //             TipoApolice.valueOf(apoliceEntity.getTipoApolice()),
    //             apoliceEntity.getDataVigencia(),
    //             null);
    // }
}
