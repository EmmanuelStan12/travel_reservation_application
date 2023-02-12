package actions;

import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Personnel;
import data.db_entities.PersonnelType;
import data.db_entities.User;
import data.db_entities.VehicleType;
import domain.ReservationRepository;
import domain.UserRepository;
import utils.Operator;

import java.util.ArrayList;
import java.util.List;

public class HomeAction extends ActionSupport {

    private List<String> offices;

    private List<User> owners;
    private List<Operator> operators;

    private List<VehicleType> vehicleTypes;

    private List<PersonnelType> personnelTypes;

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
