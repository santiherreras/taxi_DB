package com.solvd.taxi.model;

public class Car {
    private int carId;
    private String licensePlate;
    private String model;
    private String brand;
    private int year;
    private int companyId;

    public Car() {}

    public Car(int carId, String licensePlate, String model, String brand, int year, int companyId) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.companyId = companyId;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getModel() { return model; }
    public String getBrand() { return brand; }
    public int getYear() { return year; }
    public int getCompanyId() { return companyId; }
    public int getCarId() { return carId; }

    public void setCarId(int carId) { this.carId = carId; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setModel(String model) { this.model = model; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setYear(int year) { this.year = year; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }

    @Override
    public String toString() {
        return "Car {id=" + carId + ", plate='" + licensePlate + "', model='" + model + "', brand='" + brand + "', year=" + year + ", companyId=" + companyId + "}";
    }
}
