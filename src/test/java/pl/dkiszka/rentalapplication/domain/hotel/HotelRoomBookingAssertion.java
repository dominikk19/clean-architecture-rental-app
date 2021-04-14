package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.dkiszka.rentalapplication.domain.booking.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
@RequiredArgsConstructor
class HotelRoomBookingAssertion {

    static HotelRoomBookingAssertion assertThat(Booking actual) {
        return new HotelRoomBookingAssertion(actual);
    }

    private final Booking actual;


    HotelRoomBookingAssertion hasContainUuidCompatibleWithPattern() {
        Assertions.assertThat(actual)
                .extracting("uuid")
                .satisfies(uuid -> Assertions.assertThat((String) uuid).matches(Pattern.compile("[0-9a-z\\-]{36}")));
        return this;
    }

    HotelRoomBookingAssertion hasTenantIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    public void hasContainsDays(List<LocalDate> expected) {
        Assertions.assertThat(actual)
                .extracting("days")
                .satisfies(days -> {
                    var actualDays = (List<LocalDate>) days;

                    expected.forEach(
                            day -> {
                                Assertions.assertThat(actualDays)
                                        .anySatisfy(actualDay -> Assertions.assertThat(actualDay).isEqualTo(day));
                            }
                    );
                });
    }
}
