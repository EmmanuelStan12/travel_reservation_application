package actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Detail;
import data.db_entities.Trip;
import org.apache.struts2.interceptor.ServletRequestAware;
import utils.Logger;
import utils.LoggerTypes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class AddReservationAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;

    String trips;
    String detail;

    private List<String> data;

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public String getTrips() {
        return trips;
    }

    public void setTrips(String trips) {
        this.trips = trips;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    String tab = "details";
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String createReservation() {
        Logger.log(LoggerTypes.INFO, data.toString());
        // First element in the array is detail
        String detail = data.get(0);
        Gson gson = new Gson();
        Detail reservationDetails = gson.fromJson(detail, Detail.class);
        Trip[] trips = gson.fromJson(data.get(1), Trip[].class);
        Logger.log(LoggerTypes.INFO, trips.toString());
        // The second is an array of trips
        Logger.log(LoggerTypes.INFO, Arrays.toString(data.get(0).toCharArray()));
        return SUCCESS;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

}
