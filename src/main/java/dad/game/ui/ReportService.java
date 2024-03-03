package dad.game.ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportService {

    public static final String JRXML_FILE = "/reports/HighScore.jrxml";
    public static final String PDF_FILE = "Score.pdf";

    public static void generarPdf(List<Puntuacion> lista) throws JRException, IOException {
        // Compilamos el informe
        JasperReport report = JasperCompileManager.compileReport(ReportService.class.getResourceAsStream(JRXML_FILE));

        // Mapeamos los parametros para el informe (si es necesario)
        Map<String, Object> parameters = new HashMap<String, Object>();

        // Generamos el pdf (combinamos el informe compilado con los datos)
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(lista));

        // Exportamos el informe a un fichero PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, PDF_FILE);

        // Abrimos el archivo PDF generado con el programa predeterminado del sistema
        Desktop.getDesktop().open(new File(PDF_FILE));
    }

    public static void main(String[] args) {
        // Crear algunos datos de ejemplo (aquí puedes pasar tu lista con los datos)
        List<Puntuacion> lista = new ArrayList<>();
        lista.add(new Puntuacion("Javier", 10));
        lista.add(new Puntuacion("Luis", 15));
        lista.add(new Puntuacion("Pedro", 20));

        try {
            ReportService.generarPdf(lista);
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}