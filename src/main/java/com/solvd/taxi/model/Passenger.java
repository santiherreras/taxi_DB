package com.solvd.taxi.model;

public class Passenger {
    private int passengerId;
    private String name;
    private String phone;

    public Passenger() {}

    public Passenger(int passengerId, String name, String phone) {
        this.passengerId = passengerId;
        this.name = name;
        this.phone = phone;
    }

    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Passenger {id=" + passengerId + ", name='" + name + "', phone='" + phone + "'}";
    }
}
