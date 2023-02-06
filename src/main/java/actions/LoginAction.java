package actions;

import com.opensymphony.xwork2.ActionSupport;
import domain.UserRepository;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.core.util.Patterns;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.regex.Pattern;

public class LoginAction extends ActionSupport implements SessionAware {

    Map<String, Object> userSession;

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
        return login();
    }

    @Override
    public void validate() {

    }

    private String login() {
        try {
            int id = UserRepository.getInstance().login(email, password);
            userSession.put("USER_ID", id);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return INPUT;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.userSession = map;
    }
}
