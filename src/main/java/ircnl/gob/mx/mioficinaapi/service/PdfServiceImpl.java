package ircnl.gob.mx.mioficinaapi.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

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
	
	@Override
	public byte[] generarOficioGeneral(String personaDestinoNombreCompleto, String personaDestinoCargo,
			String personaDestinoDependencia, String numeroOficio, String asunto, String parrafo1, String parrafo2,
			String despedida, String personaOrigenNombreCompleto, String personaOrigenCargo,
			String personaOrigenDependencia, String personaOrigenUbicacion) throws IOException, JRException {
		
		log.info("generarOficioGeneral");
		log.info("Begin generarPdf");
		String urlJasper = "/static/reportes/gafetesRechumDoble.jasper";
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		String urlPlantillaGafet = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_ultima.png").getFile().getPath();
		String urlPlantillaGafetReverso = new ClassPathResource("/static/reportes/imagenes/plantilla_gafet_reverso.jpg").getFile().getPath();
		
		parametros.put("plantilla_gafet", urlPlantillaGafet);
		parametros.put("plantilla_gafet_reverso", urlPlantillaGafetReverso);
		
		return  JasperExportManager.exportReportToPdf(generarJasperPrint(urlJasper, parametros, null));
		
		
		// return null;
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

}
