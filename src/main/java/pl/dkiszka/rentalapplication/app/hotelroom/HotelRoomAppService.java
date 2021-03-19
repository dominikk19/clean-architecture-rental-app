package pl.dkiszka.rentalapplication.app.hotelroom;

import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.apartment.BookingRepository;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomFactory;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor
public class HotelRoomAppService {

    private final HotelRoomRepository hotelRoomRepository;
    private final BookingRepository bookingRepository;
    private final DomainEventChannel eventChannel;

    public void add(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        var hotelRoom = new HotelRoomFactory().create(hotelId, number, spacesDefinition, description);
        hotelRoomRepository.save(hotelRoom);
    }

    public void book(String uuid, String tenantId, List<LocalDate> days) {
        var hotelRoom = hotelRoomRepository.findByUuid(uuid);
        var booking = hotelRoom.book(tenantId, days, eventChannel);

        bookingRepository.save(booking);
    }
}
