package pl.dkiszka.rentalapplication.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

/**
 * @author Dominik Kiszka {dominikk19}
 * @project clean-architecture-rental-app
 * @date 29.03.2021
 */
class PackageStructureTest {

    private static final String DOMAIN = "..domain..";
    private static final String JAVA = "java..";
    private static final String GOOGLE_COMMONS = "com.google.common..";
    private static final String APP = "..app..";
    private static final String ADAPTERS = "..adapters..";
    private static final String QUERY = "..query..";


    private final JavaClasses classes = RentalApplicationClasses.getJavaClasses();

    @Test
    void domain_objects_should_talk_only_with_another_domain_objects() {
        classes().that().resideInAPackage(DOMAIN)
                .should().onlyAccessClassesThat().resideInAnyPackage(DOMAIN, JAVA, GOOGLE_COMMONS)
                .check(classes);
    }

    @Test
    void app_should_talk_only_with_app_and_domain_objects() {
        classes().that().resideInAPackage(APP)
                .should().onlyAccessClassesThat().resideInAnyPackage(APP, DOMAIN, JAVA, GOOGLE_COMMONS)
                .check(classes);
    }

    @Test
    void adapters_should_not_talk_with_domain() {
        classes().that().resideInAPackage(ADAPTERS)
                .should().onlyAccessClassesThat().resideOutsideOfPackage(DOMAIN)
                .check(classes);
    }

    @Test
    void query_should_talk_only_with_query() {
        classes().that().resideInAPackage(QUERY)
                .should().onlyAccessClassesThat().resideInAnyPackage(QUERY, JAVA)
                .check(classes);
    }
}
