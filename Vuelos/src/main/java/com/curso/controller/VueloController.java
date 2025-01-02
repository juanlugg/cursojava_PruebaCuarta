package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.IVueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase POJO que define los métodos para las peticiones de vuelos
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@Tag(name = "Vuelos", description = "La API de vuelos")
@RestController
@RequestMapping("vuelos")
public class VueloController {
	@Autowired
	IVueloService service;

	@Operation(summary = "Lista de vuelos con plazas mayor o igual a al valor que se busque")
	@ApiResponse(responseCode = "200", description = "Lista de vuelos con plazas deseadas")
	@ApiResponse(responseCode = "404", description = "No hay ningún vuelo con la cantidad solicitada")
	@GetMapping(value = "/{plazas}")
	public ResponseEntity<List<Vuelo>> findListPlazas(@PathVariable int plazas) {
		return ResponseEntity.ok(service.findListPlazas(plazas));
	}

	@Operation(summary = "Actualizar las plazas libres", description = "Se pide el id del vuelo y las plazas que se quieren reservar, si es posible.")
	@ApiResponse(responseCode = "200", description = "Se ha actualizado las plazas correctamente")
	@ApiResponse(responseCode = "400", description = "No hay plazas suficiente plazas libres")
	@PutMapping(value = "/{id}/{plazas}")
	public ResponseEntity<Boolean> updateVuelo(@PathVariable int id, @PathVariable int plazas) {
		boolean actualizado = service.updatePlazas(id, plazas);
		return ResponseEntity.status(actualizado ? HttpStatus.OK : HttpStatus.BAD_REQUEST).body(actualizado);
	}
}
