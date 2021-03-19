package pl.dkiszka.rentalapplication.adapters.rest.api.hotelroom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.hotelroom.HotelRoomAppService;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@RestController
@RequestMapping("/hotelroom")
@RequiredArgsConstructor
class HotelRoomRestController {

    private final HotelRoomAppService hotelRoomAppService;

    @PostMapping
    void add(@RequestBody HotelRoomDto hotelRoomDto) {
        hotelRoomAppService.add(
                hotelRoomDto.getHotelId(), hotelRoomDto.getNumber(), hotelRoomDto.getSpacesDefinition(), hotelRoomDto.getDescription());
    }

    @PutMapping("/book/{uuid}")
    public void book(@PathVariable String uuid, @RequestBody HotelBookingDto hotelBookingDto) {
        hotelRoomAppService.book(uuid, hotelBookingDto.getTenantId(), hotelBookingDto.getDays());
    }
}
