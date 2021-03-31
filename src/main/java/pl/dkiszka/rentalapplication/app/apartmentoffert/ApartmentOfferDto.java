package pl.dkiszka.rentalapplication.app.apartmentoffert;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor
@Getter
public class ApartmentOfferDto {
    private final String apartmentUuid;
    private final BigDecimal price;
    private final LocalDate start;
    private final LocalDate end;
}
