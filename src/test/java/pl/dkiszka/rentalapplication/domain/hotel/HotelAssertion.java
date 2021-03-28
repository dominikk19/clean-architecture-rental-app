package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;


import java.util.regex.Pattern;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 28.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class HotelAssertion {

    static HotelAssertion assertThat(Hotel actual) {
        return new HotelAssertion(actual);
    }

    private final Hotel actual;

    HotelAssertion hasContainUuidCompatibleWithPattern() {
        Assertions.assertThat(actual)
                .extracting("uuid")
                .satisfies(uuid -> Assertions.assertThat((String) uuid).matches(Pattern.compile("[0-9a-z\\-]{36}")));
        return this;
    }

    HotelAssertion hasNameEqualsTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("name", expected);
        return this;
    }

    HotelAssertion hasCityEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .extracting("address").hasFieldOrPropertyWithValue("city", expected);
        return this;
    }

    HotelAssertion hasStreetEqualsTo(String expected) {
        Assertions.assertThat(actual)
                .extracting("address")
                .hasFieldOrPropertyWithValue("street", expected);
        return this;
    }
}
