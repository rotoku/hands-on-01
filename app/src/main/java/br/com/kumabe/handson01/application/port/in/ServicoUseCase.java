package br.com.kumabe.handson01.application.port.in;

import br.com.kumabe.handson01.domain.model.Servico;
import java.util.List;


public interface ServicoUseCase {
    public Servico create(Servico servico);
    public Servico retrieve(Integer codigo);
    public void update(Integer codigo, Servico servico);
    public void delete(Integer codigo);
    public List<Servico> list();
}