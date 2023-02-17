package data.db_entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

public class Report {

        private Integer id;

        private Date createdAt;

        private String date;

        private String clientType;

        private String route;

        private String status;

        private Integer totalAmount;

        private String office;

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", date='" + date + '\'' +
                ", clientType='" + clientType + '\'' +
                ", route='" + route + '\'' +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", office='" + office + '\'' +
                '}';
    }
}
