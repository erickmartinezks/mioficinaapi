package ircnl.gob.mx.mioficinaapi.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.sf.jasperreports.engine.JRException;

@Component
public interface PdfService {

	byte[] generarOficioGeneral(String personaDestinoNombreCompleto, 
			String personaDestinoCargo, 
			String personaDestinoDependencia, 
			String numeroOficio, 
			String asunto, 
			String parrafo,
			String despedida, 
			String personaOrigenNombreCompleto, 
			String personaOrigenCargo, 
			String personaOrigenDependencia, 
			String personaOrigenUbicacion,
			String personaOrigenTelefono) throws IOException, JRException;
	
	/*
	byte[] generarPdf(MultipartFile personaImagen, String personaNombres, String personaApellidos, String personaDepartamento, String personaNumeroEmpleado, String leftPadding, String topPadding, 
			MultipartFile personaImagen2, String personaNombres2, String personaApellidos2, String personaDepartamento2, String personaNumeroEmpleado2, String leftPadding2, String topPadding2, String fontSize, String fontSize2) throws IOException, JRException;

	byte[] generarPdfRechum(MultipartFile personaImagen, String personaNombres, String personaApellidos, String personaDepartamento, String personaNumeroEmpleado,
			String leftPadding, String topPadding, String fontSize) throws IOException, JRException;
	*/
}
