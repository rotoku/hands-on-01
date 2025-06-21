package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.EnderecoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.EnderecoDtoMapper;
import br.com.kumabe.handson01.domain.model.Endereco;
import br.com.kumabe.handson01.domain.model.port.in.EnderecoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnderecoControllerTest {

    private EnderecoUseCase enderecoUseCase;
    private EnderecoDtoMapper enderecoDtoMapper;
    private EnderecoController enderecoController;

    @BeforeEach
    void setUp() {
        enderecoUseCase = mock(EnderecoUseCase.class);
        enderecoDtoMapper = mock(EnderecoDtoMapper.class);
        enderecoController = new EnderecoController(enderecoUseCase, enderecoDtoMapper);
    }

    @Test
    void listar_ReturnsListOfEnderecoResponse() {
        // Arrange
        Endereco endereco1 = mock(Endereco.class);
        Endereco endereco2 = mock(Endereco.class);
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);

        EnderecoResponse response1 = mock(EnderecoResponse.class);
        EnderecoResponse response2 = mock(EnderecoResponse.class);

        when(enderecoUseCase.listar()).thenReturn(enderecos);
        when(enderecoDtoMapper.toResponse(endereco1)).thenReturn(response1);
        when(enderecoDtoMapper.toResponse(endereco2)).thenReturn(response2);

        // Act
        ResponseEntity<List<EnderecoResponse>> responseEntity = enderecoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<EnderecoResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
        assertTrue(body.contains(response1));
        assertTrue(body.contains(response2));

        verify(enderecoUseCase, times(1)).listar();
        verify(enderecoDtoMapper, times(1)).toResponse(endereco1);
        verify(enderecoDtoMapper, times(1)).toResponse(endereco2);
    }

    @Test
    void listar_ReturnsEmptyListWhenNoEnderecos() {
        // Arrange
        when(enderecoUseCase.listar()).thenReturn(List.of());

        // Act
        ResponseEntity<List<EnderecoResponse>> responseEntity = enderecoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<EnderecoResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertTrue(body.isEmpty());

        verify(enderecoUseCase, times(1)).listar();
        verifyNoInteractions(enderecoDtoMapper);
    }
}