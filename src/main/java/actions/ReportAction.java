package actions;

import actions.utils.ReservationUtil;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Report;
import data.db_entities.ReservationResult;
import domain.ReservationRepository;
import jasper.FileType;
import jasper.ReportService;
import utils.Logger;
import utils.LoggerTypes;
import utils.Operator;
import utils.QueryParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReportAction extends ActionSupport {

    public InputStream inputStream;

    public String filename;

    @Override
    public String execute() throws Exception {

        ReservationResult result = loadResults();

        List<Report> reports = ReportService.resultToReport(result);

        filename = "reservation_" + (result.getNextPage() == null ? result.getPages() : result.getNextPage() - 1) + "_of_" + result.getPages();
        File report = ReportService.exportReport(filename, reports, getFileType());
        inputStream = new FileInputStream(report);

        return SUCCESS;
    }

    public ReservationResult loadResults() {
        Map<String, Object> map = ActionContext.getContext().getParameters();
        return ReservationUtil.loadResults(map);
    }

    public FileType getFileType() {
        Map<String, Object> map = ActionContext.getContext().getParameters();

        return QueryParser.getFileType(map);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
