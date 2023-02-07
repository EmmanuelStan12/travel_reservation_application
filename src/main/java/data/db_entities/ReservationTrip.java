package data.db_entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservationTrip {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String passengerName;

    private Integer numberOfPassengers;

    private String phoneNumber;
    private String email;
    private String departure;
    private String vehicleCategory;
    private String vehicleType;
    private String serviceType;
    private Integer noOfDays;
    private String pricePerDay;
    private String additionalInformation;
    private String personnelType;
    private String personnelName;
    private String vehicleName;

    private Boolean isResourceAvailable;
    private String totalAmount;
}
