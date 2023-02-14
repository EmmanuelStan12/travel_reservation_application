package domain;

import data.dao.*;
import data.db_entities.*;
import utils.Operator;

import java.util.Date;
import java.util.List;

public class ReservationRepository {

    private static ReservationRepository instance;

    private ReservationRepository() {}

    public synchronized static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }
        return instance;
    }

    public List<Client> getClients() {
        return ClientEmployeeDao.getInstance().getClients();
    }

    public List<Employee> getEmployees(Integer cid) {
        return ClientEmployeeDao.getInstance().getEmployeesForClient(cid);
    }

    public List<VehicleType> getVehicleTypes() {
        return VehicleDao.getInstance().getVehicleTypes();
    }

    public List<Vehicle> getVehicles(Integer vid) {
        return VehicleDao.getInstance().getVehicles(vid);
    }

    public List<PersonnelType> getPersonnelTypes() {
        return PersonnelDao.getInstance().getPersonnelTypes();
    }

    public List<Personnel> getPersonals(Integer pid) {
        return PersonnelDao.getInstance().getPersonals(pid);
    }

    public Integer insertReservation(Detail detail, List<Trip> trips) {
        detail.setTrips(trips);
        return DetailDao.getInstance().insert(detail, trips);
    }

    public ReservationResult getTrips(Integer perPage, Integer page) {
        ReservationResult result = TripDao.getInstance().get(perPage, page, "");
        for (Trip trip: result.getTrips()) {
            trip.getDetail().setTrips(null);
            trip.getDetail().getUser().setDetails(null);
            trip.getDetail().getUser().setPassword(null);
        }
        return result;
    }

    public ReservationResult getTrips(Integer perPage, Integer page, String query) {
        ReservationResult result = TripDao.getInstance().get(perPage, page - 1, query);
        for (Trip trip: result.getTrips()) {
            trip.getDetail().setTrips(null);
            trip.getDetail().getUser().setDetails(null);
            trip.getDetail().getUser().setPassword(null);
        }
        return result;
    }

    public ReservationResult getTrips(Integer perPage, Integer page, String query, Date date, Operator operator) {
        ReservationResult result = TripDao.getInstance().get(perPage, page + 1, query,date, operator);
        for (Trip trip: result.getTrips()) {
            trip.getDetail().setTrips(null);
            trip.getDetail().getUser().setDetails(null);
            trip.getDetail().getUser().setPassword(null);
        }
        return result;
    }
}
