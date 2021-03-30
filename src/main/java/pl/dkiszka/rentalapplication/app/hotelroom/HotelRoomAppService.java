package pl.dkiszka.rentalapplication.app.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dkiszka.rentalapplication.adapters.rest.api.hotelroom.HotelRoomDto;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomFactory;
import pl.dkiszka.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Service
@RequiredArgsConstructor
public class HotelRoomAppService {

    private final HotelRoomRepository hotelRoomRepository;
    private final BookingRepository bookingRepository;
    private final DomainEventChannel eventChannel;

    public void add(HotelRoomDto hotelRoomDto) {
        var hotelRoom = HotelRoomFactory.create(hotelRoomDto);
        hotelRoomRepository.save(hotelRoom);
    }

    public void book(String uuid, String tenantId, List<LocalDate> days) {
        var hotelRoom = hotelRoomRepository.findByUuid(uuid);
        var booking = hotelRoom.book(tenantId, days, eventChannel);

        bookingRepository.save(booking);
    }
}
