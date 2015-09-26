package com.gmaslowski.spock.sample;

import com.gmaslowski.spock.sample.exception.DummyNotFoundException;
import com.gmaslowski.spock.sample.repo.DummyRepository;
import com.gmaslowski.spock.sample.service.DummyService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.rules.ExpectedException.none;

public class ExpectedExceptionTest {

    private static final int NEGATIVE_ID = -1;

    @Before
    public void injectMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private DummyRepository dummyRepository;

    @Rule
    public ExpectedException expectedException = none();

    @InjectMocks
    private DummyService dummyService;

    @Test
    public void shouldNotDeactivateDummyWithNegativeId() {
        // then
        expectedException.expect(DummyNotFoundException.class);
        expectedException.expectMessage(String.format("Could not find dummy with id %d", NEGATIVE_ID));

        // when
        dummyService.dummyLogic(NEGATIVE_ID);
    }

}
