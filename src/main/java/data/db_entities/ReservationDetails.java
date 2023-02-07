package data.db_entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservationDetails {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
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
    private String approvalStatus;
}
