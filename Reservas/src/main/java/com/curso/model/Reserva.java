package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que reprensará la entidad "reservas" en la base de datos de "agencia_viajes"
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@Column(name = "id_reserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	private String dni;
	private int idHotel;
	private int idVuelo;

	public Reserva() {
	}

	public Reserva(String nombreCliente, String dni, int idHotel, int idVuelo) {
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getIdReserva() {
		return idReserva;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", nombreCliente=" + nombreCliente + ", dni=" + dni + ", idHotel="
				+ idHotel + ", idVuelo=" + idVuelo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, idHotel, idReserva, idVuelo, nombreCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(dni, other.dni) && idHotel == other.idHotel && idReserva == other.idReserva
				&& idVuelo == other.idVuelo && Objects.equals(nombreCliente, other.nombreCliente);
	}

}
