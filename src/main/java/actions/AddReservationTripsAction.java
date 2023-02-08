package actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class AddReservationTripsAction extends ActionSupport {

    List<String> clientNames;
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
