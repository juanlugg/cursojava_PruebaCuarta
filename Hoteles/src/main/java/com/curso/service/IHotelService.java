package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

/**
 * Interfaz que definirá las consultas que se quieren realizar en hoteles
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
public interface IHotelService {
	List<Hotel> findListDisponible();

	Hotel findByName(String nombre);
}
