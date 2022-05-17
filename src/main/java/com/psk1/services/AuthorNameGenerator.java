package com.psk1.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class AuthorNameGenerator implements NameGenerator {

    public String generateName(String name) {

        String generatedName = name + "123";
        return generatedName;
    }

}
