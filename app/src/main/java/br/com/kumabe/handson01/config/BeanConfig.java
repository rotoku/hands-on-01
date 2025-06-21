package br.com.kumabe.handson01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.kumabe.handson01.domain.model.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.domain.model.port.in.EnderecoUseCase;
import br.com.kumabe.handson01.domain.model.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.domain.model.port.in.ServicoUseCase;
import br.com.kumabe.handson01.domain.model.port.out.ApoliceRepositoryPort;
import br.com.kumabe.handson01.domain.model.port.out.EnderecoRepositoryPort;
import br.com.kumabe.handson01.domain.model.port.out.SeguradoRepositoryPort;
import br.com.kumabe.handson01.domain.model.port.out.ServicoRepositoryPort;
import br.com.kumabe.handson01.domain.service.ApoliceService;
import br.com.kumabe.handson01.domain.service.EnderecoService;
import br.com.kumabe.handson01.domain.service.SeguradoService;
import br.com.kumabe.handson01.domain.service.ServicoService;

@Configuration
public class BeanConfig {
    @Bean
    public ApoliceUseCase apoliceUseCase(ApoliceRepositoryPort apoliceRepositoryPort) {
        return new ApoliceService(apoliceRepositoryPort);
    }

     @Bean
     public EnderecoUseCase enderecoUseCase(EnderecoRepositoryPort enderecoRepositoryPort) {
         return new EnderecoService(enderecoRepositoryPort);
     }

     @Bean
     public SeguradoUseCase seguradoUseCase(SeguradoRepositoryPort seguradoRepositoryPort) {
         return new SeguradoService(seguradoRepositoryPort);
     }

     @Bean
     public ServicoUseCase servicoUseCase(ServicoRepositoryPort servicoRepositoryPort) {
         return new ServicoService(servicoRepositoryPort);
     }
}
