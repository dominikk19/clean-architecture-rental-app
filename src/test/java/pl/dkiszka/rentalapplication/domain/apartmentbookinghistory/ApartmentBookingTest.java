package pl.dkiszka.rentalapplication.domain.apartmentbookinghistory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
class ApartmentBookingTest {
    @Test
    void should_create_start_apartment_booking_with_all_required_information() {
        var bookingDateTime = LocalDateTime.of(2020, 1, 2, 3, 4);
        var ownerId = "123";
        var tenantId = "234";
        var start = LocalDate.of(2020, 2, 1);
        var end = LocalDate.of(2020, 2, 8);

        var actual = ApartmentBooking.start(bookingDateTime, ownerId, tenantId, new BookingPeriod(start, end));


        ApartmentBookingAssertion.assertThat(actual)
                .hasBookingDateTimeEqualTo(bookingDateTime)
                .hasOwnerIdEqualTo(ownerId)
                .hasTenantIdEqualTo(tenantId)
                .hasBookingPeriodThatHas(start, end);
    }
}
