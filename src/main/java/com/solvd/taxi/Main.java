/*
Taxi
By Santiago Herrera
 */

package com.solvd.taxi;


import com.solvd.taxi.model.Driver;
import com.solvd.taxi.service.DriverService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DriverService driverService = new DriverService();

        System.out.println("============== ALL DRIVERS ==============");
        List<Driver> drivers = driverService.getAllDrivers();
        for (Driver d : drivers) {
            System.out.println(d);
        }
    }
}



