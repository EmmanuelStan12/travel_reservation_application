package data.dao;

import data.db_entities.ReservationResult;
import data.db_entities.Trip;
import data.utils.Dao;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Logger;
import utils.LoggerTypes;
import utils.Operator;
import utils.QueryParser;

import javax.persistence.TemporalType;
import java.util.Date;
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
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Trip");
        List<Trip> trips = query.list();
        tx.commit();
        session.close();
        return trips;
    }

    public ReservationResult get(
            Integer perPage,
            Integer page,
            String query
    ) {
        Session session = createSession(DatabaseUtil.getFactory());
        String clause = query.isBlank() ? "" : " where ";

        Transaction tx = session.beginTransaction();


        Query tripQuery = session.createQuery("from Trip t" + clause + query);

        tripQuery.setMaxResults(perPage);
        tripQuery.setFirstResult((page * perPage));
        List<Trip> trips = tripQuery.list();

        ReservationResult result = new ReservationResult();
        result.setTrips(trips);

        Query tripCountQuery = session.createQuery("select count(*) from Trip t" + clause + query);
        Long tripCount = (Long) tripCountQuery.uniqueResult();

        return getReservationResult(perPage, page, session, tx, tripCount, result);
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

    public ReservationResult get(Integer perPage, Integer page, String query, Date date, Operator operator) {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction tx = session.beginTransaction();

        Query tripCountQuery = session.createQuery("select count(*) " + QueryParser.buildHQLQuery(query, operator));
        Query tripQuery = session.createQuery(QueryParser.buildHQLQuery(query, operator));
        tripQuery.setParameter("date", date, TemporalType.DATE);
        tripCountQuery.setParameter("date", date, TemporalType.DATE);

        tripQuery.setMaxResults(perPage);
        tripQuery.setFirstResult((page * perPage));
        List<Trip> trips = tripQuery.list();

        ReservationResult result = new ReservationResult();
        result.setTrips(trips);

        Long tripCount = (Long) tripCountQuery.uniqueResult();

        return getReservationResult(perPage, page, session, tx, tripCount, result);
    }

    private ReservationResult getReservationResult(Integer perPage, Integer page, Session session, Transaction tx, Long tripCount, ReservationResult result) {
        Long pages = tripCount / perPage == 0 ? 1 : ( tripCount % perPage != 0 ? (tripCount / perPage) + 1 : tripCount / perPage );
        result.setPages(pages);
        result.setStart((page * perPage) + 1);

        result.setCount(tripCount);
        result.setPageSize(perPage);
        if (page + 1 == result.getPages()) {
            result.setNextPage(null);
        } else {
            result.setNextPage(page + 1 + 1);
        }

        Long end;
        if (page == 0) {
            end = tripCount / perPage == 0 ? (tripCount % perPage) : perPage;
        } else {
            end = tripCount / perPage == 0 ? (tripCount % perPage) : perPage * (page + 1);
            if (end > tripCount) end = tripCount;
        }
        result.setEnd(end);

        tx.commit();
        session.close();
        return result;
    }
}
