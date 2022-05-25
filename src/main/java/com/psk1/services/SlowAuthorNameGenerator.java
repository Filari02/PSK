package com.psk1.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
public class SlowAuthorNameGenerator extends AuthorNameGenerator {

    public String generateName(String name) {
        try {
            Thread.sleep(100000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        String generatedName = name + "123";
        return generatedName;
    }
}
