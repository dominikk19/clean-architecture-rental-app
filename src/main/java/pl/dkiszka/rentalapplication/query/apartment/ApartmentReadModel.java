package pl.dkiszka.rentalapplication.query.apartment;


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
@Table(name = "APARTMENT")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ApartmentReadModel {
    @Id
    private String id;
    private String uuid;
    private String ownerId;
    private String street;
    private String postalCode;
    private String houseNumber;
    private String apartmentNumber;
    private String city;
    private String country;
    private String description;

//    @ElementCollection
//    private List<RoomReadModel> rooms;
}
