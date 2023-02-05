package actions;

import com.opensymphony.xwork2.ActionSupport;

public class AddReservationAction extends ActionSupport {

    String tab = "details";

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
}
