package domain;

import data.dao.UserDao;
import data.db_entities.User;
import utils.Logger;
import utils.LoggerTypes;

import java.util.List;
import java.util.Objects;

public class UserRepository {

    private static UserRepository repository;

    private UserRepository() {}

    public static UserRepository getInstance() {
        synchronized ((new Object())) {
            if (repository == null) {
                repository = new UserRepository();
            }
            return repository;
        }
    }

    public Integer register(User data) {
        Logger.log(LoggerTypes.INFO, data.toString());
        return UserDao.getInstance().insert(data);
    }

    public Integer login(String email, String password) throws Exception {
        Logger.log(LoggerTypes.INFO, email + " " + password);
        User user = UserDao.getInstance().getByCriteria("email = '" + email + "'");
        if (user == null) {
            throw new Exception("User does not exist");
        }
        if (!Objects.equals(user.getPassword(), password)) {
            throw new Exception("Email or Password Incorrect");
        }
        return user.getUid();
    }

    public List<User> getOwners() throws Exception {
        List<User> users = UserDao.getInstance().get();
        for (User user: users) {
            user.setPassword(null);
        }
        return users;
    }

    public User getByID(Integer id) throws Exception {
        return UserDao.getInstance().get(id);
    }
}
