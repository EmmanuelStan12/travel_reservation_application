package jasper;

import data.db_entities.Report;
import data.db_entities.ReservationResult;
import data.db_entities.Trip;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import utils.Logger;
import utils.LoggerTypes;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    private static final String JRXML_PATH = "/";

    public static List<Report> resultToReport(ReservationResult result) {
        List<Report> reports = new ArrayList<>();
        for (Trip trip: result.getTrips()) {
            Report report = new Report();
            report.setId(trip.getId());
            report.setCreatedAt(trip.getCreatedAt());
            report.setClientType(trip.getDetail().getClientType());
            report.setRoute(trip.getCreatedAt() + " : " + trip.getDeparture() + " -> " + trip.getDestination());
            report.setStatus(trip.getDetail().getStatus());
            report.setTotalAmount(trip.getTotalAmount());
            report.setOffice(trip.getDetail().getOffice());
            report.setDate(trip.getDetail().getDate());
            reports.add(report);
        }
        return reports;
    }

    public static File exportReport(
            String filename,
            List<Report> reports,
            FileType type
    ) throws JRException, URISyntaxException {
        //Load the jrxml file and compile
        Logger.log(LoggerTypes.INFO, "Please wait...");
        var f = ReportService.class.getClassLoader().getResource("reservation.jrxml");
        File jxmlFile = new File(f.toURI());
        JasperReport report = JasperCompileManager.compileReport(jxmlFile.getAbsolutePath());
        Map<String, Object> params = new HashMap<>();

        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(reports);
        JasperPrint print = JasperFillManager.fillReport(report, params, source);
        if (type == FileType.EXCEL) {
            return exportToExcel(filename, print);
        } else {
            return exportToPDF(filename, print);
        }
    }

    private static File exportToPDF(
            String filename,
            JasperPrint print
    ) throws JRException {
        File destinationFile = new File(filename + ".pdf");

        JasperExportManager.exportReportToPdfFile(print, destinationFile.getAbsolutePath());
        Logger.log(LoggerTypes.INFO, "Done...");
        return destinationFile;
    }

    private static File exportToExcel(
            String filename,
            JasperPrint print
    ) throws JRException {
        File destinationFile = new File(filename + ".xlsx");

        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        //we set the one page per sheet parameter here
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
        Logger.log(LoggerTypes.INFO, "Done...");
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destinationFile.getAbsolutePath());
        exporter.exportReport();
        Logger.log(LoggerTypes.INFO, "Exported " + filename + " to " + destinationFile.getAbsolutePath());
        return destinationFile;
    }
}
