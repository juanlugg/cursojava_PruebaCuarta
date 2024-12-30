package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

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
