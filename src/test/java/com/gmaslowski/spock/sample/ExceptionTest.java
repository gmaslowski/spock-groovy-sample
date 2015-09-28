package com.gmaslowski.spock.sample;

import com.gmaslowski.spock.sample.exception.DummyNotFoundException;
import com.gmaslowski.spock.sample.service.DummyService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.Assertions.assertThat;

public class ExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    DummyService dummyService = new DummyService(null);

    @Test
    public void shouldNotDeactivateDummyWithNegativeId() {
        // given
        int negativeId = -1;

        // when
        DummyNotFoundException caughtException = null;
        try {
            dummyService.dummyLogic(negativeId);
            Assert.fail("Expected dummy not to be found");
        } catch (DummyNotFoundException e) {
            caughtException = e;
        }

        // then
        assertThat(caughtException)
                .isNotNull()
                .hasMessage("Could not find dummy with id " + negativeId);
    }

    @Test(expected = DummyNotFoundException.class)
    public void shouldNotDeactivateDummyWithNegativeId2() {
        // given
        int negativeId = -1;

        // when
        dummyService.dummyLogic(negativeId);

        // then, an exception is thrown
    }

    @Test
    public void shouldNotDeactivateDummyWithNegativeId3() {
        // given
        int negativeId = -1;
        exception.expect(DummyNotFoundException.class);
        exception.expectMessage("Could not find dummy with id " + negativeId);

        // when
        dummyService.dummyLogic(negativeId);

        // then, an exception is thrown
    }
}
