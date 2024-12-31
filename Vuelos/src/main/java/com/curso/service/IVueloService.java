package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

public interface IVueloService {
	List<Vuelo> findListPlazas();
	void updateVuelo(int id, int plazas);
}
