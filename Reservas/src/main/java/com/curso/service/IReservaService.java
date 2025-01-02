package com.curso.service;

import java.util.List;
import java.util.Map;

import com.curso.model.Reserva;

public interface IReservaService {
	List<Reserva> listaReservasHotel(String hotel);
	Reserva doReserva(Map<String, Object> reservaData);
}
