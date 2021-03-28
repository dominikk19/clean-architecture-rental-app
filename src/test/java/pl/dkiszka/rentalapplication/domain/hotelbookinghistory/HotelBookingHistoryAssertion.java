package pl.dkiszka.rentalapplication.domain.hotelbookinghistory;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Sets;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 21.03.2021
 */
@RequiredArgsConstructor
class HotelBookingHistoryAssertion {

    static HotelBookingHistoryAssertion assertThat(HotelBookingHistory actual) {
        return new HotelBookingHistoryAssertion(actual);
    }

    private final HotelBookingHistory actual;

    HotelBookingHistoryAssertion hasHotelIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("hotelId", expected);
        return this;
    }

    HotelBookingHistoryAssertion hasContainHotelRoomBooking(int expected) {
        extractHotelRoomBookingHistories()
                .satisfies(hotelRoomHistories -> {
                    var hotelRoomHistoriesActual = (List<HotelRoomBookingHistory>) hotelRoomHistories;

                    hotelRoomHistoriesActual.forEach(
                            (bookingHotelRoomHistory) -> {
                                Assertions.assertThat(bookingHotelRoomHistory)
                                        .extracting("bookings")
                                        .satisfies(hotelRoomBooking -> {
                                            var hotelRoomBookingActual = (List<HotelRoomBooking>) hotelRoomBooking;
                                            Assertions.assertThat(hotelRoomBookingActual).size().isEqualTo(expected);
                                        });
                            }
                    );
                });
        return this;
    }

    HotelBookingHistoryAssertion hasContainDays(List<LocalDate> expected) {

        extractHotelRoomBookingHistories()
                .satisfies(hotelRoomHistories -> {
                    var hotelRoomHistoriesActual = (List<HotelRoomBookingHistory>) hotelRoomHistories;

                    var actualDays = hotelRoomHistoriesActual.stream()
                            .map(this::extractBookingDays)
                            .flatMap(Collection::stream)
                            .collect(toList());

                    expected.forEach(
                            day -> {
                                Assertions.assertThat(actualDays).contains(day);
                            }
                    );

                });
        return this;
    }

    private AbstractObjectAssert<?, ?> extractHotelRoomBookingHistories() {
        return Assertions.assertThat(actual).extracting("hotelRoomBookingHistories");
    }

    private List<LocalDate> extractBookingDays(HotelRoomBookingHistory hotelRoomBookingHistories) {
        Set<LocalDate> extractedDays = Sets.newHashSet();
        Assertions.assertThat(hotelRoomBookingHistories)
                .extracting("bookings")
                .satisfies(bookings -> {
                    var actualBookings = (List<HotelRoomBooking>) bookings;

                    actualBookings.forEach(booking -> {
                        Assertions.assertThat(booking)
                                .extracting("days")
                                .satisfies(days -> {
                                    extractedDays.addAll((List<LocalDate>) days);
                                });
                    });
                });
        return extractedDays.stream().collect(toList());
    }

}
