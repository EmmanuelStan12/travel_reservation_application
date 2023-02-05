package data.dao;

import data.db_entities.User;
import data.utils.Dao;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao implements Dao<User> {

    @Override
    public List<User> get() {
        return null;
    }

    @Override
    public Integer insert(User data) {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));

        Transaction transaction = session.beginTransaction();
        Integer status = (Integer) session.save(data);
        transaction.commit();
        return status;
    }

    @Override
    public Integer delete(User data) {
        return null;
    }

    @Override
    public Integer update(User data) {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
