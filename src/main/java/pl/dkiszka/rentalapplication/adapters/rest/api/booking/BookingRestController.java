package pl.dkiszka.rentalapplication.adapters.rest.api.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dkiszka.rentalapplication.app.booking.BookingAccept;
import pl.dkiszka.rentalapplication.app.booking.BookingReject;
import pl.dkiszka.rentalapplication.app.commandregistry.CommandRegistry;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
class BookingRestController {
    private final CommandRegistry commandRegistry;


    @PutMapping("/reject/{uuid}")
    public void reject(@PathVariable String uuid) {
        commandRegistry.register(new BookingReject(uuid));
    }

    @PutMapping("/accept/{uuid}")
    public void accept(@PathVariable String uuid) {
        commandRegistry.register(new BookingAccept(uuid));
    }
}
