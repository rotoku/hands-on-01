package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ServicoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.ServicoDtoMapper;
import br.com.kumabe.handson01.domain.model.Servico;
import br.com.kumabe.handson01.domain.model.port.in.ServicoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicoControllerTest {

    private ServicoUseCase servicoUseCase;
    private ServicoDtoMapper servicoDtoMapper;
    private ServicoController servicoController;

    @BeforeEach
    void setUp() {
        servicoUseCase = mock(ServicoUseCase.class);
        servicoDtoMapper = mock(ServicoDtoMapper.class);
        servicoController = new ServicoController(servicoUseCase, servicoDtoMapper);
    }

    @Test
    void listar_ReturnsListOfServicoResponse() {
        // Arrange
        Servico servico1 = new Servico(1, "Servico 1", BigDecimal.valueOf(100), null);
        Servico servico2 = new Servico(2, "Servico 2", BigDecimal.valueOf(200), null);
        List<Servico> servicos = Arrays.asList(servico1, servico2);

        ServicoResponse response1 = new ServicoResponse(1, "Servico 1", BigDecimal.valueOf(100));
        ServicoResponse response2 = new ServicoResponse(2, "Servico 2", BigDecimal.valueOf(200));

        when(servicoUseCase.listar()).thenReturn(servicos);
        when(servicoDtoMapper.toResponse(servico1)).thenReturn(response1);
        when(servicoDtoMapper.toResponse(servico2)).thenReturn(response2);

        // Act
        ResponseEntity<List<ServicoResponse>> responseEntity = servicoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<ServicoResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
        assertEquals(response1, body.get(0));
        assertEquals(response2, body.get(1));

        verify(servicoUseCase, times(1)).listar();
        verify(servicoDtoMapper, times(1)).toResponse(servico1);
        verify(servicoDtoMapper, times(1)).toResponse(servico2);
    }

    @Test
    void listar_ReturnsEmptyListWhenNoServicos() {
        // Arrange
        when(servicoUseCase.listar()).thenReturn(List.of());

        // Act
        ResponseEntity<List<ServicoResponse>> responseEntity = servicoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().isEmpty());

        verify(servicoUseCase, times(1)).listar();
        verifyNoInteractions(servicoDtoMapper);
    }
}