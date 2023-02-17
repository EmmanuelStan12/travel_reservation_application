package actions;

import actions.utils.ReservationUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Report;
import data.db_entities.ReservationResult;
import jasper.FileType;
import jasper.ReportService;
import net.sf.jasperreports.engine.JRException;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DocumentViewerAction extends ActionSupport {

    public InputStream inputStream;

    public InputStream excelInputStream;

    public String filename;

    private String contentDisposition;

    String documentFormat = "xlsx";

    @Override
    public String execute() throws Exception {
        try {
            List<Report> reports = getReports();

            File report = ReportService.exportReport(filename, reports, FileType.PDF);

            inputStream = new DataInputStream(new FileInputStream(report));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String displayExcelSheet() {
        try {
            List<Report> reports = getReports();

            File report = ReportService.exportReport(filename, reports, FileType.EXCEL);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            FileInputStream fio = new FileInputStream(report);

            excelInputStream = new ByteArrayInputStream(fio.readAllBytes());

            contentDisposition = "filename=\"" + filename + "\"";
        } catch (IOException | JRException | URISyntaxException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private List<Report> getReports() {
        Map<String, Object> map = ActionContext.getContext().getParameters();
        ReservationResult result = ReservationUtil.loadResults(map);

        List<Report> reports = ReportService.resultToReport(result);

        filename = "reservation_" + (result.getNextPage() == null ? result.getPages() : result.getNextPage() - 1) + "_of_" + result.getPages();
        return reports;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getExcelInputStream() {
        return excelInputStream;
    }

    public void setExcelInputStream(InputStream excelInputStream) {
        this.excelInputStream = excelInputStream;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    String getExcelContentType() {
        return Objects.equals(documentFormat, "xlsx") ? "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" : "application/vnd.ms-excel";
    }
}
