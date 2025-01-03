package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que reprensará la entidad "vuelos" en la base de datos de
 * "agencia_viajes"
 * 
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0
 */
@Entity
@Table(name = "vuelos")
public class Vuelo {
	@Id
	@Column(name = "id_vuelo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	private String company;
	@Column(name = "fecha_vuelo")
	private String fechaVuelo;
	private double precio;
	private int plazas;

	public Vuelo() {
	}

	public Vuelo(String company, String fechaVuelo, double precio, int plazas) {
		this.company = company;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazas = plazas;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", company=" + company + ", fechaVuelo=" + fechaVuelo + ", precio="
				+ precio + ", plazas=" + plazas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, fechaVuelo, idVuelo, plazas, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(company, other.company) && Objects.equals(fechaVuelo, other.fechaVuelo)
				&& idVuelo == other.idVuelo && plazas == other.plazas
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

}
