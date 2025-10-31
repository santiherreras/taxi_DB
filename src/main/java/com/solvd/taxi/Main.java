package com.solvd.taxi;

import com.solvd.taxi.model.Driver;
import com.solvd.taxi.model.TaxiCompany;
import com.solvd.taxi.service.DriverService;
import com.solvd.taxi.service.TaxiCompanyService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DriverService driverService = new DriverService();
        TaxiCompanyService companyService = new TaxiCompanyService();

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
    }
}
