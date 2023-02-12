package domain;

import data.dao.ClientEmployeeDao;
import data.dao.PersonnelDao;
import data.dao.VehicleDao;
import data.db_entities.*;

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
}
