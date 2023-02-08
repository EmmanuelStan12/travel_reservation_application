package domain;

import data.dao.ClientEmployeeDao;
import data.db_entities.Client;
import data.db_entities.Employee;

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
}
