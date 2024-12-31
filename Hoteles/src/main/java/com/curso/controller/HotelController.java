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

/**
 * Clase POJO que define los métodos para las peticiones de hoteles
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@RestController
@RequestMapping("hoteles")
public class HotelController {
	@Autowired
	IHotelService service;

	@GetMapping(value = "/{nombre}")
	public ResponseEntity<Hotel> findHotel(@PathVariable String nombre) {
		// return service.findByName(nombre);
		return ResponseEntity.ok(service.findByName(nombre));
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> listDisponible() {
		return ResponseEntity.ok(service.findListDisponible());
	}
}
