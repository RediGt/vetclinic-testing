package redi.testing.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("modelRepeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running tests : " +
                testInfo.getDisplayName() + " - " +
                repetitionInfo.getCurrentRepetition() + " | " +
                repetitionInfo.getTotalRepetitions());
    }
}
