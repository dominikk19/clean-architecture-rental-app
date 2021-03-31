package pl.dkiszka.rentalapplication.domain.apartmentoffert;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 31.03.2021
 */
@RequiredArgsConstructor
@Builder
public class ApartmentOffer {

    private final String apartmentUuid;
    private final Money money;
    private final ApartmentAvailability availability;
}
