package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

/**
 * Interfaz que proporcionará métodos CRUD para la gestión de reservas
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
