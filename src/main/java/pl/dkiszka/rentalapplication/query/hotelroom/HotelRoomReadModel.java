package pl.dkiszka.rentalapplication.query.hotelroom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Entity
@Table(name = "HOTEL_ROOM")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HotelRoomReadModel {
    @Id
    private String id;
    private String uuid;
    private String hotelId;
    private int number;

//    @ElementCollection
//    private List<SpaceReadModel> spaces;

    private String description;
}
