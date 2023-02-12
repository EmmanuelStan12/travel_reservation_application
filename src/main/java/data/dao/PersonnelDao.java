package data.dao;

import data.db_entities.Client;
import data.db_entities.Employee;
import data.db_entities.Personnel;
import data.db_entities.PersonnelType;
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

public class PersonnelDao {

    private static PersonnelDao instance;

    private PersonnelDao() {}
    public synchronized static PersonnelDao getInstance() {
        if (instance == null) {
            instance = new PersonnelDao();
        }
        return instance;
    }


    public List<PersonnelType> getPersonnelTypes() {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from PersonnelType ");
        List<PersonnelType> personnelTypes = query.list();
        transaction.commit();
        session.close();
        return personnelTypes;
    }

    public List<Personnel> getPersonals(Integer pid) {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Personnel p inner join PersonnelType p2 on p.personnelTypeID = p2.id where p.personnelTypeID = " + pid);
        List<Object[]> objs = query.list();
        List<Personnel> personals = new ArrayList<>();
        for (Object[] obj : objs) {
            Logger.log(LoggerTypes.INFO, "Objs - " + Arrays.toString(obj));
            Personnel personnel = (Personnel) obj[0];
            personals.add(personnel);
        }

        Logger.log(LoggerTypes.INFO, Arrays.toString(personals.toArray()));

        transaction.commit();
        session.close();
        return personals;
    }

    public <T> Integer insert(T data) {
        Session session = createSession(DatabaseUtil.getFactory());

        Transaction transaction = session.beginTransaction();
        Integer status = (Integer) session.save(data);
        transaction.commit();
        session.close();
        return status;
    }

    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
