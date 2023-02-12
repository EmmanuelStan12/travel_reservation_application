package data.db_entities;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vid;

    private String name;

    @Column(name = "vehicle_type_id")
    private Integer vehicleTypeID;

    public Vehicle() {
    }

    public Vehicle(Integer vid, String name, Integer vehicleTypeID) {
        this.vid = vid;
        this.name = name;
        this.vehicleTypeID = vehicleTypeID;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(Integer vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }
}
