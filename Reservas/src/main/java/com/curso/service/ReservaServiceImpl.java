package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Hotel;
import com.curso.model.Reserva;

public class ReservaServiceImpl implements IReservaService {
	@Autowired
	RestTemplate template;

	private static final String URL_HOTELES = "http://localhost:8080/hoteles/";
	@Override
	public void reservar(Object objeto) {

	}

	@Override
	public List<Reserva> listaReservasHotel(String hotel) {
		Hotel h = template.getForObject(URL_HOTELES + hotel, Hotel.class);
		return null;
	}

}
