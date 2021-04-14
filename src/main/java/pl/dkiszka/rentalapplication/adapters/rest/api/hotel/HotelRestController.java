package pl.dkiszka.rentalapplication.adapters.rest.api.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.hotel.HotelAppService;
import pl.dkiszka.rentalapplication.domain.hotel.HotelDto;
import pl.dkiszka.rentalapplication.query.hotel.QueryHotelRepository;
import pl.dkiszka.rentalapplication.query.hotel.dto.HotelReadModelDto;

import java.net.URI;
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
    ResponseEntity<Void> add(@RequestBody HotelDto hotelDto) {
        var uuid = hotelAppService.add(hotelDto);
        return ResponseEntity
                .created(URI.create("/hotel/".concat(uuid)))
                .build();
    }

    @GetMapping
    public List<HotelReadModelDto> findAll() {
        return queryHotelRepository.findAll();
    }
}
