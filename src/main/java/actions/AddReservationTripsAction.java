package actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Personnel;
import data.db_entities.PersonnelType;
import data.db_entities.Vehicle;
import data.db_entities.VehicleType;
import domain.ReservationRepository;
import utils.Logger;
import utils.LoggerTypes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AddReservationTripsAction extends ActionSupport {

    List<String> clientNames;

    String passengerName, passengerEmail, departure, destination, possibleStops, vehicleCategory;

    Integer noOfPassengers, pricePerDay;

    List<PersonnelType> personnelTypes;

    List<VehicleType> vehicleTypes;

    List<Vehicle> vehicles;
    String vehicleJson;

    List<Personnel> personals;
    String personalJson;

    InputStream inputStream;
    @Override
    public String execute() throws Exception {
        //ServletActionContext.getResponse();
        inputStream = new ByteArrayInputStream("Hello World! This is a text string response from a Struts 2 Action.".getBytes("UTF-8"));

        personnelTypes = ReservationRepository.getInstance().getPersonnelTypes();
        vehicleTypes = ReservationRepository.getInstance().getVehicleTypes();

        return SUCCESS;
    }

    public String updatePersonals() {
        int selectedPid;
        Map<String, Object> map = ActionContext.getContext().getParameters();
        String[] objs = (String[]) map.get("selectedPid");
        selectedPid = Integer.parseInt(objs[0]);

        personals = ReservationRepository.getInstance().getPersonals(selectedPid);

        Gson gson = new Gson();

        Logger.log(LoggerTypes.INFO, Integer.toString(selectedPid));

        this.personalJson = gson.toJson(personals);
        Logger.log(LoggerTypes.INFO, this.personalJson);
        return SUCCESS;
    }

    public String updateVehicles() {
        int selectedVid;
        Map<String, Object> map = ActionContext.getContext().getParameters();
        String[] objs = (String[]) map.get("selectedVid");
        selectedVid = Integer.parseInt(objs[0]);

        vehicles = ReservationRepository.getInstance().getVehicles(selectedVid);

        Gson gson = new Gson();

        Logger.log(LoggerTypes.INFO, Integer.toString(selectedVid));

        this.vehicleJson = gson.toJson(vehicles);
        Logger.log(LoggerTypes.INFO, this.vehicleJson);
        return SUCCESS;
    }

    private void createTrip() {

    }















    public InputStream getInputStream() {
        return inputStream;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPossibleStops() {
        return possibleStops;
    }

    public void setPossibleStops(String possibleStops) {
        this.possibleStops = possibleStops;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Integer getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Integer noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getVehicleJson() {
        return vehicleJson;
    }

    public void setVehicleJson(String vehicleJson) {
        this.vehicleJson = vehicleJson;
    }

    public List<Personnel> getPersonals() {
        return personals;
    }

    public void setPersonals(List<Personnel> personals) {
        this.personals = personals;
    }

    public String getPersonalJson() {
        return personalJson;
    }

    public void setPersonalJson(String personalJson) {
        this.personalJson = personalJson;
    }
}
