package pl.dkiszka.rentalapplication.architecture;

import com.tngtech.archunit.library.GeneralCodingRules;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 29.03.2021
 */
@Tag("ArchitectureTest")
class ClassesStructureTest {
    @Test
    void should_have_no_class_that_uses_field_injection() {
        GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION.check(RentalApplicationClasses.getJavaClasses());
    }

    @Test
    void should_have_no_class_that_throws_generic_exception() {
        GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(RentalApplicationClasses.getJavaClasses());
    }
}
