package com.fihoca.principal;

import com.fihoca.factory.WriterXML;
import com.fihoca.model.Alumno;

public class Main {

	public static void main(String[] args) throws Exception {

		WriterXML writerXML = new WriterXML();
		Alumno alumno = new Alumno(2, "Ruben", "Fernandez", "47662275L");

		try {
			writerXML.CreateXML(alumno.getIdAlumno(), alumno.getNombre(), alumno.getApellidos(), alumno.getDni(),
					"archivo.xml");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not saved" + e);
			throw e;
		}

	}

}
