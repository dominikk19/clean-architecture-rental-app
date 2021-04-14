package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @EqualsAndHashCode.Include
    private String uuid;
    private String name;

    @Embedded
    private Address address;

    Hotel(String uuid, String name, Address address) {
        this.uuid = uuid;
        this.name = name;
        this.address = address;
    }

    public String uuid(){
        return uuid;
    }
}
