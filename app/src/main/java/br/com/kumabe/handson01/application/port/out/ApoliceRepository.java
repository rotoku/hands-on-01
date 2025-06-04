package br.com.kumabe.handson01.application.port.out;

import br.com.kumabe.handson01.domain.model.Apolice;
import java.util.List;


public interface ApoliceRepository {
    public Apolice create(Apolice apolice);
    public Apolice retrieve(Integer numero);
    public void update(Integer numero, Apolice apolice);
    public void delete(Integer numero);
    public List<Apolice> list();
}
