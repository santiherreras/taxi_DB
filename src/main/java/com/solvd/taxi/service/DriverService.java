package com.solvd.taxi.service;



import com.solvd.taxi.dao.DriverDAO;
import com.solvd.taxi.model.Driver;
import java.util.List;

public class DriverService {
    private final DriverDAO driverDAO = new DriverDAO();

    public List<Driver> getAllDrivers() {
        return driverDAO.getAllDrivers();
    }
}
