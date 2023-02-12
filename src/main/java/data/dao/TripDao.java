package data.dao;

import data.db_entities.Trip;
import data.utils.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TripDao implements Dao<Trip> {


    private static TripDao instance;
    private TripDao() {
    }

    public synchronized static TripDao getInstance() {
        if (instance == null) {
            instance = new TripDao();
        }
        return instance;
    }

    @Override
    public List<Trip> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(Trip data) throws Exception {
        return null;
    }

    @Override
    public Integer delete(Trip data) throws Exception {
        return null;
    }

    @Override
    public Integer update(Trip data) throws Exception {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
