package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class HotelRoomAssertion {

    static HotelRoomAssertion assertThat(HotelRoom actual) {
        return new HotelRoomAssertion(actual);
    }

    private final HotelRoom actual;

    HotelRoomAssertion hasContainUuidCompatibleWithPattern() {
        Assertions.assertThat(actual)
                .extracting("uuid")
                .satisfies(uuid -> Assertions.assertThat((String) uuid).matches(Pattern.compile("[0-9a-z\\-]{36}")));
        return this;
    }

    HotelRoomAssertion hasHotelIdEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("hotelId", expected);
        return this;
    }

    HotelRoomAssertion hasNumberEqualsTo(int expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("number", expected);
        return this;
    }

    HotelRoomAssertion hasContainSpaces(Map<String, Double> expected) {
        Assertions.assertThat(actual)
                .extracting("spaces")
                .satisfies(spaces -> {
                    var actualSpaces = (List<Space>) spaces;

                    expected.entrySet()
                            .forEach(entry -> {
                                Assertions.assertThat(actualSpaces)
                                        .anySatisfy(space -> {
                                            Assertions.assertThat(space)
                                                    .hasFieldOrPropertyWithValue("name", entry.getKey())
                                                    .hasFieldOrPropertyWithValue("value", entry.getValue());
                                        });
                            });
                });
        return this;
    }
}
