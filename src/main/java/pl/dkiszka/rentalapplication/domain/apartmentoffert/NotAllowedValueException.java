package pl.dkiszka.rentalapplication.domain.apartmentoffert;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
public class NotAllowedValueException extends RuntimeException {
    public NotAllowedValueException(BigDecimal value) {
        super("Price " + Optional.ofNullable(value).map(Objects::toString).orElse(null) + " is lower than zero.");
    }
}
