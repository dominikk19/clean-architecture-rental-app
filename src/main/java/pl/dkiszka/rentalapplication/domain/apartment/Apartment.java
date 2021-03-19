package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private final String uuid;
    private final String ownerId;

    @Embedded
    private final Address address;

    @OneToMany
    private final List<Room> rooms;
    private final String description;

    public Booking book(String tenantId, Period period, DomainEventChannel eventChannel) {
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, period);
        eventChannel.publish(apartmentBooked);

        return Booking.apartment(id, tenantId, period);
    }
}
