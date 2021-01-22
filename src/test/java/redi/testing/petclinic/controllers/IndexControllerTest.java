package redi.testing.petclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import redi.testing.petclinic.ControllerTests;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@Tag("controllers")
class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong value returned!");
        assertEquals("index", controller.index(), () -> "Another message: Wrong value returned!");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()),
                () -> "Values are not equal!");
    }

    @Test
    void oupsHandler_2() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler_2();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I Got here!");
        });
    }

    @Disabled("Demo of preemptively-timeout")
    @Test
    void testTimeOutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I Got here after preemptively!");
        });
    }

    @Test
    void testFalseAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU")));
    }

    @Test
    void testTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_14)
    @Test
    void testMeOnJava14() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "Brahmin")
    @Test
    void testIfUserJT() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "redi")
    @Test
    void testIfUserJohn() {
    }
}