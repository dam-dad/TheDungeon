package dad.game.ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dad.pokemonfx.batalla.Pokemon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


  
    public class ReportService {

    	public static final String JRXML_FILE = "/reports/Pokemon.jrxml";
    	public static final String PDF_FILE = "ListaPokemon.pdf";

    	public static void generarPdf(List<Puntuacion> lista) throws JRException, IOException {

    		/**
    		 * Compilamos el informe
    		 */
    		JasperReport report = JasperCompileManager.compileReport(GenerarPDF.class.getResourceAsStream(JRXML_FILE));

    		/**
    		 * Mapeamos los parametros para el informe
    		 */
    		Map<String, Object> parameters = new HashMap<String, Object>();

    		/**
    		 * Generamos el pdf (combinamos el informe compilado con los datos)
    		 */
    		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters,
    				new JRBeanCollectionDataSource(lista));

    		/**
    		 * exportamos el informe a un fichero PDF
    		 */
    		JasperExportManager.exportReportToPdfFile(jasperPrint, PDF_FILE);

    		/**
    		 * Abrrimos el archivo PDF generado con el programa predeterminado del sistema
    		 */
    		Desktop.getDesktop().open(new File(PDF_FILE));
    	}

    }