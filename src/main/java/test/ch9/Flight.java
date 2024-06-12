package test.ch9;

import java.util.HashSet;
import java.util.Set;

public class Flight {

    private String flightNumber;
    private int seats;

    Set<Passenger> passengers = new HashSet<>();

    public Flight(String flightNumber, int seats) {
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getSeats() {
        return seats;
    }

    public int getNumberOfPassengers () {
        return passengers.size();
    }

    public void setSeats(int seats) {
        if(passengers.size() > seats) {
            throw new RuntimeException(
                    "Невозможно уменьшить количество мест ниже количества существующих пассажиров!");
        }
        this.seats = seats;
    }

    public boolean addPassenger(Passenger passenger) {
        if(passengers.size() >= seats) {
            throw new RuntimeException(
                    "Невозможно добавить больше пассажиров, чем вместимость рейса!");
        }
        return passengers.add(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    @Override
    public String toString() {
        return "Рейс " + getFlightNumber();
    }

}
