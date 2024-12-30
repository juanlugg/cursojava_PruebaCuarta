package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

public interface IHotelService {
	List<Hotel> findListDisponible();

	Hotel findByName(String nombre);
}
