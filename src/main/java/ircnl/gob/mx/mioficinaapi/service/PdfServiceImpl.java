package ircnl.gob.mx.mioficinaapi.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import ircnl.gob.mx.mioficinaapi.payload.PayloadOficioGeneral;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class PdfServiceImpl implements PdfService {

	Logger log = LogManager.getLogger(PdfServiceImpl.class);
	
	@Value("${folder.repositorio}")
	private String folderRepositorio;
	
	@Override
	public byte[] generarOficioGeneral(PayloadOficioGeneral payload) throws IOException, JRException {
		generarImagenQr();
		log.info("generarOficioGeneral");
		log.info("Begin generarPdf");
		String urlJasper = "/static/reportes/gafetesRechumDoble.jasper";
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		String urlPlantillaGafet = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_ultima.png").getFile().getPath();
		String urlPlantillaGafetReverso = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_reverso.jpg").getFile().getPath();
		

		LocalDate fecha = LocalDate.now();
		Month mes = fecha.getMonth();
		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		nombreMes = nombreMes.substring(0,1).toUpperCase() + nombreMes.substring(1);
		String strFecha = fecha.getDayOfMonth() + " de " + nombreMes + " de " + fecha.getYear();
		// System.out.println("Fecha completa: " + strFecha);
		
		parametros.putAll(new HashMap<String, String>());
		parametros.put("personaDestinoNombreCompleto", payload.getPersonaDestinoNombreCompleto());
		parametros.put("personaDestinoCargo", payload.getPersonaDestinoCargo());
		parametros.put("personaDestinoDependencia", payload.getPersonaDestinoDependencia());
		parametros.put("numeroOficio", payload.getNumeroOficio());
		parametros.put("asunto", payload.getAsunto());
		parametros.put("parrafo1", payload.getParrafo());
		parametros.put("despedida", payload.getDespedida());
		parametros.put("personaOrigenNombreCompleto", payload.getPersonaOrigenNombreCompleto());
		parametros.put("personaOrigenCargo", payload.getPersonaOrigenCargo());
		parametros.put("personaOrigenDependencia", payload.getPersonaOrigenDependencia());
		parametros.put("personaOrigenUbicacion", payload.getPersonaOrigenUbicacion());
		parametros.put("cadenaFecha", strFecha);
		
		return  JasperExportManager.exportReportToPdf(generarJasperPrint(urlJasper, parametros, null));
	}
	
	private JasperPrint generarJasperPrint(String urlJasper, Map<String, Object> parametros,
			Collection<Object> campos) {
		log.info("Begin generarJasperPrint");
		JRDataSource jrDataSource = null;
		JasperPrint jasperPrint = null;

		if (campos == null || campos.isEmpty()) {
			jrDataSource = new JREmptyDataSource();
		} else {
			jrDataSource = new JRBeanCollectionDataSource(campos);
		}

		try {
			File file = new ClassPathResource(urlJasper).getFile();
			final JasperReport report = (JasperReport) JRLoader.loadObject(file);
			jasperPrint = JasperFillManager.fillReport(report, parametros, jrDataSource);
			jasperPrint.setName("test");
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("End generarJasperPrint");
		return jasperPrint;
	}

	private HashMap<String, String> generarImagenQr() {
		HashMap<String, String> response = new HashMap<>();
		response.put("pathQr", "");
		response.put("contenidoQr", "");
		try {
			
			String randomHexadecimalText = "Texto de prueba";
	    	QRCodeWriter barcodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = barcodeWriter.encode(randomHexadecimalText, BarcodeFormat.QR_CODE, 200, 200);
	
	        File outputFile = new File(folderRepositorio + File.separator + randomHexadecimalText + ".png" );
	        		// "C:\\\\Users\\erick.martinez\\Documents\\Procesos\\Gafetes\\imagenes\\qrPrueba.png");
		    ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", outputFile);
		
		    response.put("pathQr", outputFile.getAbsolutePath());
			response.put("contenidoQr", randomHexadecimalText);
			log.info("Contenido de hashmap: " + response);
		} catch (Exception err) {
	    	log.warn("generarImagenQr - Se generó un error al generar la imagen QR: [" + err.getMessage() + "]");
	    }
		
		return response; 
	}
	
	
}
