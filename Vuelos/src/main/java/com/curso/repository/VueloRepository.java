package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Vuelo;

/**
 * Interfaz que proporcionará métodos CRUD para la gestión de vuelos
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
	List<Vuelo> findByPlazasGreaterThanEqual(int plazas);
}
