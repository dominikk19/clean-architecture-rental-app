package pl.dkiszka.rentalapplication.domain.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelDto {
    private String name;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String city;
    private String country;
}
