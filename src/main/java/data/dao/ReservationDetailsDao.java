package data.dao;

import data.db_entities.ReservationDetails;
import data.utils.Dao;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReservationDetailsDao implements Dao<ReservationDetails> {

    private static ReservationDetailsDao instance;

    public static ReservationDetailsDao getInstance() {
        if (instance == null) {
            instance = new ReservationDetailsDao();
        }
        return instance;
    }

    @Override
    public List<ReservationDetails> get() throws Exception {
        return null;
    }

    @Override
    public Integer insert(ReservationDetails data) throws Exception {
        return null;
    }

    @Override
    public Integer delete(ReservationDetails data) throws Exception {
        return null;
    }

    @Override
    public Integer update(ReservationDetails data) throws Exception {
        return null;
    }

    @Override
    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
