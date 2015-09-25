package com.gmaslowski.spock.sample.exception;

public class DummyNotFoundException extends RuntimeException {

    public DummyNotFoundException(String format, Object... parameters) {
        super(String.format(format, parameters));
    }
}
