package data.dao;

import data.db_entities.ReservationTrip;
import data.utils.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationTripsDao implements Dao<ReservationTrip> {

    private static ReservationTripsDao instance;
    public synchronized static ReservationTripsDao getInstance() {
        if (instance == null) {
            instance = new ReservationTripsDao();
        }
        return instance;
    }

    @Override
    public List<ReservationTrip> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(ReservationTrip data) throws Exception {
        return null;
    }

    @Override
    public Integer delete(ReservationTrip data) throws Exception {
        return null;
    }

    @Override
    public Integer update(ReservationTrip data) throws Exception {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
