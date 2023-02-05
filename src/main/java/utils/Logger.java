package utils;

import com.mysql.cj.log.Log;

public class Logger {

    public static void log(LoggerTypes type, String message) {
        System.out.println(type.getMsg() + ": " + message );
    }

    public static void log(LoggerTypes type, Class cls, String message) {
        System.out.println(cls.getSimpleName() + " " + type.getMsg() + ": " + message );
    }
}

