package br.com.kumabe.handson01.application.port.in;

import br.com.kumabe.handson01.domain.model.Apolice;
import java.util.List;


public interface ApoliceUseCase {
    public Apolice create(Apolice apolice);
    public Apolice retrieve(Integer numero);
    public void update(Integer numero, Apolice apolice);
    public void delete(Integer numero);
    public List<Apolice> list();
}