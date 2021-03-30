package pl.dkiszka.rentalapplication.domain.events;

import java.util.UUID;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 30.03.2021
 */
public class EventUuidFactory {
    public String create() {
        return UUID.randomUUID().toString();
    }
}
