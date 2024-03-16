package com.grx10.solar.model;

import jakarta.persistence.*;

@Entity
@Table(name="leadCapture")
public class LeadCapture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="phoneNo", unique = true)
    private String phoneNo;

    public LeadCapture() {
    }

    public LeadCapture(long Id, String phoneNo) {
        super();
        this.Id = Id;
        this.phoneNo = phoneNo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
