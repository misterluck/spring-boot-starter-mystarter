package org.demo.mystarter.autoconfigure.example01;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.mystarter.example01")
public class Example01Properties {
    public static final String DEFAULT_MESSAGE = "Hello World!";
    private String message;

    public Example01Properties() {
        this.message = DEFAULT_MESSAGE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
