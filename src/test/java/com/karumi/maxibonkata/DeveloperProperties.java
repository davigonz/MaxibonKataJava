package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by davidgonzalez on 28/07/17.
 */


@RunWith(JUnitQuickcheck.class) public class DeveloperProperties {

    private static final String ANY_NAME = "Pedro";
    private static final int ANY_NUMBER_OF_MAXIBONS = 10;

    @Property public void theNameAssignedToTheDeveloperIsNotMutatedInConstruction (String name) {

        System.out.println(name);

        Developer developer = new Developer(name, ANY_NUMBER_OF_MAXIBONS);

        assertEquals(name, developer.getName());
    }

    @Property public void theNumberOfMaxibonsAssignedIspositiveOrZero(int numberOfMaxibons) {
        Developer developer = new Developer(ANY_NAME, numberOfMaxibons);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property public void theNameAndNumberOfMaxibonsAssignedToTheDeveloperAreNotMutatedInConstruction(
            String name, int numberOfMaxibons) {

        System.out.println(name + " " + numberOfMaxibons);

        Developer developer = new Developer(name, numberOfMaxibons);

        assertEquals(name, developer.getName());
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }
}
