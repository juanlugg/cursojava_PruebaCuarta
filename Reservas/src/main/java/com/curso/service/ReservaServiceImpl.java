package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;

/**
 * Clase que será el servicio que gestione la funcionalidad de las consultas
 * para reservas
 * 
 * @author Juan Luis Guerra Gennich 02/01/2025
 * @version 1.3.0
 */
@Service
public class ReservaServiceImpl implements IReservaService {
	@Autowired
	RestTemplate template;
	@Autowired
	ReservaRepository repository;

	private static final String URL_HOTELES = "http://localhost:8080/hoteles/";
	private static final String URL_VUELOS = "http://localhost:7070/vuelos/";

	@Override
	public Reserva doReserva(Map<String, Object> reservaData) {
		Reserva r = new Reserva((String) reservaData.get("nombre"), (String) reservaData.get("dni"),
				(int) reservaData.get("idHotel"), (int) reservaData.get("idVuelo"));

		boolean actualizado;

		try {
			actualizado = template.exchange(URL_VUELOS + r.getIdVuelo() + "/" + (int) reservaData.get("personas"),
					HttpMethod.PUT, null, Boolean.class).getBody();
		} catch (RestClientException e) {
			actualizado = false;
		}
		if (actualizado) {
			repository.save(r);
			return r;
		} else
			return null;
	}

	@Override
	public List<Reserva> listaReservasHotel(String hotel) {
		List<Reserva> lista = new ArrayList<Reserva>();
		Map<?, ?> h = template.getForObject(URL_HOTELES + hotel, Map.class);
		for (Reserva reserva : repository.findAll()) {
			if (reserva.getIdHotel() == (int) h.get("idHotel")) {
				lista.add(reserva);
			}
		}
		return lista;
	}

}
