package data.db_entities;

import javax.persistence.*;

@Entity
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;

    private String name;

    @Column(name = "personnel_type_id")
    private Integer personnelTypeID;

    public Personnel(Integer pid, String name, Integer personnelTypeID) {
        this.pid = pid;
        this.name = name;
        this.personnelTypeID = personnelTypeID;
    }

    public Personnel() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPersonnelTypeID() {
        return personnelTypeID;
    }

    public void setPersonnelTypeID(Integer personnelTypeID) {
        this.personnelTypeID = personnelTypeID;
    }
}
