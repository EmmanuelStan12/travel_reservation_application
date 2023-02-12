package data.db_entities;


public class Trip {

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

    public Trip(
            String passengerName,
            Integer noOfPassengers,
            String passengerEmail,
            String passengerPhoneNumber,
            String departure, String destination,
            String possibleStops,
            String vehicleCategory,
            String vehicleType,
            String serviceType,
            Integer noOfDays,
            Integer pricePerDay,
            String additionalInformation,
            String personnelType,
            String personnel,
            String vehicle,
            Boolean isResourceAvailable
    ) {
        this.passengerName = passengerName;
        this.noOfPassengers = noOfPassengers;
        this.email = passengerEmail;
        this.phoneNumber = passengerPhoneNumber;
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

    public String getPassengerEmail() {
        return email;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.email = passengerEmail;
    }

    public String getPassengerPhoneNumber() {
        return phoneNumber;
    }

    public void setPassengerPhoneNumber(String passengerPhoneNumber) {
        this.phoneNumber = passengerPhoneNumber;
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
        totalAmount = noOfDays * pricePerDay;
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "passengerName='" + passengerName + '\'' +
                ", noOfPassengers=" + noOfPassengers +
                ", passengerEmail='" + email + '\'' +
                ", passengerPhoneNumber='" + phoneNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", possibleStops='" + possibleStops + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", noOfDays=" + noOfDays +
                ", pricePerDay=" + pricePerDay +
                ", additionalInformation=" + additionalInformation +
                ", personnelType='" + personnelType + '\'' +
                ", personnel='" + personnel + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", isResourceAvailable=" + isResourceAvailable +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
