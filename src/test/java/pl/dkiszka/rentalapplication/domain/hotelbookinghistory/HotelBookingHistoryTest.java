package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 21.03.2021
 */
class HotelBookingHistoryTest {
    private static final String HOTEL_ID = "1234";
    private static final String HOTEL_ROOM_ID = "5678";
    private static final String TENANT_ID = "8989";
    private static final LocalDateTime BOOKING_DATE_TIME = LocalDateTime.of(2020, 2, 4, 6, 8);
    private static final LocalDate DATE_1 = LocalDate.of(2020, 1, 2);
    private static final LocalDate DATE_2 = LocalDate.of(2020, 3, 4);
    private static final LocalDate DATE_3 = LocalDate.of(2020, 5, 2);
    private static final LocalDate DATE_4 = LocalDate.of(2020, 5, 4);

    @Test
    void should_add_first_hotel_room_booking_into_hotel_history() {
        var actual = new HotelBookingHistory(HOTEL_ID);
        actual.add(HOTEL_ROOM_ID, BOOKING_DATE_TIME, TENANT_ID, Lists.newArrayList(DATE_1, DATE_2));

        HotelBookingHistoryAssertion.assertThat(actual)
                .hasHotelIdEqualsTo(HOTEL_ID)
                .hasContainHotelRoomBooking(1);
    }

    @Test
    void should_add_next_booking_into_room_history() {
        var actual = new HotelBookingHistory(HOTEL_ID);
        actual.add(HOTEL_ROOM_ID, BOOKING_DATE_TIME, TENANT_ID, Lists.newArrayList(DATE_1, DATE_2));
        actual.add(HOTEL_ROOM_ID, BOOKING_DATE_TIME, TENANT_ID, Lists.newArrayList(DATE_3, DATE_4));

        HotelBookingHistoryAssertion.assertThat(actual)
                .hasHotelIdEqualsTo(HOTEL_ID)
                .hasContainHotelRoomBooking(2)
                .hasContainDays(Lists.newArrayList(DATE_1, DATE_2, DATE_3, DATE_4));
    }
}
