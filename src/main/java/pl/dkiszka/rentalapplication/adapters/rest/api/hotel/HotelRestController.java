package pl.dkiszka.rentalapplication.adapters.rest.api.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.hotel.HotelAppService;
import pl.dkiszka.rentalapplication.query.hotel.QueryHotelRepository;
import pl.dkiszka.rentalapplication.query.hotel.dto.HotelReadModelDto;

import java.util.List;

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
    private final QueryHotelRepository queryHotelRepository;

    @PostMapping
    void add(@RequestBody HotelDto hotelDto) {
        hotelAppService.add(hotelDto);
    }

    @GetMapping
    public List<HotelReadModelDto> findAll() {
        return queryHotelRepository.findAll();
    }
}
