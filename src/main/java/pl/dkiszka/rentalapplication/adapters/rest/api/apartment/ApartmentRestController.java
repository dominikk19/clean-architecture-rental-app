package pl.dkiszka.rentalapplication.adapters.rest.api.apartment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.apartment.ApartmentAppService;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RestController
@RequestMapping("/apartment")
@RequiredArgsConstructor
class ApartmentRestController {
    private final ApartmentAppService apartmentAppService;

    @PostMapping
    void add(@RequestBody ApartmentDto apartmentDto) {
        apartmentAppService.add(
                apartmentDto.getOwnerId(), apartmentDto.getStreet(), apartmentDto.getPostalCode(), apartmentDto.getHouseNumber(),
                apartmentDto.getApartmentNumber(), apartmentDto.getCity(), apartmentDto.getCountry(), apartmentDto.getDescription(),
                apartmentDto.getRoomsDefinition());
    }

    @PutMapping("/book/{uuid}")
    public void book(@PathVariable String uuid, @RequestBody ApartmentBookingDto apartmentBookingDto) {
        apartmentAppService.book(
                uuid, apartmentBookingDto.getTenantId(), apartmentBookingDto.getStart(), apartmentBookingDto.getEnd());
    }
}
