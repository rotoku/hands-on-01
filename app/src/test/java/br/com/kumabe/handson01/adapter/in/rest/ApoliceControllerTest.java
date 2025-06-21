package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.adapter.in.rest.mapper.ApoliceDtoMapper;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.port.in.ApoliceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ApoliceControllerTest {

    private ApoliceUseCase apoliceUseCase;
    private ApoliceDtoMapper apoliceDtoMapper;
    private ApoliceController apoliceController;

    @BeforeEach
    void setUp() {
        apoliceUseCase = mock(ApoliceUseCase.class);
        apoliceDtoMapper = mock(ApoliceDtoMapper.class);
        apoliceController = new ApoliceController(apoliceUseCase, apoliceDtoMapper);
    }

    @Test
    void listar_returnsListOfApoliceResponse() {
        // Arrange
        Apolice apolice1 = mock(Apolice.class);
        Apolice apolice2 = mock(Apolice.class);
        List<Apolice> apolices = Arrays.asList(apolice1, apolice2);

        ApoliceResponse response1 = mock(ApoliceResponse.class);
        ApoliceResponse response2 = mock(ApoliceResponse.class);

        when(apoliceUseCase.listar()).thenReturn(apolices);
        when(apoliceDtoMapper.toResponse(apolice1)).thenReturn(response1);
        when(apoliceDtoMapper.toResponse(apolice2)).thenReturn(response2);

        // Act
        ResponseEntity<List<ApoliceResponse>> responseEntity = apoliceController.listar();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<ApoliceResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
        assertTrue(body.contains(response1));
        assertTrue(body.contains(response2));

        verify(apoliceUseCase, times(1)).listar();
        verify(apoliceDtoMapper, times(1)).toResponse(apolice1);
        verify(apoliceDtoMapper, times(1)).toResponse(apolice2);
    }

    @Test
    void listar_returnsEmptyListWhenNoApolices() {
        // Arrange
        when(apoliceUseCase.listar()).thenReturn(List.of());

        // Act
        ResponseEntity<List<ApoliceResponse>> responseEntity = apoliceController.listar();

        // Assert
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        List<ApoliceResponse> body = responseEntity.getBody();
        assertNotNull(body);
        assertTrue(body.isEmpty());

        verify(apoliceUseCase, times(1)).listar();
        verify(apoliceDtoMapper, never()).toResponse(ArgumentMatchers.any());
    }
}