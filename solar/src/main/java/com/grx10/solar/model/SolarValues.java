package com.grx10.solar.model;

public class SolarValues {

    private int panels;
    private int requiredArea;
    private double capital;
    private int breakEvenYears;
    private double earnings;

    public SolarValues(int panels, int requiredArea, double capital, int breakEvenYears, double earnings) {
        this.panels = panels;
        this.requiredArea = requiredArea;
        this.capital = capital;
        this.breakEvenYears = breakEvenYears;
        this.earnings = earnings;
    }

    public int getPanels() {
        return panels;
    }

    public void setPanels(int panels) {
        this.panels = panels;
    }

    public int getRequiredArea() {
        return requiredArea;
    }

    public void setRequiredArea(int requiredArea) {
        this.requiredArea = requiredArea;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public int getBreakEvenYears() {
        return breakEvenYears;
    }

    public void setBreakEvenYears(int breakEvenYears) {
        this.breakEvenYears = breakEvenYears;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    @Override
    public String toString() {
        return "SolarValues{" +
                "panels=" + panels +
                ", requiredArea=" + requiredArea +
                ", capital='" + capital + '\'' +
                ", breakEvenYears=" + breakEvenYears +
                ", earnings='" + earnings + '\'' +
                '}';
    }
}
