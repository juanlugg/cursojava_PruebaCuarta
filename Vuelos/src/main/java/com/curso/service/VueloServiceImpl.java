package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;

/**
 * Clase que será el servicio que gestione la funcionalidad de las consultas
 * para vuelos
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@Service
public class VueloServiceImpl implements IVueloService {
	@Autowired
	VueloRepository repository;

	@Override
	public List<Vuelo> findListPlazas(int plazas) {
		return repository.findByPlazasGreaterThanEqual(plazas);
	}

	@Override
	public Boolean updatePlazas(int id, int plazas) {
		Vuelo v = repository.findById(id).orElse(null);
		if (v != null && v.getPlazas() >= plazas) {
			v.setPlazas(v.getPlazas() - plazas);
			repository.save(v);
			return true;
		} else
			return false;
	}
}
