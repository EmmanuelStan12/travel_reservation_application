package data.dao;

import data.db_entities.Detail;
import data.utils.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationDetailsDao implements Dao<Detail> {

    private static ReservationDetailsDao instance;

    public static ReservationDetailsDao getInstance() {
        if (instance == null) {
            instance = new ReservationDetailsDao();
        }
        return instance;
    }

    @Override
    public List<Detail> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(Detail data) throws Exception {
        return null;
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
        return factory.getCurrentSession();
    }
}
