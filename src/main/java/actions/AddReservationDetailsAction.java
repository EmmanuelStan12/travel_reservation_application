package actions;

import com.opensymphony.xwork2.ActionSupport;
import utils.Logger;
import utils.LoggerTypes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddReservationDetailsAction extends ActionSupport {

    List<String> offices;
    List<String> owners;

    List<String> clientTypes;
    List<String> creditTypes;
    String date;
    List<String> clientNames;
    String approvalStatus, remark, email, phoneNumber, contactName, clientName, creditType;
    String clientType, owner, office;

    @Override
    public String execute() throws Exception {
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

    public List<String> getOwners() {
        if (owners == null) {
            owners = new ArrayList<>();
            owners.add("Admin Administrator");
            owners.add("Femi Jacob");
            owners.add("Front Desk");
            owners.add("Kayode Emmanuel");
            owners.add("Kazeem Balogun");
        }
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

    public List<String> getClientNames() {
        if (clientNames == null) {
            clientNames = new ArrayList<>();
            clientNames.add("Stanbic IBTC");
            clientNames.add("Tunji");
            clientNames.add("Union Bank");
            clientNames.add("Wema Bank");
            clientNames.add("Airtel Nigeria");
        }
        return clientNames;
    }

    public void fetchCreditClientContactNames() {
        Logger.log(LoggerTypes.INFO, "Nice");
    }
}
