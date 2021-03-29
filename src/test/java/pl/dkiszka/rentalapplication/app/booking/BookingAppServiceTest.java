package pl.dkiszka.rentalapplication.app.booking;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.Booking;
import pl.dkiszka.rentalapplication.domain.booking.BookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 29.03.2021
 */
class BookingAppServiceTest {

    private static final String BOOKING_UUID = UUID.randomUUID().toString();
    private static final String RENTAL_PLACE_ID = "1234";
    private static final String TENANT_ID = "5678";
    private static final List<LocalDate> DAYS = asList(LocalDate.now(), LocalDate.now().plusDays(1));

    private final ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);

    private final BookingRepository bookingRepository = mock(BookingRepository.class);
    private final DomainEventChannel publisher = mock(DomainEventChannel.class);
    private final BookingAppService bookingAppService = new BookingAppService(bookingRepository, publisher);

    @Test
    void given_booking_reject_then_should_be_save_rejected_booking() {
        var booking = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, DAYS);
        var rejectBooking = new BookingReject(BOOKING_UUID);
        given(bookingRepository.findByUuid(BOOKING_UUID)).willReturn(Optional.of(booking));
        bookingAppService.reject(rejectBooking);

        verify(bookingRepository, times(1)).save(any());
    }

    @Test
    void given_booking_accept_then_should_be_save_accepted_booking() {
        var booking = Booking.hotelRoom(RENTAL_PLACE_ID, TENANT_ID, DAYS);
        var bookingAccept = new BookingAccept(BOOKING_UUID);
        given(bookingRepository.findByUuid(BOOKING_UUID)).willReturn(Optional.of(booking));
        bookingAppService.accept(bookingAccept);

        verify(bookingRepository, times(1)).save(any());
    }
}
