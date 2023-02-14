package actions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.Client;
import data.db_entities.Employee;
import data.db_entities.User;
import domain.ReservationRepository;
import domain.UserRepository;
import org.apache.struts2.json.JSONWriter;
import utils.Logger;
import utils.LoggerTypes;

import java.text.SimpleDateFormat;
import java.util.*;

public class AddReservationDetailsAction extends ActionSupport {

    List<String> offices;
    List<User> owners;

    List<String> clientTypes;
    List<String> creditTypes;
    String date;
    List<Client> clientNames;

    List<Employee> contactNames;
    String approvalStatus, remark, email, phoneNumber, contactName, clientName, creditType;
    String clientType, owner, office;

    String json;

    @Override
    public String execute() throws Exception {
        clientNames = ReservationRepository.getInstance().getClients();
        owners = UserRepository.getInstance().getOwners();
        return SUCCESS;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
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

    public List<String> getClientTypes() {
        if (clientTypes == null) {
            clientTypes = new ArrayList<>();
            clientTypes.add("Individual");
            clientTypes.add("Company");
        }
        return clientTypes;
    }

    public List<String> getCreditTypes() {
        if (creditTypes == null) {
            creditTypes = new ArrayList<>();
            creditTypes.add("Credit Client");
            creditTypes.add("Non Credit Client");
        }
        return creditTypes;
    }

    public String getDate() {
        if (date == null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            date = format.format((new Date()));
        }
        return date;
    }

    public List<Client> getClientNames() {
        return clientNames;
    }

    public List<Employee> getContactNames() {
        return contactNames;
    }

    public void setContactNames(List<Employee> contactNames) {
        this.contactNames = contactNames;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public String updateClient() {
        int selectedCid;
        Map<String, Object> map = ActionContext.getContext().getParameters();
        String[] objs = (String[]) map.get("selectedCid");
        selectedCid = Integer.parseInt(objs[0]);

        contactNames = ReservationRepository.getInstance().getEmployees(selectedCid);

        Gson gson = new Gson();

        Logger.log(LoggerTypes.INFO, Integer.toString(selectedCid));

        this.json = gson.toJson(contactNames);
        Logger.log(LoggerTypes.INFO, this.json);
        return SUCCESS;
    }
}
