package actions;

import com.opensymphony.xwork2.ActionSupport;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.Patterns;

import java.util.regex.Pattern;

public class LoginAction extends ActionSupport {

    String email;
    String password;

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

    @Override
    public String execute() throws Exception {
        System.out.println("LoginAction: email - " + email + " password - " + password);
        return SUCCESS;
    }

    @Override
    public void validate() {

    }
}
