package model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AgentId", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "AgtFirstName", length = 20)
    private String agtFirstName;

    @Size(max = 5)
    @Column(name = "AgtMiddleInitial", length = 5)
    private String agtMiddleInitial;

    @Size(max = 20)
    @Column(name = "AgtLastName", length = 20)
    private String agtLastName;

    @Size(max = 20)
    @Column(name = "AgtBusPhone", length = 20)
    private String agtBusPhone;

    @Size(max = 50)
    @Column(name = "AgtEmail", length = 50)
    private String agtEmail;

    @Size(max = 20)
    @Column(name = "AgtPosition", length = 20)
    private String agtPosition;

    @Size(max = 16)
    @Column(name = "AgtUserId", length = 16)
    private String agtUserId;

    @Size(max = 16)
    @Column(name = "AgtPassword", length = 16)
    private String agtPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public String getAgtMiddleInitial() {
        return agtMiddleInitial;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial = agtMiddleInitial;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public String getAgtUserId() {
        return agtUserId;
    }

    public void setAgtUserId(String agtUserId) {
        this.agtUserId = agtUserId;
    }

    public String getAgtPassword() {
        return agtPassword;
    }

    public void setAgtPassword(String agtPassword) {
        this.agtPassword = agtPassword;
    }

}