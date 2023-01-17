package ircnl.gob.mx.mioficinaapi.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ircnl.gob.mx.mioficinaapi.payload.PayloadOficioGeneral;
import ircnl.gob.mx.mioficinaapi.service.PdfServiceImpl;
import ircnl.gob.mx.mioficinaapi.utils.Constantes;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MainController {
	
	Logger log = LogManager.getLogger(MainController.class);
	
	@Autowired
	PdfServiceImpl pdfService;
	
	@GetMapping("/")
	public String showItWorks() {
		return "It works";
	}
	
	@GetMapping(value = "/pdf/" + Constantes.C_OFICIO_GENERAL_EPNAME, produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] generarOficioGeneral( @ModelAttribute PayloadOficioGeneral payload ) throws IOException, JRException {
		
		log.info("generarOficioGeneral");
		return pdfService.generarOficioGeneral(payload);
	}
	
}
