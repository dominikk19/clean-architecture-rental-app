package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String uuid;
    private final String name;

    @Embedded
    private final Address address;
}
