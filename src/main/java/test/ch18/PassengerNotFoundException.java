package test.ch18;

public class PassengerNotFoundException extends RuntimeException{

    public PassengerNotFoundException(Long id) {
        super("Passenger id not found : " + id);
    }

}
