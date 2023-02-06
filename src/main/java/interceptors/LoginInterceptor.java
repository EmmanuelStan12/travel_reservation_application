package interceptors;

import actions.LoginAction;
import actions.RegisterAction;
import com.mysql.cj.log.Log;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.interceptor.SessionAware;
import utils.Logger;
import utils.LoggerTypes;

import java.util.Map;

public class LoginInterceptor implements Interceptor {

    private Map<String, Object> userSession;
    @Override
    public void init() {
        Logger.log(LoggerTypes.INFO, this.getClass(), "Init() called");
    }

    @Override
    public void destroy() {
        Logger.log(LoggerTypes.INFO, this.getClass(), "destroy() called");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        userSession = ActionContext.getContext().getSession();
        Logger.log(LoggerTypes.INFO, this.getClass(), userSession.toString());
        Integer userID = (Integer) userSession.get("USER_ID");
        if (userID == null) {
            if (actionInvocation.getAction().getClass().equals(LoginAction.class) ||
            actionInvocation.getAction().getClass().equals(RegisterAction.class)) {
                return actionInvocation.invoke();
            }
            return "input";
        }
        return actionInvocation.invoke();
    }
}
