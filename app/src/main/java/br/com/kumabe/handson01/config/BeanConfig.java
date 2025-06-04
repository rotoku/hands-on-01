package br.com.kumabe.handson01.config;

import br.com.kumabe.handson01.application.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.application.port.in.SeguradoUseCase;
import br.com.kumabe.handson01.application.port.in.ServicoUseCase;
import br.com.kumabe.handson01.application.port.out.ApoliceRepository;
import br.com.kumabe.handson01.application.port.out.SeguradoRepository;
import br.com.kumabe.handson01.application.port.out.ServicoRepository;
import br.com.kumabe.handson01.application.service.ApoliceService;
import br.com.kumabe.handson01.application.service.SeguradoService;
import br.com.kumabe.handson01.application.service.ServicoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ApoliceUseCase apoliceUseCase(ApoliceRepository apoliceRepository) {
        return new ApoliceService(apoliceRepository);
    }

    @Bean
    public SeguradoUseCase seguradoUseCase(SeguradoRepository seguradoRepository) {
        return new SeguradoService(seguradoRepository);
    }

    @Bean
    public ServicoUseCase servicoUseCase(ServicoRepository servicoRepository) {
        return new ServicoService(servicoRepository);
    }
}
