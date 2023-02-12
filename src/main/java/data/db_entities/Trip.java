package data.db_entities;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="detail_id", nullable=false)
    private Detail detail;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String passengerName;

    private Integer noOfPassengers;

    private String email;

    private String phoneNumber;

    private String departure;

    private String destination;

    private String possibleStops;

    private String vehicleCategory;

    private String vehicleType;

    private String serviceType;

    private Integer noOfDays;

    private Integer pricePerDay;

    private String additionalInformation;

    private String personnelType;

    private String personnel;

    private String vehicle;

    private Boolean isResourceAvailable;

    private Integer totalAmount;

    public Trip() {
    }

    public Trip(Integer id, Detail detail, Date createdAt, Date updatedAt, String passengerName, Integer noOfPassengers, String email, String phoneNumber, String departure, String destination, String possibleStops, String vehicleCategory, String vehicleType, String serviceType, Integer noOfDays, Integer pricePerDay, String additionalInformation, String personnelType, String personnel, String vehicle, Boolean isResourceAvailable, Integer totalAmount) {
        this.id = id;
        this.detail = detail;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.passengerName = passengerName;
        this.noOfPassengers = noOfPassengers;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.departure = departure;
        this.destination = destination;
        this.possibleStops = possibleStops;
        this.vehicleCategory = vehicleCategory;
        this.vehicleType = vehicleType;
        this.serviceType = serviceType;
        this.noOfDays = noOfDays;
        this.pricePerDay = pricePerDay;
        this.additionalInformation = additionalInformation;
        this.personnelType = personnelType;
        this.personnel = personnel;
        this.vehicle = vehicle;
        this.isResourceAvailable = isResourceAvailable;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Integer noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPossibleStops() {
        return possibleStops;
    }

    public void setPossibleStops(String possibleStops) {
        this.possibleStops = possibleStops;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getResourceAvailable() {
        return isResourceAvailable;
    }

    public void setResourceAvailable(Boolean resourceAvailable) {
        isResourceAvailable = resourceAvailable;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
