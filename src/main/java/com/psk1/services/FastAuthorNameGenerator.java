package com.psk1.services;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class FastAuthorNameGenerator implements NameGenerator {

    public String generateName(String name) {

        String generatedName = name + "456";
        return generatedName;
    }
}
