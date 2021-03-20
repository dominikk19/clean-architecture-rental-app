package pl.dkiszka.rentalapplication.adapters.eventchanel.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pl.dkiszka.rentalapplication.domain.DomainEvent;
import pl.dkiszka.rentalapplication.domain.DomainEventChannel;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
@Component
@RequiredArgsConstructor
class SpringEventChannel implements DomainEventChannel {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(DomainEvent event) {
        publisher.publishEvent(event);
    }
}
