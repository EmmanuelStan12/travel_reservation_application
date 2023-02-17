package utils;

import jasper.FileType;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class QueryParser {

    public static String parse(Map<String, Object> queries) {
        Iterator<String> iterator = queries.keySet().iterator();
        StringBuilder queryBuilder = new StringBuilder();
        int i = 0;
        while(iterator.hasNext()) {
            String key = iterator.next();
            String[] entry = (String[]) queries.get(key);
            if (Objects.equals(key, "perPage") || Objects.equals(key, "page")
                    || Objects.equals(key, "operator") || Objects.equals(key, "startDate")
                    || Objects.equals(key, "file_type")
            ) {
                continue;
            }
            queryBuilder.append(key).append(" = '").append(entry[0]).append("'");
            if (iterator.hasNext()) {
                queryBuilder.append(" and ");
            }
        }
        Logger.log(LoggerTypes.INFO, queryBuilder.toString());
        return queryBuilder.toString();
    }

    public static Integer getPageCount(Map<String, Object> queries) {
        String[] entry = (String[]) queries.get("perPage");
        return Integer.parseInt(entry[0]);
    }

    public static Integer getPage(Map<String, Object> queries) {
        String[] entry = (String[]) queries.get("page");
        return Integer.parseInt(entry[0]);
    }

    public static Operator getOperator(Map<String, Object> queries) {
        String[] entry = (String[]) queries.get("operator");
        //Logger.log(LoggerTypes.INFO, "operator " + entry[0]);
        if (entry == null) return null;
        return Operator.getOperator(entry[0]);
    }

    public static FileType getFileType(Map<String, Object> queries) {
        String[] entry = (String[]) queries.get("file_type");
        //Logger.log(LoggerTypes.INFO, "operator " + entry[0]);
        if (entry == null) throw new NullPointerException("File type is empty");
        return FileType.findType(entry[0]);
    }

    public static Date getDate(Map<String, Object> queries) {
        String[] entry = (String[]) queries.get("startDate");
        if (entry == null) {
            return null;
        }
        String date = entry[0].split(" ")[0] + ".000Z";

        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            LocalDate localDateTime = LocalDate.parse(date, formatter);
            Logger.log(LoggerTypes.INFO, "date - " + Date.valueOf(localDateTime));
            return Date.valueOf(localDateTime);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String buildHQLQuery(String query, Operator operator) {
        String clause = " %s %s";
        clause = String.format(clause, query, "and");
        if (query.isBlank()) {
            clause = "";
        }
        return "from Trip t where" + clause + " t.createdAt " + operator.getSymbol() + " :date";
    }
}
