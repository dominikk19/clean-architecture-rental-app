package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.Period;
import pl.dkiszka.rentalapplication.domain.events.EventUuidFactory;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
@RequiredArgsConstructor
public class ApartmentEventsPublisher {
    private final EventUuidFactory factory;
    private final DomainEventChannel publisher;

    void publishApartmentBooked(String apartmentId, String ownerId, String tenantId, Period period) {
        var apartmentBooked = ApartmentBooked.create(factory.create(), apartmentId, ownerId, tenantId, period);
        publisher.publish(apartmentBooked);
    }
}
