package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class HotelRoomBooked implements DomainEvent {

    @SuppressWarnings("checkstyle:ParameterNumber")
    static HotelRoomBooked create(String eventUuid, String hotelRoomId, String hotelId, String tenantId, List<LocalDate> days) {
        return new HotelRoomBooked(eventUuid, LocalDateTime.now(), hotelRoomId, hotelId, tenantId, days);
    }

    private final String eventUuid;
    private final LocalDateTime eventCreationDateTime;
    private final String hotelRoomId;
    private final String hotelId;
    private final String tenantId;
    private final List<LocalDate> days;
}
