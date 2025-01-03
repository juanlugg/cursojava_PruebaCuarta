package com.curso.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.inicio.VueloApplication;
import com.curso.model.Vuelo;
import com.curso.service.IVueloService;

@SpringBootTest(classes = { VueloApplication.class })
@AutoConfigureMockMvc
class VueloControllerTest {

	@MockitoBean
	private IVueloService service;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		Vuelo vuelo = new Vuelo("Raynair", "22/10/2022", 56.0, 104);
		when(service.findListPlazas(50)).thenReturn(Arrays.asList(vuelo));
		when(service.updatePlazas(1, 50)).thenReturn(true);
	}

	@Test
	void testFindListPlazas() throws Exception {
		mockMvc.perform(get("/vuelos/50")).andExpect(status().isOk()).andExpect(jsonPath("$[0].company", is("Raynair")))
				.andExpect(jsonPath("$[0].fechaVuelo", is("22/10/2022"))).andExpect(jsonPath("$[0].precio", is(56.0)))
				.andExpect(jsonPath("$[0].plazas", is(104)));
	}

	@Test
	void testUpdateVuelo() throws Exception {
		mockMvc.perform(put("/vuelos/1/50")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}
}
