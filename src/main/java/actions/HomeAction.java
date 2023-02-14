package actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.*;
import domain.ReservationRepository;
import domain.UserRepository;
import utils.Logger;
import utils.LoggerTypes;
import utils.Operator;
import utils.QueryParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomeAction extends ActionSupport {

    private static final Integer PAGE = 0;
    private static final Integer PER_PAGE = 10;

    private List<String> offices;

    private List<User> owners;
    private List<Operator> operators;

    private List<VehicleType> vehicleTypes;

    private List<PersonnelType> personnelTypes;

    private String reservationJson;

    public String getReservationJson() {
        return reservationJson;
    }

    public void setReservationJson(String reservationJson) {
        this.reservationJson = reservationJson;
    }

    public String loadReservations() {
        Map<String, Object> map = ActionContext.getContext().getParameters();
        Gson gson = new Gson();
        Logger.log(LoggerTypes.INFO, map.toString());
        String query = QueryParser.parse(map);

        Integer pageCount = QueryParser.getPageCount(map);
        Integer page = QueryParser.getPage(map);
        Date date = QueryParser.getDate(map);
        Operator operator = QueryParser.getOperator(map);

        Logger.log(LoggerTypes.INFO, "Date - " + date + " Operator - " + operator);

        Logger.log(LoggerTypes.INFO, "Page - " + page + ", count - " + pageCount);

        if (date != null && operator != null) {
            ReservationResult trips = ReservationRepository.getInstance().getTrips(pageCount, page, query, date, operator);
            Logger.log(LoggerTypes.INFO, trips.toString());
            this.reservationJson = gson.toJson(trips);
            return SUCCESS;
        }

        ReservationResult trips = ReservationRepository.getInstance().getTrips(pageCount, page, query);
        Logger.log(LoggerTypes.INFO, trips.toString());
        this.reservationJson = gson.toJson(trips);
        return SUCCESS;
    }

    public List<PersonnelType> getPersonnelTypes() {
        return personnelTypes;
    }

    public void setPersonnelTypes(List<PersonnelType> personnelTypes) {
        this.personnelTypes = personnelTypes;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    @Override
    public String execute() throws Exception {

        owners = UserRepository.getInstance().getOwners();

        vehicleTypes = ReservationRepository.getInstance().getVehicleTypes();

        personnelTypes = ReservationRepository.getInstance().getPersonnelTypes();

        return SUCCESS;
    }

    public List<String> getOffices() {
        if (offices == null) {
            offices = new ArrayList<>();
            offices.add("Abuja Office");
            offices.add("AG Levantis Head Office");
            offices.add("AGBARA COMMERCIAL");
            offices.add("Calabar Office");
            offices.add("Head Office Lagos");
            offices.add("Upland");
        }
        return offices;
    }

    public List<User> getOwners() {
        return owners;
    }

    public void setOffices(List<String> offices) {
        this.offices = offices;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Operator> getOperators() {
        if (operators == null) {
            operators = new ArrayList<>();
            operators.add(Operator.EQUAL);
            operators.add(Operator.LESS_THAN);
            operators.add(Operator.GREATER_THAN);
        }
        return operators;
    }

    public String getPersonals() {
        return "";
    }
}
