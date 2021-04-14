package pl.dkiszka.rentalapplication.adapters.rest.api.hotel;

import com.google.common.collect.Sets;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import pl.dkiszka.rentalapplication.domain.hotel.Hotel;
import pl.dkiszka.rentalapplication.domain.hotel.HotelRepository;

import java.util.Set;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 14.04.2021
 */
@TestConfiguration
class InMemoryDatabaseHotelTestConfiguration {

    @Bean
    HotelRepository hotelRepository() {
        return new InMemoryHotelRepository();
    }
}


class InMemoryHotelRepository implements HotelRepository {

    private final Set<Hotel> database = Sets.newConcurrentHashSet();

    @Override
    public Hotel save(Hotel hotel) {
        database.add(hotel);
        return database.stream()
                .filter(entityHotel -> entityHotel.equals(hotel))
                .findFirst()
                .orElse(null);
    }
}
