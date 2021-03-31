package pl.dkiszka.rentalapplication.domain.apartmentoffert;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    private final BigDecimal value;

    public static Money of(BigDecimal value) {
        return Optional.ofNullable(value)
                .filter(it -> it.compareTo(BigDecimal.ZERO) >= 0)
                .map(Money::new)
                .orElseThrow(() -> new NotAllowedValueException(value));
    }
}

