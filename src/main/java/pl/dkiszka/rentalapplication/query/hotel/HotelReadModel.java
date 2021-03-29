package pl.dkiszka.rentalapplication.query.hotel;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@Table(name = "HOTEL")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HotelReadModel {
    @Id
    private String id;
    private String uuid;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String city;
    private String country;
}
