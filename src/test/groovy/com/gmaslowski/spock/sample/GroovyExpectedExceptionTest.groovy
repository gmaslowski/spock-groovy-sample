package com.gmaslowski.spock.sample

import com.gmaslowski.spock.sample.exception.DummyNotFoundException
import com.gmaslowski.spock.sample.repo.DummyRepository
import com.gmaslowski.spock.sample.service.DummyService
import spock.lang.Specification

class GroovyExpectedExceptionTest extends Specification {

    def dummyRepository = Mock(DummyRepository)

    def dummyService = new DummyService(dummyRepository)

    def "should not deactivate dummy with negative id"() {
        setup:
        def negativeId = -1

        when:
        dummyService.dummyLogic(negativeId)

        then:
        def thrownException = thrown(DummyNotFoundException)
        thrownException.message == "Could not find dummy with id $negativeId"
    }
}