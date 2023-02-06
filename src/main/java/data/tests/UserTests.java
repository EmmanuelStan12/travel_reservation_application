package data.tests;

import data.dao.ClientEmployeeDao;
import data.dao.UserDao;
import data.db_entities.Client;
import data.db_entities.Employee;
import data.db_entities.User;

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

        Client client = new Client();
        client.setClientName("MTN");
        ClientEmployeeDao.getInstance().insert(client);
        for (int i = 0; i < 10; i++) {
            Employee e = new Employee(null, "Employee_"+i, client.getCid(), i+"400");
            ClientEmployeeDao.getInstance().insert(e);
        }
        ClientEmployeeDao.getInstance().getByCriteria("");
    }
}
