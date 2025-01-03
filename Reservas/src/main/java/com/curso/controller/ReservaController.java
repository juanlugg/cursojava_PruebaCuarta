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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase POJO que define los métodos para las peticiones de reservas
 * 
 * @author Juan Luis Guerra Gennich 02/01/2025
 * @version 1.2.0
 */
@Tag(name = "Reservas", description = "La API de reservas")
@RestController
@RequestMapping("reservas")
public class ReservaController {
	@Autowired
	IReservaService service;

	@Operation(summary = "Realizar una reserva con datos especificos", description = "Para la reserva se pide un JSON con nombre del cliente, dni, idHotel, idVuelo y personas que reservaran. Actualizará las plazas de la API vuelos")
	@ApiResponse(responseCode = "201", description = "Reserva creada correctamente")
	@ApiResponse(responseCode = "400", description = "No se pudo crear la reserva por datos erroneos")
	@ApiResponse(responseCode = "409", description = "Conflico en la creación de la reserva ya existente")
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

	@Operation(summary = "Lista de reservas en un hotel", description = "Lista de reservas de un hotel buscado por nombre en la API de hoteles")
	@ApiResponse(responseCode = "200", description = "Lista de reservas encontrada")
	@ApiResponse(responseCode = "404", description = "No hay ninguna reserva asociada a este hotel")
	@GetMapping(value = "/{nombreHotel}")
	public ResponseEntity<List<Reserva>> listaReservasHotel(@PathVariable String nombreHotel) {
		return ResponseEntity.ok(service.listaReservasHotel(nombreHotel));
	}

}
