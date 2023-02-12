package data.tests;

import data.dao.ClientEmployeeDao;
import data.dao.PersonnelDao;
import data.dao.VehicleDao;
import data.db_entities.*;
import utils.Logger;
import utils.LoggerTypes;

import java.lang.reflect.Array;
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



    }
}
