package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

/**
 * Interfaz que proporcionará métodos CRUD para la gestión de hoteles
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	Hotel findByNombre(String nombre);
	List<Hotel> findByDisponible(Boolean disponible);
}
