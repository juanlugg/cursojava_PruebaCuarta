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

/**
 * Clase POJO que define los métodos para las peticiones de vuelos
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@RestController
@RequestMapping("vuelos")
public class VueloController {
	@Autowired
	IVueloService service;

	@GetMapping(value = "/{plazas}")
	public ResponseEntity<List<Vuelo>> findListPlazas(@PathVariable int plazas) {
		return ResponseEntity.ok(service.findListPlazas(plazas));
	}

	@PutMapping(value = "/{id}/{plazas}")
	public ResponseEntity<Vuelo> updateVuelo(@PathVariable int id, @PathVariable int plazas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.updateVuelo(id, plazas));
	}
}
