package utils;

public enum LoggerTypes {
    WARNING("Log-Warning"), ERROR("Log-Error"), INFO("Log-Info"), DEBUG("Log-Debug");
    String msg;

    LoggerTypes(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
