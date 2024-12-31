package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

public interface IReservaService {
	void reservar(Object objeto);
	List<Reserva> listaReservasHotel(String hotel);
}
