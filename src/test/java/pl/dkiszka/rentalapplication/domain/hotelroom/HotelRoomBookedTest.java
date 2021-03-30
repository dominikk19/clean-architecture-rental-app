package pl.dkiszka.rentalapplication.domain.hotelroom;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
class HotelRoomBookedTest {

    private final String HOTEL_ROOM_ID = UUID.randomUUID().toString();
    private final String HOTEL_ID = UUID.randomUUID().toString();
    private final String TENANT_ID = UUID.randomUUID().toString();
    private final List<LocalDate> DAYS = List.of(LocalDate.of(2021,3,1), LocalDate.of(2021,3,2));
    private final String EVENT_UUID = UUID.randomUUID().toString();

    @Test
    void should_create_HotelRoomBooked_event_with_all_information() {
        var actual = HotelRoomBooked.create(EVENT_UUID, HOTEL_ROOM_ID, HOTEL_ID, TENANT_ID, DAYS);

        HotelRoomBookedAssertion.assertThat(actual)
                .hasContainEventIdCompatibleWithPattern()
                .hasHotelRoomIdEqualsTo(HOTEL_ROOM_ID)
                .hasHotelIdEqualsTo(HOTEL_ID)
                .hasTenantIdEqualsTo(TENANT_ID)
                .hasContainsDays(DAYS);

    }

}
