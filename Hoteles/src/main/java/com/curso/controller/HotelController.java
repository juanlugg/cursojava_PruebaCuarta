package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.IHotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase POJO que define los métodos para las peticiones de hoteles
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@Tag(name = "Hoteles", description = "La API de hoteles")
@RestController
@RequestMapping("hoteles")
public class HotelController {
	@Autowired
	IHotelService service;

	@Operation(summary = "Buscar un hotel por su nombre")
	@ApiResponse(responseCode = "200", description = "Hotel encontrado")
	@ApiResponse(responseCode = "404", description = "No se ha encontrado ningún hotel con ese nombre")
	@GetMapping(value = "/{nombre}")
	public ResponseEntity<Hotel> findHotel(@PathVariable String nombre) {
		// return service.findByName(nombre);
		return ResponseEntity.ok(service.findByName(nombre));
	}
	
	@Operation(summary = "Lista de hoteles disponibles")
	@ApiResponse(responseCode = "200", description = "Hoteles disponibles")
	@ApiResponse(responseCode = "404", description = "No hay ningún hotel disponible")
	@GetMapping
	public ResponseEntity<List<Hotel>> listDisponible() {
		return ResponseEntity.ok(service.findListDisponible());
	}
}
