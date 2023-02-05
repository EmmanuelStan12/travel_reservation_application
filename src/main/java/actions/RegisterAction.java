package actions;

import com.opensymphony.xwork2.ActionSupport;
import data.db_entities.User;
import domain.UserRepository;
import utils.Logger;
import utils.LoggerTypes;
import utils.ValidationUtil;

import static utils.ValidationUtil.*;

public class RegisterAction extends ActionSupport {

    String email, password, firstname, lastname;
    @Override
    public String execute() throws Exception {
        return register();
    }

    @Override
    public void validate() {
        ValidationUtil.validateEmail(email, this);
        ValidationUtil.validatePassword(password, this);
        ValidationUtil.validNonEmptyString(FIRSTNAME, firstname, this);
        ValidationUtil.validNonEmptyString(LASTNAME, lastname, this);
    }

    private String register() {
        User user = new User(null, password, firstname, lastname, email);
        try {
            int result = UserRepository.getInstance().register(user);
            Logger.log(LoggerTypes.INFO, "Result - " + result);
            setEmail("");
            setPassword("");
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(LoggerTypes.ERROR, e.toString());
            addActionError(e.getCause().getCause().getMessage());
            return INPUT;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
