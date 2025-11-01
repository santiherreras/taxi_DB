package com.solvd.taxi.service;

import com.solvd.taxi.dao.PassengerDAO;
import com.solvd.taxi.model.Passenger;

import java.util.List;

public class PassengerService {
    private final PassengerDAO passengerDAO = new PassengerDAO();

    public void addPassenger(Passenger passenger) {
        passengerDAO.insertPassenger(passenger);
    }

    public void updatePassengerPhone(int id, String phone) {
        passengerDAO.updatePassengerPhone(id, phone);
    }

    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAllPassengers();
    }

    public void deletePassenger(int id) {
        passengerDAO.deletePassenger(id);
    }
}
