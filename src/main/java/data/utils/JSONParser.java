package data.utils;

public class JSONParser {

    private static JSONParser instance;
    private JSONParser() {}

    public synchronized JSONParser getInstance() {
        if (instance == null) {
            instance = new JSONParser();
        }
        return instance;
    }


}
