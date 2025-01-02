package com.curso.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.inicio.HotelesApplication;
import com.curso.model.Hotel;
import com.curso.service.IHotelService;

@SpringBootTest(classes = { HotelesApplication.class })
@AutoConfigureMockMvc
class HotelControllerTest {

	@MockitoBean
	private IHotelService service;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		Hotel hotel = new Hotel("Yaramar", 210.0, true);
		when(service.findByName("Yaramar")).thenReturn(hotel);
	}

	@Test
	void findHotelTest() throws Exception {
		mockMvc.perform(get("/hoteles")).andExpect(status().isOk()).andExpect(jsonPath("$[0].nombre", is("Yaramar")))
				.andExpect(jsonPath("$[0].precio", is(210.0))).andExpect(jsonPath("$[0].disponible", is(true)));
	}
}
