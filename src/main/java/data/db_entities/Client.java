package data.db_entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer cid;

    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Client [ " +
                "cid - " + cid +
                ", cname - " + cname +
                " ]";
    }
}
