package data.db_entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Column(name = "cname")
    private String clientName;

    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;

    @OneToMany(mappedBy = "client")
    private List<Employee> employees = new ArrayList<>();

    public Client(String clientName, Integer cid) {
        this.clientName = clientName;
        this.cid = cid;
    }

    public Client() {}

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "[ " + clientName + ", " + cid + " ]";
    }
}
