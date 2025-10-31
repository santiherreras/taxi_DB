package com.solvd.taxi.service;

import com.solvd.taxi.dao.CarDAO;
import com.solvd.taxi.model.Car;

import java.util.List;

public class CarService {
    private final CarDAO carDAO = new CarDAO();

    public void addCar(Car car) {
        carDAO.insertCar(car);
    }

    public void updateCarModel(int id, String model) {
        carDAO.updateCarModel(id, model);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }
}
