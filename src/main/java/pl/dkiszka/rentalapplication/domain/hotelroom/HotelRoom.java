package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.Booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String uuid;
    private final String hotelId;
    private final int number;

    @OneToMany
    private final List<Space> spaces;

    private final String description;

    public Booking book(String tenantId, List<LocalDate> days, DomainEventChannel eventChannel) {
        var hotelRoomBooked = HotelRoomBooked.create(id, hotelId, tenantId, days);
        eventChannel.publish(hotelRoomBooked);

        return Booking.hotelRoom(id, tenantId, days);
    }
}
