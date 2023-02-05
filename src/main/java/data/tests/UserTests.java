package data.tests;

import data.dao.UserDao;
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
    }
}
