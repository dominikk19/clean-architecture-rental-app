package pl.dkiszka.rentalapplication.domain.booking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 20.03.2021
 */
class BookingTest {
    private static final List<LocalDate> DAYS = asList(LocalDate.now(), LocalDate.now().plusDays(1));
    private static final String TENANT_ID = UUID.randomUUID().toString();
    private static final String RENTAL_PLACE_ID = UUID.randomUUID().toString();

    private final DomainEventChannel eventChannel = mock(DomainEventChannel.class);


    @Test
    void should_create_booking_for_apartment() {
        var period = new Period(LocalDate.of(2020, 3, 4), LocalDate.of(2020, 3, 6));
        var actual = Booking.apartment(RENTAL_PLACE_ID, TENANT_ID, period);

        BookingAssertion.assertThat(actual)
                .hasBookingStatusEqualTo(BookingStatus.OPEN)
                .hasRentalTypeEqualTo(RentalType.APARTMENT)
                .hasRentalPlaceIdEqualTo(RENTAL_PLACE_ID)
                .hasTenantIdEqualTo(TENANT_ID)
                .containsAllDays(asList(LocalDate.of(2020, 3, 4), LocalDate.of(2020, 3, 5), LocalDate.of(2020, 3, 6)));
    }

    @Test
    void should_create_booking_for_hotel_room() {
        var  days = asList(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 2), LocalDate.of(2020, 6, 4));
        var actual = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, days);

        BookingAssertion.assertThat(actual)
                .hasBookingStatusEqualTo(BookingStatus.OPEN)
                .hasRentalTypeEqualTo(RentalType.HOTEL_ROOM)
                .hasRentalPlaceIdEqualTo(RENTAL_PLACE_ID)
                .hasTenantIdEqualTo(TENANT_ID)
                .containsAllDays(days);
    }

    @Test
    void should_change_status_of_booking_once_accepted() {
        var booking = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, DAYS);
        booking.accept(eventChannel);

        BookingAssertion.assertThat(booking)
                .hasBookingStatusEqualTo(BookingStatus.ACCEPTED);
    }

    @Test
    void should_publish_booking_accepted_once_accepted() {
        ArgumentCaptor<BookingAccepted> captor = ArgumentCaptor.forClass(BookingAccepted.class);
        var booking = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, DAYS);
        booking.accept(eventChannel);

        BDDMockito.then(eventChannel).should().publish(captor.capture());
        BookingAccepted actual = captor.getValue();
        Assertions.assertThat(actual.getRentalType()).isEqualTo("HOTEL_ROOM");
        Assertions.assertThat(actual.getRentalPlaceId()).isEqualTo(RENTAL_PLACE_ID);
        Assertions.assertThat(actual.getTenantId()).isEqualTo(TENANT_ID);
        Assertions.assertThat(actual.getDays()).containsExactlyElementsOf(DAYS);
    }

    @Test
    void should_change_status_of_booking_once_rejected() {
        Booking booking = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, DAYS);
        booking.reject();

        BookingAssertion.assertThat(booking)
                .hasBookingStatusEqualTo(BookingStatus.REJECTED);
    }
}
