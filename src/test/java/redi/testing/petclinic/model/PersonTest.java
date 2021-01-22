package redi.testing.petclinic.model;

import org.junit.jupiter.api.*;
import redi.testing.petclinic.ModelTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertThat(person.getLastName()).isEqualTo("Buck"));
    }

    @Test
    void groupedAssertions_2() {
        //given
        Person person = new Person(1L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(),"First Name failed!"),
                () -> assertThat(person.getLastName()).isEqualTo("Buck"));
    }
}