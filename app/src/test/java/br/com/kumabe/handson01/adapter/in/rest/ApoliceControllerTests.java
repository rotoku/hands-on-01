package br.com.kumabe.handson01.adapter.in.rest;

import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceRequest;
import br.com.kumabe.handson01.adapter.in.rest.dto.ApoliceResponse;
import br.com.kumabe.handson01.application.port.in.ApoliceUseCase;
import br.com.kumabe.handson01.domain.model.Apolice;
import br.com.kumabe.handson01.domain.model.TipoApolice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ApoliceController.class)
class ApoliceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApoliceUseCase apoliceUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    private Apolice apolice;
    private ApoliceRequest apoliceRequest;

    @BeforeEach
    void setUp() {
        apoliceRequest = new ApoliceRequest(TipoApolice.AUTOMOVEL, LocalDate.of(2024, 1, 1));
        apolice = new Apolice(123, TipoApolice.AUTOMOVEL, LocalDate.of(2024, 1, 1), null, null);
    }

    @Test
    void testCreateApolice() throws Exception {
        when(apoliceUseCase.create(ArgumentMatchers.any(Apolice.class))).thenReturn(apolice);

        mockMvc.perform(post("/api/v1/apolices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(apoliceRequest)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/api/v1/apolices/123"));
    }

    @Test
    void testListApolices() throws Exception {
        when(apoliceUseCase.list()).thenReturn(List.of(apolice));

        mockMvc.perform(get("/api/v1/apolices")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numero").value(123))
                .andExpect(jsonPath("$[0].tipo_apolice").value("AUTOMOVEL"))
                .andExpect(jsonPath("$[0].data_vigencia").value("2024-01-01"));
    }
}