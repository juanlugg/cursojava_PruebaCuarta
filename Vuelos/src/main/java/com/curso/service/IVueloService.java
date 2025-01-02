package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * Interfaz que definirá las consultas que se quieren realizar en vuelos
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
public interface IVueloService {
	List<Vuelo> findListPlazas(int plazas);

	Boolean updatePlazas(int id, int plazas);
}
