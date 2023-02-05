package actions;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class HomeAction extends ActionSupport {

    String tab = "details";
    List<String> paymentStatus;
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }


    public List<String> getPaymentStatus() {
        return paymentStatus;
    }
}
