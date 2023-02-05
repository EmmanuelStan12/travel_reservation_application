package domain;

import data.dao.UserDao;
import data.db_entities.User;
import utils.Logger;
import utils.LoggerTypes;

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
}
