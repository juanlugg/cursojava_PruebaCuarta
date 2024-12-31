package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

/**
 * Clase que será el servicio que gestione la funcionalidad de las consultas para hoteles
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	HotelRepository repository;

	@Override
	public List<Hotel> findListDisponible() {
		return repository.findByDisponible(true);
	}

	@Override
	public Hotel findByName(String nombre) {
		return repository.findByNombre(nombre);
	}
}
