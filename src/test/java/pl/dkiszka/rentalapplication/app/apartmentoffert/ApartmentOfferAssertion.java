package pl.dkiszka.rentalapplication.app.apartmentoffert;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.dkiszka.rentalapplication.domain.apartmentoffert.ApartmentOffer;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentOfferAssertion {

    static ApartmentOfferAssertion assertThat(ApartmentOffer actual) {
        return new ApartmentOfferAssertion(actual);
    }

    private final ApartmentOffer actual;

    ApartmentOfferAssertion hasApartmentUuidEqualTo(String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("apartmentUuid", expected);
        return this;
    }

    ApartmentOfferAssertion hasPriceEqualTo(BigDecimal expected) {
        Assertions.assertThat(actual).extracting("money")
                .hasFieldOrPropertyWithValue("value", expected);
        return this;
    }

    ApartmentOfferAssertion hasAvailabilityEqualTo(LocalDate start, LocalDate end) {
        Assertions.assertThat(actual).extracting("availability")
                .hasFieldOrPropertyWithValue("start", start)
                .hasFieldOrPropertyWithValue("end", end);
        return this;
    }
}
