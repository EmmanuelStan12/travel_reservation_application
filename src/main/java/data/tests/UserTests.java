package data.tests;

import data.dao.ClientEmployeeDao;
import data.db_entities.Client;
import data.db_entities.User;
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

        //(new UserDao()).insert(user);

        List<Client> clients = ClientEmployeeDao.getInstance().getClients();
        Logger.log(LoggerTypes.INFO, Arrays.toString(clients.toArray()));

        Client client = clients.get(0);
        Logger.log(LoggerTypes.INFO, client.toString());


        Logger.log(LoggerTypes.INFO, Arrays.toString(clients.toArray()));

    }
}
