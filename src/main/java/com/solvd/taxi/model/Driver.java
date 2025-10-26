package com.solvd.taxi.model;

import java.time.LocalDate;

public class Driver {

    private int driverId;
    private String name;
    private String phone;
    private LocalDate hireDate;
    private int companyId;

    public Driver() {}

    public Driver(int driverId, String name, String phone, LocalDate hireDate, int companyId) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.hireDate = hireDate;
        this.companyId = companyId;
    }

    // Getters and Setters
    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    @Override
    public String toString() {
        return "Driver {" +
                "driverId=" + driverId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate +
                ", companyId=" + companyId +
                '}';
    }
}
