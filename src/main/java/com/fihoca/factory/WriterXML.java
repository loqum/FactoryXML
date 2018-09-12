package com.fihoca.factory;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fihoca.model.Alumno;

public class WriterXML {

	DocumentBuilderFactory factory = null;
	DocumentBuilder builder = null;
	Document document = null;
	Alumno alumno = new Alumno();

	public void CreateXML(int idAlumno, String nombre, String apellidos, String dni, String path) throws Exception {

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();

			// definimos el elemento raíz del documento
			Element eRaiz = document.createElement("Alumnos");
			document.appendChild(eRaiz);

			// definimos el nodo que contendrá los elementos
			Element eAlumno = document.createElement("Alumno");
			eRaiz.appendChild(eAlumno);

			// atributo para el nodo coche
			Attr atributo = document.createAttribute("id");
			atributo.setValue(String.valueOf(idAlumno));
			eAlumno.setAttributeNode(atributo);

			// definimos cada uno de los elementos y le asignamos un valor
			Element eNombre = document.createElement("Nombre");
			eNombre.appendChild(document.createTextNode(nombre));
			eAlumno.appendChild(eNombre);

			Element eApellidos = document.createElement("Apellidos");
			eApellidos.appendChild(document.createTextNode(apellidos));
			eAlumno.appendChild(eApellidos);

			Element eDNI = document.createElement("DNI");
			eDNI.appendChild(document.createTextNode(dni));
			eAlumno.appendChild(eDNI);

			// clases necesarias finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(path));

			transformer.transform(source, result);
			
			System.out.println("File saved");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}

	}

}
