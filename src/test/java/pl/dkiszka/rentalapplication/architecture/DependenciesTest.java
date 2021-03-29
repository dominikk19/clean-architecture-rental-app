package pl.dkiszka.rentalapplication.architecture;

import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 29.03.2021
 */
@Tag("ArchitectureTest")
class DependenciesTest {
    @Test
    void should_have_no_cycles() {
        SlicesRuleDefinition.slices()
                .matching("pl.dkiszka.rentalapplication(*)..")
                .should().beFreeOfCycles();
    }
}
