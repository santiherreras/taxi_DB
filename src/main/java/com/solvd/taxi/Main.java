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

        System.out.println("\n============== ALL BOOKINGS ==============");
        List<Booking> bookings = bookingService.getAllBookings();
        for (Booking  b : bookings) {
            System.out.println(b);
        }

        System.out.println("\n============== INSERT NEW CAR ==============");
        Car newCar = new Car(0,"FCX-111","Toyota", "Corolla", 2020, 1);
        carService.addCar(newCar);
        System.out.println("Car inserted: " + newCar);

        System.out.println("\n============== INSERT NEW PASSENGER ==============");
        Passenger newPassenger = new Passenger(10,"Ida", "3213378449");
        passengerService.addPassenger(newPassenger);
        System.out.println("Passenger inserted: " + newPassenger);


        System.out.println("\n============== UPDATE PASSENGER ==============");
        String newNumber = "3338947897";
        passengerService.updatePassengerPhone(5,newNumber);

        System.out.println("\n============== ALL PASSENGERS ==============");
        List<Passenger> passengers = passengerService.getAllPassengers();
        for (Passenger p : passengers) {
            System.out.println(p);
        }


        System.out.println("\n============== DELETE PASSENGER ==============");
        passengerService.deletePassenger(5);


        System.out.println("\n============== ALL PASSENGERS ==============");
        passengers = passengerService.getAllPassengers();
        for (Passenger p : passengers) {
            System.out.println(p);
        }

    }
}
