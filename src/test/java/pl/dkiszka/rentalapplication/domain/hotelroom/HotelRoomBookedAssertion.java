package pl.dkiszka.rentalapplication.domain.hotelroom;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class HotelRoomBookedAssertion {

    static HotelRoomBookedAssertion assertThat(HotelRoomBooked actual){
        return new HotelRoomBookedAssertion(actual);
    }

    private final HotelRoomBooked actual;

    HotelRoomBookedAssertion hasContainEventIdCompatibleWithPattern() {
        Assertions.assertThat(actual)
                .extracting("eventUuid")
                .satisfies(eventId -> Assertions.assertThat((String) eventId).matches(Pattern.compile("[0-9a-z\\-]{36}")));
        return this;
    }

    HotelRoomBookedAssertion hasHotelRoomIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("hotelRoomId", expected);
        return this;

    }
    HotelRoomBookedAssertion hasHotelIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("hotelId", expected);
        return this;
    }

    HotelRoomBookedAssertion hasTenantIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    HotelRoomBookedAssertion hasContainsDays(List<LocalDate> expected) {
        Assertions.assertThat(actual)
                .extracting("days")
                .satisfies(days->{
                    var actualDays = (List<LocalDate>) days;

                    expected.forEach(
                            expectedDay->{
                                Assertions.assertThat(actualDays)
                                        .anySatisfy(actualDay->Assertions.assertThat(actualDay).isEqualTo(expectedDay));
                            }
                    );
                });
        return this;
    }
}
