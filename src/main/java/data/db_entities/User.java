package data.db_entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class User {
    @Id
    private Integer uid;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    public User(Integer uid, String password, String firstname, String lastname, String email) {
        this.uid = uid;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [ id - " + uid + " firstname - " + firstname +
                " lastname - " + lastname + " Email - " + email + " ]";
    }
}
