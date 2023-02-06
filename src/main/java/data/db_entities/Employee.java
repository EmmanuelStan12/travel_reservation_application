package data.db_entities;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @Column(name = "eid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eid;

    @Column(name = "name")
    private String employeeName;

    private Integer clientID;

    @Column(name = "salary")
    private String salary;

    @ManyToOne
    private Client client;

    public Employee() {}

    public Employee(Integer eid, String employeeName, Integer clientID, String salary) {
        this.eid = eid;
        this.employeeName = employeeName;
        this.clientID = clientID;
        this.salary = salary;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[ " + eid + ", " + employeeName + ", " + salary + " ]";
    }
}
