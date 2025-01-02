package com.curso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.IReservaService;

/**
 * Clase POJO que define los métodos para las peticiones de reservas
 * 
 * @author Juan Luis Guerra Gennich 02/01/2025
 * @version 1.2.0
 */
@RestController
@RequestMapping("reservas")
public class ReservaController {
	@Autowired
	IReservaService service;

	@PostMapping
	public ResponseEntity<Object> doReserva(@RequestBody Map<String, Object> reservaData) {
		Reserva reserva = service.doReserva(reservaData);
		if (reserva != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
		} else {
			String errorMessage = "No hay suficientes plazas disponibles para completar la reserva.";
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensaje", errorMessage));
		}
	}

	@GetMapping(value = "/{nombreHotel}")
	public ResponseEntity<List<Reserva>> listaReservasHotel(@PathVariable String nombreHotel) {
		return ResponseEntity.ok(service.listaReservasHotel(nombreHotel));
	}

}
