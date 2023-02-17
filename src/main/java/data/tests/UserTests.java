package data.tests;

import data.dao.ClientEmployeeDao;
import data.dao.PersonnelDao;
import data.dao.TripDao;
import data.dao.VehicleDao;
import data.db_entities.*;
import jasper.FileType;
import jasper.ReportService;
import net.sf.jasperreports.engine.JRException;
import utils.Logger;
import utils.LoggerTypes;

import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserTests {
    public static void main(String[] args) {
        User user = new User(
                1,
                "password",
                "Emmanuel",
                "Stanley",
                "emma@gmail.com"
        );

        List<String> types = new ArrayList<>();
//        types.add("Driver");
//        types.add("Electrician");
//        types.add("Mechanic");
//        types.add("Painter");
//        types.add("Panel Beater");
//        types.add("Screen Painter");
//        types.add("Vulcanizer");
//        types.add("Welder");

//        types.add("Pool");
//        types.add("Status");
//        types.add("Third Party");
        Random random = new Random();

//        List<PersonnelType> personnelTypes = PersonnelDao.getInstance().getPersonnelTypes();
//
//        for (PersonnelType type : personnelTypes) {
//            for (int i = 0; i < 10; i++) {
//                Personnel p = new Personnel(null, type.getName()+"_"+i, type.getId());
//                PersonnelDao.getInstance().insert(p);
//            }
//        }
//
//        List<VehicleType> vehicleTypes = VehicleDao.getInstance().getVehicleTypes();
//
//        for (VehicleType type : vehicleTypes) {
//            for (int i = 0; i < 10; i++) {
//                Vehicle v = new Vehicle(null, type.getName()+"_"+i, type.getId());
//                PersonnelDao.getInstance().insert(v);
//            }
//        }

        //(new UserDao()).insert(user);

//        List<Client> clients = ClientEmployeeDao.getInstance().getClients();
//        Logger.log(LoggerTypes.INFO, Arrays.toString(clients.toArray()));
//
//        Client client = clients.get(0);
//        Logger.log(LoggerTypes.INFO, client.toString());
//
//
//        Logger.log(LoggerTypes.INFO, Arrays.toString(clients.toArray()));

//        var result = TripDao.getInstance().get(10, 0, "");
//        Logger.log(LoggerTypes.INFO, result.toString());
//        var result1 = TripDao.getInstance().get(10, result.getNextPage() - 1, "");
//        Logger.log(LoggerTypes.INFO, result1.toString());
//        var result2 = TripDao.getInstance().get(10, result1.getNextPage() - 1, "");
//        Logger.log(LoggerTypes.INFO, result2.toString());

        ReservationResult results = TripDao.getInstance().get(
                10, 1, ""
        );
        List<Report> reports = ReportService.resultToReport(results);
        Logger.log(LoggerTypes.INFO, reports.toString());
        try {
            ReportService.exportReport("reservation_1", reports, FileType.EXCEL);
        } catch (JRException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
