package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Hotel {
    private String uuid;
    private final String name;
    private final Address address;
}
