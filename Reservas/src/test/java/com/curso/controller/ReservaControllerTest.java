package com.curso.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.inicio.ReservaApplication;
import com.curso.model.Reserva;
import com.curso.service.IReservaService;

@SpringBootTest(classes = { ReservaApplication.class })
@AutoConfigureMockMvc
class ReservaControllerTest {
	@MockitoBean
	private IReservaService service;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		Reserva reserva = new Reserva("Juanlu", "79059xxxX", 1, 1);
		Map<String, Object> reservaData = new HashMap<>();
		reservaData.put("idVuelo", 1);
		reservaData.put("idHotel", 1);
		reservaData.put("nombre", "Juanlu");
		reservaData.put("dni", "79059xxxX");
		reservaData.put("personas", 2);
		when(service.doReserva(reservaData)).thenReturn(reserva);
		when(service.listaReservasHotel("Yaramar")).thenReturn(Arrays.asList(reserva));
	}

	@Test
	void testDoReserva() throws Exception {
		mockMvc.perform(post("/reservas").contentType(MediaType.APPLICATION_JSON).content(
				"{\"idVuelo\": 1, \"idHotel\": 1, \"nombre\": \"Juanlu\", \"dni\": \"790590xxX\", \"personas\": 2}"))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.idVuelo", is(1)))
				.andExpect(jsonPath("$.idHotel", is(1))).andExpect(jsonPath("$.nombre", is("Juanlu")))
				.andExpect(jsonPath("$.dni", is("79059xxxX"))).andExpect(jsonPath("$.personas", is(2)));
	}

	@Test
	void testListaReservasHotel() throws Exception {
		mockMvc.perform(get("/reservas/Yaramar")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].nombreCliente", is("Juanlu")))
				.andExpect(jsonPath("$[0].dni", is("79059xxxX"))).andExpect(jsonPath("$[0].idHotel", is(1)))
				.andExpect(jsonPath("$[0].idVuelo", is(1)));
	}
}
