package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.EnderecoResponse;
import br.com.kumabe.handson01.adapter.in.rest.dto.SeguradoResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.SeguradoDtoMapper;
import br.com.kumabe.handson01.domain.model.Segurado;
import br.com.kumabe.handson01.domain.model.port.in.SeguradoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;






class SeguradoControllerTest {

    private SeguradoUseCase seguradoUseCase;
    private SeguradoDtoMapper seguradoDtoMapper;
    private SeguradoController seguradoController;

    @BeforeEach
    void setUp() {
        seguradoUseCase = mock(SeguradoUseCase.class);
        seguradoDtoMapper = mock(SeguradoDtoMapper.class);
        seguradoController = new SeguradoController(seguradoUseCase, seguradoDtoMapper);
    }

    @Test
    void listar_shouldReturnListOfSeguradoResponses() {
        // Arrange
        Segurado segurado1 = mock(Segurado.class);
        Segurado segurado2 = mock(Segurado.class);
        List<Segurado> segurados = Arrays.asList(segurado1, segurado2);

        SeguradoResponse response1 = mock(SeguradoResponse.class);
        SeguradoResponse response2 = mock(SeguradoResponse.class);

        when(seguradoUseCase.listar()).thenReturn(segurados);
        when(seguradoDtoMapper.toResponse(segurado1)).thenReturn(response1);
        when(seguradoDtoMapper.toResponse(segurado2)).thenReturn(response2);

        // Act
        ResponseEntity<List<SeguradoResponse>> responseEntity = seguradoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<SeguradoResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
        assertTrue(body.contains(response1));
        assertTrue(body.contains(response2));

        verify(seguradoUseCase, times(1)).listar();
        verify(seguradoDtoMapper, times(1)).toResponse(segurado1);
        verify(seguradoDtoMapper, times(1)).toResponse(segurado2);
    }

        @Test
    void listar_ReturnsEmptyListWhenNoSegurados() {
        // Arrange
        when(seguradoUseCase.listar()).thenReturn(List.of());

        // Act
        ResponseEntity<List<SeguradoResponse>> responseEntity = seguradoController.listar();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<SeguradoResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertTrue(body.isEmpty());

        verify(seguradoUseCase, times(1)).listar();
        verifyNoInteractions(seguradoDtoMapper);
    }
}