package data.db_entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Detail {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "detail_id")
    private Integer id;

    @OneToMany(mappedBy = "detail", fetch = FetchType.EAGER)
    private List<Trip> trips;

    @ManyToOne
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String owner;
    private String office;
    private String clientType;
    private String creditType;
    private String date;
    private String name;
    private String contactName;
    private String email;
    private String phoneNumber;
    private String remark;
    private String status;
    private Boolean isApproved;

    public Detail() {
    }

    public Detail(Integer id, List<Trip> trips, String owner, String office, String clientType, String creditType, String date, String name, String contactName, String email, String phoneNumber, String remark, String status, Boolean isApproved) {
        this.id = id;
        this.trips = trips;
        this.owner = owner;
        this.office = office;
        this.clientType = clientType;
        this.creditType = creditType;
        this.date = date;
        this.name = name;
        this.contactName = contactName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.remark = remark;
        this.status = status;
        this.isApproved = isApproved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", trip=" + trips +
                ", owner='" + owner + '\'' +
                ", office='" + office + '\'' +
                ", clientType='" + clientType + '\'' +
                ", creditType='" + creditType + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", contactName='" + contactName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
