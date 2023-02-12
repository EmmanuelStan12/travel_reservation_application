package data.dao;

import data.db_entities.Client;
import data.db_entities.Employee;
import data.utils.DatabaseUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Logger;
import utils.LoggerTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientEmployeeDao {

    private static ClientEmployeeDao instance;

    private ClientEmployeeDao() {}
    public synchronized static ClientEmployeeDao getInstance() {
        if (instance == null) {
            instance = new ClientEmployeeDao();
        }
        return instance;
    }


    public List<Client> getClients() {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        transaction.commit();
        session.close();
        return clients;
    }

    public List<Employee> getEmployeesForClient(Integer cid) {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Employee e inner join Client c on e.clientID = c.cid where c.id = " + cid);
        List<Object[]> objs = query.list();
        List<Employee> employees = new ArrayList<>();
        for (Object[] obj : objs) {
            Logger.log(LoggerTypes.INFO, "Objs - " + Arrays.toString(obj));
            Employee employee = (Employee) obj[0];
            employees.add(employee);
        }

        Logger.log(LoggerTypes.INFO, Arrays.toString(employees.toArray()));

        transaction.commit();
        session.close();
        return employees;
    }

    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
