package ircnl.gob.mx.mioficinaapi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ircnl.gob.mx.mioficinaapi.payload.PayloadOficioGeneral;
import ircnl.gob.mx.mioficinaapi.service.PdfServiceImpl;
import ircnl.gob.mx.mioficinaapi.utils.Constantes;
import net.sf.jasperreports.engine.JRException;

// @CrossOrigin(origins = {"*", "http://10.150.130.164:19426"}, maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MainController {
	
	Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	PdfServiceImpl pdfService;
	/*
	@Autowired
	OficiosGeneradosServiceImpl oficiosGeneradosService;
	*/
	@GetMapping("/")
	public String showItWorks() {
		return "It works";
	}
	/*
	@GetMapping("/test")
	public String test() {
		oficiosGeneradosService.saveOficio("parametro1");
		return "It works";
	}
	*/
	/*
	@GetMapping(value = "/pdf/" + Constantes.C_OFICIO_GENERAL_EPNAME, produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] generarOficioGeneral( @ModelAttribute PayloadOficioGeneral payload ) throws IOException, JRException {
		*/
	@GetMapping(value = "/pdf/" + Constantes.C_OFICIO_GENERAL_EPNAME, produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] generarOficioGeneral(
			@RequestParam String personaDestinoNombreCompleto,
			@RequestParam String personaDestinoCargo,
			@RequestParam String personaDestinoDependencia,
			@RequestParam String asunto,
			@RequestParam String parrafo,
			@RequestParam String despedida,
			@RequestParam String personaOrigenNombreCompleto,
			@RequestParam String personaOrigenCargo,
			@RequestParam String personaOrigenDependencia,
			@RequestParam String personaOrigenUbicacion,
			@RequestParam String personaOrigenTelefono,
			@RequestParam String idOficioRecibido,
			@RequestParam String idDependenciaDestino,
			@RequestParam String idSecretariaDestino,
			@RequestParam String idDependenciaOrigen,
			@RequestParam String idSecretariaOrigen
			)  throws IOException, JRException {
		log.info("generarOficioGeneral");
		PayloadOficioGeneral payload = new PayloadOficioGeneral();
		payload.setPersonaDestinoNombreCompleto(personaDestinoNombreCompleto);
		payload.setPersonaDestinoCargo(personaDestinoCargo);
		payload.setPersonaDestinoDependencia(personaDestinoDependencia);
		payload.setAsunto(asunto);
		payload.setParrafo(parrafo);
		payload.setDespedida(despedida);
		payload.setPersonaOrigenNombreCompleto(personaOrigenNombreCompleto);
		payload.setPersonaOrigenCargo(personaOrigenCargo);
		payload.setPersonaOrigenDependencia(personaOrigenDependencia);
		payload.setPersonaOrigenUbicacion(personaOrigenUbicacion);
		payload.setPersonaOrigenTelefono(personaOrigenTelefono);
		payload.setIdOficioRecibido(idOficioRecibido);
		payload.setIdDependenciaDestino(idDependenciaDestino);
		payload.setIdSecretariaDestino(idSecretariaDestino);
		payload.setIdDependenciaOrigen(idDependenciaOrigen);
		payload.setIdSecretariaOrigen(idSecretariaOrigen);
		
		return pdfService.generarOficioGeneral(payload);
	}
	





}
