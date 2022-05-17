package com.psk1.services;

import javax.enterprise.inject.Specializes;

@Specializes
public class SlowAuthorNameGenerator extends AuthorNameGenerator {

    public String generateName(String name) {
        try {
            Thread.sleep(1000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        String generatedName = name + "123";
        return generatedName;
    }
}
