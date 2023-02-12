package data.dao;

import data.db_entities.Detail;
import data.db_entities.Trip;
import data.utils.Dao;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DetailDao implements Dao<Detail> {

    private static DetailDao instance;
    private DetailDao() {
    }

    public synchronized static DetailDao getInstance() {
        if (instance == null) {
            instance = new DetailDao();
        }
        return instance;
    }

    @Override
    public List<Detail> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(Detail data) throws Exception {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Integer status = (Integer) session.save(data);
        transaction.commit();
        session.close();
        return status;
    }

    @Override
    public Integer delete(Detail data) throws Exception {
        return null;
    }

    @Override
    public Integer update(Detail data) throws Exception {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.openSession();
    }

    public Integer insert(Detail detail, List<Trip> trips) {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Integer status = (Integer) session.save(detail);
        for (Trip trip: trips) {
            trip.setDetail(detail);
            session.save(trip);
        }
        transaction.commit();
        session.close();
        return status;
    }
}
