package data.dao;

import data.db_entities.Client;
import data.db_entities.Employee;
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

public class ClientEmployeeDao {

    private ClientEmployeeDao() {

    }

    private static ClientEmployeeDao instance;

    public static ClientEmployeeDao getInstance() {
        synchronized ((new Object())) {
            if (instance == null) {
                instance = new ClientEmployeeDao();
            }
            return instance;
        }
    }

    public void getByCriteria(String criteria) {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Employee e inner join Client c on e.clientID = c.cid " + criteria);

        List<Object[]> objects = query.list();
        for (Object[] obj : objects) {
            Logger.log(LoggerTypes.INFO, "[ " + obj[0].toString() + " " + obj[1] + " ]");
        }
        //Logger.log(LoggerTypes.INFO, user.toString());
        transaction.commit();
        session.close();
    }

    public Integer insert(Object data) {
            Session session = createSession(DatabaseUtil.getFactory(this.getClass()));

            Transaction transaction = session.beginTransaction();
            Integer status = (Integer) session.save(data);
            transaction.commit();
            session.close();
            return status;
    }

    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
