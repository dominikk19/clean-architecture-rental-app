package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.events.EventUuidFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
@RequiredArgsConstructor
public class HotelRoomEventsPublisher {
    private final EventUuidFactory factory;
    private final DomainEventChannel publisher;

    void publishHotelRoomBooked(String hotelRoomId, String hotelId, String tenantId, List<LocalDate> days) {
        var hotelRoomBooked = HotelRoomBooked.create(factory.create(), hotelRoomId, hotelId, tenantId, days);
        publisher.publish(hotelRoomBooked);
    }
}
