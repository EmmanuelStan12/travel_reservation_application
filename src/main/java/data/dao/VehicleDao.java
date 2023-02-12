package data.dao;

import data.db_entities.Personnel;
import data.db_entities.PersonnelType;
import data.db_entities.Vehicle;
import data.db_entities.VehicleType;
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

public class VehicleDao {

    private static VehicleDao instance;

    private VehicleDao() {}
    public synchronized static VehicleDao getInstance() {
        if (instance == null) {
            instance = new VehicleDao();
        }
        return instance;
    }


    public List<VehicleType> getVehicleTypes() {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from VehicleType ");
        List<VehicleType> types = query.list();
        transaction.commit();
        session.close();
        return types;
    }

    public List<Vehicle> getVehicles(Integer vid) {
        Session session = createSession(DatabaseUtil.getFactory(this.getClass()));

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Vehicle v inner join VehicleType v2 on v.vehicleTypeID = v2.id where v.vehicleTypeID = " + vid);
        List<Object[]> objs = query.list();
        List<Vehicle> vehicles = new ArrayList<>();
        for (Object[] obj : objs) {
            Logger.log(LoggerTypes.INFO, "Objs - " + Arrays.toString(obj));
            Vehicle v = (Vehicle) obj[0];
            vehicles.add(v);
        }

        Logger.log(LoggerTypes.INFO, Arrays.toString(vehicles.toArray()));

        transaction.commit();
        session.close();
        return vehicles;
    }

    public Session createSession(SessionFactory factory) {
        return factory.getCurrentSession();
    }
}
