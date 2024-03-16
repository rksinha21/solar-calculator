package com.grx10.solar.model;

import jakarta.persistence.Entity;

import java.io.Serializable;

public class Solar implements Serializable {

    private static final long serialVersionUID = -328748734683475L;
    private int monthlyBill;
    private int roofArea;

    public Solar() {
    }

    public int getMonthlyBill() {
        return monthlyBill;
    }

    public void setMonthlyBill(int monthlyBill) {
        this.monthlyBill = monthlyBill;
    }

    public int getRoofArea() {
        return roofArea;
    }

    public void setRoofArea(int roofArea) {
        this.roofArea = roofArea;
    }
}
