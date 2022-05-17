package com.psk1.decorators;

import com.psk1.entities.Author;
import com.psk1.services.NameGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Locale;

@Decorator
public abstract class UpperCaseAuthorNameDecorator implements NameGenerator {

    @Inject @Delegate @Any NameGenerator nameGenerator;

    public String generateName(String name) {
        String newName = nameGenerator.generateName(name);
        return newName.substring(0, 1).toUpperCase() + newName.substring(1);
    }


}
