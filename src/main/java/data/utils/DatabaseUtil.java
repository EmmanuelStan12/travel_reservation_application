package data.utils;

import data.db_entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import utils.Logger;
import utils.LoggerTypes;


public class DatabaseUtil {

    private static SessionFactory factory;

    //Session Factory is expensive to create and should have at least one Instance
    public synchronized static SessionFactory getFactory() {
        if (factory != null) {
            return factory;
        } else {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(Client.class);
            config.addAnnotatedClass(Employee.class);
            config.addAnnotatedClass(Detail.class);
            config.addAnnotatedClass(Trip.class);
            config.addAnnotatedClass(Personnel.class);
            config.addAnnotatedClass(PersonnelType.class);
            config.addAnnotatedClass(Vehicle.class);
            config.addAnnotatedClass(VehicleType.class);
            Logger.log(LoggerTypes.INFO, "Hibernate Configured Successfully");

            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            Logger.log(LoggerTypes.INFO, "Service Registry Created");

            factory = config.buildSessionFactory(registry);
        }
        return factory;
    }
}
