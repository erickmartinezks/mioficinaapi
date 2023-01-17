package ircnl.gob.mx.mioficinaapi.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import ircnl.gob.mx.mioficinaapi.payload.PayloadOficioGeneral;
import net.sf.jasperreports.engine.JRException;

@Component
public interface PdfService {
	
	byte[] generarOficioGeneral(PayloadOficioGeneral payload) throws IOException, JRException;

}
