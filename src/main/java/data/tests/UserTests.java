package data.tests;

import data.db_entities.User;

import java.util.ArrayList;
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

    }
}
