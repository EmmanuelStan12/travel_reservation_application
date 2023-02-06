package data.dao;

import data.db_entities.User;
import data.utils.Dao;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Logger;
import utils.LoggerTypes;

import java.util.List;

public class UserDao implements Dao<User> {

    private UserDao() {

    }

    private static UserDao instance;

    public static UserDao getInstance() {
        synchronized ((new Object())) {
            if (instance == null) {
                instance = new UserDao();
            }
            return instance;
        }
    }

    @Override
    public List<User> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(User data) {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));

        Transaction transaction = session.beginTransaction();
        Integer status = (Integer) session.save(data);
        transaction.commit();
        session.close();
        return status;
    }

    @Override
    public Integer delete(User data) throws Exception {
        return null;
    }

    @Override
    public Integer update(User data) throws Exception {
        return null;
    }

    public User getByCriteria(String criteria) {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from user where " + criteria);

        User user = (User) query.uniqueResult();
        //Logger.log(LoggerTypes.INFO, user.toString());
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
