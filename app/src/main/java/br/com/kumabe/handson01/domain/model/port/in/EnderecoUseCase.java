package br.com.kumabe.handson01.domain.model.port.in;

import java.util.List;

import br.com.kumabe.handson01.domain.model.Endereco;

public interface EnderecoUseCase {
    Endereco criar(Endereco endereco);
    Endereco obter(String cep);
    void atualizar(String cep, Endereco endereco);
    void deletar(String cep);
    List<Endereco> listar();
}
