package pl.dkiszka.rentalapplication.adapters.persistence.jpa.apartment;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 19.03.2021
 */
class ApartmentNotFoundException  extends RuntimeException{
    public ApartmentNotFoundException(String message) {
        super(message);
    }
}
