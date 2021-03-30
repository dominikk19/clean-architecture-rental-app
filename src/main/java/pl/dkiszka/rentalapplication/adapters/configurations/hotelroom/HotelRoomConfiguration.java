package pl.dkiszka.rentalapplication.adapters.configurations.hotelroom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.events.EventUuidFactory;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomEventsPublisher;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
@Configuration
class HotelRoomConfiguration {

    @Bean
    HotelRoomEventsPublisher hotelRoomEventsPublisher(DomainEventChannel domainEventChannel) {
        return new HotelRoomEventsPublisher(new EventUuidFactory(), domainEventChannel);
    }
}
