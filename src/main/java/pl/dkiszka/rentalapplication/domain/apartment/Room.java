package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Room {
    private final String name;

    @Embedded
    private final SquareMeter squareMeter;
}
