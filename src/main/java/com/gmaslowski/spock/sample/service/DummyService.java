package com.gmaslowski.spock.sample.service;

import com.gmaslowski.spock.sample.entity.Dummy;
import com.gmaslowski.spock.sample.exception.DummyNotFoundException;
import com.gmaslowski.spock.sample.repo.DummyRepository;

public class DummyService {

    private DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Dummy dummyLogic(int dummyId) {
        throwExceptionWhenDummyIdIsNegative(dummyId);
        Dummy dummy = dummyRepository.getDummyById(dummyId);
        dummy.deactivate();

        return dummy;
    }

    private void throwExceptionWhenDummyIdIsNegative(int dummyId) {
        if(dummyId < 0) {
            throw new DummyNotFoundException("Could not find dummy with id %d", dummyId);
        }
    }

    public Dummy evenDummierLogic(int dummyId) {
        dummyRepository.getDummyById(dummyId);
        return dummyRepository.getDummyById(dummyId);
    }
}
