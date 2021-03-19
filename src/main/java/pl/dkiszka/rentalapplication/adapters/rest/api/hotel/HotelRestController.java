package pl.dkiszka.rentalapplication.adapters.rest.api.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.hotel.HotelAppService;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
class HotelRestController {

    private final HotelAppService hotelAppService;

    @PostMapping
    void add(@RequestBody HotelDto hotelDto) {
        hotelAppService.add(
                hotelDto.getName(), hotelDto.getStreet(), hotelDto.getPostalCode(), hotelDto.getBuildingNumber(),
                hotelDto.getCity(), hotelDto.getCountry());
    }

}
