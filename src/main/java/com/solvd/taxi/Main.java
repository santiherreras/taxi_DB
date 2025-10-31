package com.solvd.taxi;

import com.solvd.taxi.model.*;
import com.solvd.taxi.service.*;
import com.solvd.taxi.model.Car;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DriverService driverService = new DriverService();
        TaxiCompanyService companyService = new TaxiCompanyService();
        CarService carService = new CarService();
        PassengerService passengerService = new PassengerService();
        BookingService bookingService = new BookingService();


        System.out.println("============== ALL COMPANIES ==============");
        List<TaxiCompany> companies = companyService.getAllCompanies();
        for (TaxiCompany c : companies) {
            System.out.println(c);
        }

        System.out.println("\n============== ALL DRIVERS ==============");
        List<Driver> drivers = driverService.getAllDrivers();
        for (Driver d : drivers) {
            System.out.println(d);
        }


        System.out.println("\n============== INSERT NEW CAR ==============");
        Car newCar = new Car(0,"XYZ-456","Toyota", "Corolla", 2022, 1);
        carService.addCar(newCar);
        System.out.println("Car inserted: " + newCar);



    }
}
