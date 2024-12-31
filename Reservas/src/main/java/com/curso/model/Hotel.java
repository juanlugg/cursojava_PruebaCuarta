package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que reprensará la entidad "hoteles" en la base de datos de "agencia_viajes"
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
@Entity
@Table(name = "hoteles")
public class Hotel {
	@Id
	@Column(name = "id_hotel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHotel;
	private String nombre;
	private Double precio;
	private Boolean disponible;

	public Hotel() {
	}

	public Hotel(String nombre, Double precio, Boolean disponible) {
		this.nombre = nombre;
		this.precio = precio;
		this.disponible = disponible;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public int getIdHotel() {
		return idHotel;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nombre=" + nombre + ", precio=" + precio + ", disponible=" + disponible
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponible, idHotel, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(disponible, other.disponible) && idHotel == other.idHotel
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

}
