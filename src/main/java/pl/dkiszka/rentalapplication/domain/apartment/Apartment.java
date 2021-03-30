package pl.dkiszka.rentalapplication.domain.apartment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;
import pl.dkiszka.rentalapplication.domain.booking.Booking;
import pl.dkiszka.rentalapplication.domain.booking.Period;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@Table(name = "APARTMENT")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Apartment {

    static ApartmentBuilder builder() {
        return new ApartmentBuilder();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @EqualsAndHashCode.Include
    private String uuid;
    private String ownerId;

    @Embedded
    private Address address;

    @OneToMany
    private List<Room> rooms;
    private String description;

    Apartment(String uuid, String ownerId, Address address, List<Room> rooms, String description) {
        this.uuid = uuid;
        this.ownerId = ownerId;
        this.address = address;
        this.rooms = rooms;
        this.description = description;
    }

    public Booking book(String tenantId, Period period, DomainEventChannel eventChannel) {
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, period);
        eventChannel.publish(apartmentBooked);

        return Booking.apartment(id, tenantId, period);
    }

    public static class ApartmentBuilder {
        private String ownerId;
        private Address address;
        private List<Room> rooms;
        private String description;


        public ApartmentBuilder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public ApartmentBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public ApartmentBuilder rooms(List<Room> rooms) {
            this.rooms = rooms;
            return this;
        }

        public ApartmentBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Apartment build() {
            return new Apartment(UUID.randomUUID().toString(), this.ownerId, this.address, this.rooms, this.description);
        }

        public String toString() {
            return "ApartmentBuilder(ownerId=" + this.ownerId + ", address=" + this.address + ", rooms=" + this.rooms + ", description=" + this.description + ")";
        }
    }
}
