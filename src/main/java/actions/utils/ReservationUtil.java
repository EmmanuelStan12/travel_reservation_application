package actions.utils;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import data.db_entities.ReservationResult;
import domain.ReservationRepository;
import utils.Logger;
import utils.LoggerTypes;
import utils.Operator;
import utils.QueryParser;

import java.util.Date;
import java.util.Map;

public class ReservationUtil {

    public static ReservationResult loadResults(Map<String, Object> map) {
        Logger.log(LoggerTypes.INFO, map.toString());
        String query = QueryParser.parse(map);

        Integer pageCount = QueryParser.getPageCount(map);
        Integer page = QueryParser.getPage(map);
        Date date = QueryParser.getDate(map);
        Operator operator = QueryParser.getOperator(map);

        Logger.log(LoggerTypes.INFO, "Date - " + date + " Operator - " + operator);

        Logger.log(LoggerTypes.INFO, "Page - " + page + ", count - " + pageCount);

        if (date != null && operator != null) {
            ReservationResult trips = ReservationRepository.getInstance().getTrips(pageCount, page, query, date, operator);
            Logger.log(LoggerTypes.INFO, trips.toString());
            return trips;
        }

        ReservationResult trips = ReservationRepository.getInstance().getTrips(pageCount, page, query);
        Logger.log(LoggerTypes.INFO, trips.toString());
        return trips;
    }
}
