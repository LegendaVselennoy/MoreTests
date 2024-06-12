package ch17;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import test.ch16.Country;
import test.ch16.Passenger;

@TestConfiguration
public class TestBeans {

    @Bean
    Passenger createPassenger() {
        Passenger passenger = new Passenger("John Smith");
        passenger.setCountry(createCountry());
        passenger.setIsRegistered(false);
        return passenger;
    }

    @Bean
    Country createCountry() {
        Country country = new Country("USA", "US");
        return country;
    }

}
