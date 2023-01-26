package ircnl.gob.mx.mioficinaapi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import ircnl.gob.mx.mioficinaapi.payload.PayloadOficioGeneral;
import ircnl.gob.mx.mioficinaapi.repository.OficiosGeneradosRepository;
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
	
	@Value("${preurl.qr}")
	private String preurlQr;
	
	@Autowired
	OficiosGeneradosRepository oficiosGeneradosRepository;
	
	@Override
	public byte[] generarOficioGeneral(PayloadOficioGeneral payload) throws IOException, JRException {
		log.info("Begin generarOficioGeneral");
		String urlJasper = "/static/reportes/oficio.jasper";
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		// String urlPlantillaGafet = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_ultima.png").getFile().getPath();
		// String urlPlantillaGafetReverso = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_reverso.jpg").getFile().getPath();

		LocalDate fecha = LocalDate.now();
		Month mes = fecha.getMonth();
		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		nombreMes = nombreMes.substring(0,1).toUpperCase() + nombreMes.substring(1);
		String strFecha = fecha.getDayOfMonth() + " de " + nombreMes + " del " + fecha.getYear();
		parametros.putAll(generarImagenQr());
		
		String numeroOficio = oficiosGeneradosRepository.callOFSPA_OficiosGenerados(
				"", // cuentaUsuario
				payload.getAsunto(),// asunto
				payload.getIdSecretariaOrigen(), // idSriaProc
				"", // SriaProc
				payload.getIdDependenciaOrigen(), // idDepciaProc
				payload.getPersonaOrigenDependencia(),// depciaProc
				10, // idTipoOf
				"",	// tipoOf
				1,// idEstatusOf
				"",	// estatusOf
				payload.getIdDependenciaDestino(), // idDepciaAsig
				payload.getPersonaOrigenDependencia(),	// depciaAsig
				"2023-01-26 13:40:00", // fechaOficio
				payload.getPersonaDestinoNombreCompleto(), // dirigidoA
				payload.getDespedida(), // despedida
				Integer.parseInt(payload.getIdOficioRecibido()), // idOficioRecibido
				parametros.get("cadenaQr").toString(), // nombreOficio
				payload.getPersonaOrigenTelefono(), // telefonoOficioG
				payload.getPersonaOrigenUbicacion(), // ubicacionOficioG
				payload.getParrafo(), // parrafo
				payload.getPersonaDestinoCargo(), // puestoDirigidoA
				payload.getPersonaOrigenCargo(), // puestoRemitente
				payload.getIdSecretariaOrigen()); // idSecretariaRemitent
		
		
		parametros.put("numeroOficio", numeroOficio);
		parametros.put("personaDestinoNombreCompleto", payload.getPersonaDestinoNombreCompleto());
		parametros.put("personaDestinoCargo", payload.getPersonaDestinoCargo());
		parametros.put("personaDestinoDependencia", payload.getPersonaDestinoDependencia());
		parametros.put("asunto", payload.getAsunto());
		parametros.put("parrafo", payload.getParrafo());
		parametros.put("despedida", payload.getDespedida());
		parametros.put("personaOrigenNombreCompleto", payload.getPersonaOrigenNombreCompleto());
		parametros.put("personaOrigenCargo", payload.getPersonaOrigenCargo());
		parametros.put("personaOrigenDependencia", payload.getPersonaOrigenDependencia());
		parametros.put("personaOrigenUbicacion", payload.getPersonaOrigenUbicacion());
		parametros.put("telefono", payload.getPersonaOrigenTelefono());
		parametros.put("fecha", strFecha);
		
		byte [] response = JasperExportManager.exportReportToPdf(generarJasperPrint(urlJasper, parametros, null));
		guardarOficioRepositorio(parametros.get("cadenaQr").toString(), response);
		
		log.info("End generarOficioGeneral");
		return  response;
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
		log.info("Begin generarImagenQr");
		response.put("pathQr", "");
		response.put("cadenaQr", "");
		try {
			
			String randomHexadecimalText = generarHexadecimal();
	    	QRCodeWriter barcodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = barcodeWriter.encode(preurlQr + randomHexadecimalText, BarcodeFormat.QR_CODE, 200, 200);
	
	        File outputFile = new File(folderRepositorio + File.separator + randomHexadecimalText + ".png" );
		    ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", outputFile);
		
		    response.put("pathQr", outputFile.getAbsolutePath());
			response.put("cadenaQr", randomHexadecimalText);
			log.info("Contenido de hashmap: " + response);
		} catch (Exception err) {
	    	log.warn("generarImagenQr - Se generó un error al generar la imagen QR: [" + err.getMessage() + "]");
	    }
		
		log.info("End generarImagenQr");
		return response; 
	}
	
	private String generarHexadecimal() {
		log.info("Begin generarHexadecimal");
		String hexadecimal = "";
		int num = 0;
		Random random = new Random();
		
        for (int i = 0; i < 4; i++)
        {
        	num = random.nextInt(0, Integer.MAX_VALUE);
            hexadecimal += String.format("%4X", num);
        }
        
        log.info("End generarHexadecimal");
		return hexadecimal;
	}
	
	private void guardarOficioRepositorio(String nombrePdf, byte[] pdfByteArray) {
		File outputFile = new File(folderRepositorio + File.separator + nombrePdf + ".pdf" );
		try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
		    outputStream.write(pdfByteArray);
		} catch (Exception err) {
			log.warn("Error al guardar el oficio en el repositorio. [ " + err.getMessage() + " ]" );
		}	
	}
	
	
}
