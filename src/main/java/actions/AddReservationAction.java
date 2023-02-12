package actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Detail;
import data.db_entities.Trip;
import data.db_entities.User;
import domain.ReservationRepository;
import domain.UserRepository;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import utils.Logger;
import utils.LoggerTypes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class AddReservationAction extends ActionSupport implements ServletRequestAware, SessionAware {

    HttpServletRequest request;

    String response;

    private List<String> data;

    Map<String, Object> session;

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    String tab = "details";
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String createReservation() throws Exception {
        Logger.log(LoggerTypes.INFO, data.toString());
        // First element in the array is detail
        Gson gson = new Gson();
        Detail detail = gson.fromJson(data.get(0), Detail.class);
        Trip[] tripsArr = gson.fromJson(data.get(1), Trip[].class);

        Logger.log(LoggerTypes.INFO, "tripsArr - " + Arrays.toString(tripsArr));
        List<Trip> trips = Arrays.stream(tripsArr).parallel()
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());
        Logger.log(LoggerTypes.INFO, "trip - " + trips.toString());

        Integer userID = (Integer) session.get("USER_ID");

        User user = UserRepository.getInstance().getByID(userID);

        detail.setUser(user);

        // The second is an array of trip
        ReservationRepository.getInstance().insertReservation(detail, trips);
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

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
