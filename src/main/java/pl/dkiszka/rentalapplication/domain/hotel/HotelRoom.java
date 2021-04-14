package pl.dkiszka.rentalapplication.domain.hotel;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.domain.booking.Booking;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@Table(name = "HOTEL_ROOM")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String uuid;
    private String hotelId;
    private int number;

    @ElementCollection
    private List<Space> spaces;

    private String description;

    HotelRoom(String uuid, String hotelId, int number, List<Space> spaces, String description) {
        this.uuid = uuid;
        this.hotelId = hotelId;
        this.number = number;
        this.spaces = spaces;
        this.description = description;
    }

    public Booking book(String tenantId, List<LocalDate> days, HotelRoomEventsPublisher publisher) {
        publisher.publishHotelRoomBooked(id, hotelId, tenantId, days);

        return Booking.hotelRoom(id, tenantId, days);
    }
}
