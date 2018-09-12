package com.fihoca.model;

import lombok.Data;

@Data
public class Alumno {

	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String dni;

	public Alumno() {

	}

	public Alumno(int idAlumno, String nombre, String apellidos, String dni) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

}
