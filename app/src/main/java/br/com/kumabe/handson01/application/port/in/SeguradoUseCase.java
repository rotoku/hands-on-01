package br.com.kumabe.handson01.application.port.in;

import br.com.kumabe.handson01.domain.model.Segurado;
import java.util.List;


public interface SeguradoUseCase {
    public Segurado create(Segurado segurado);
    public Segurado retrieve(String cpf);
    public void update(String cpf, Segurado segurado);
    public void delete(String cpf);
    public List<Segurado> list();
}