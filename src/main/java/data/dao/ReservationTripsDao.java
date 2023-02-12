package data.dao;

import data.utils.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationTripsDao implements Dao<Trips> {

    private static ReservationTripsDao instance;
    public synchronized static ReservationTripsDao getInstance() {
        if (instance == null) {
            instance = new ReservationTripsDao();
        }
        return instance;
    }

    @Override
    public List<Trips> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(Trips data) throws Exception {
        return null;
    }

    @Override
    public Integer delete(Trips data) throws Exception {
        return null;
    }

    @Override
    public Integer update(Trips data) throws Exception {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
