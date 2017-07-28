package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by davidgonzalez on 28/07/17.
 */

@RunWith(JUnitQuickcheck.class) public class KarumiHQsProperties {

    private static final String ANY_NAME = "Pedro";
    private static final int ANY_NUMBER_OF_MAXIBONS = 10;

    @Property (trials = 200)
    public void theMaxibonsLeftCannotBeLowerOrEqualThanTwo (@From(DevelopersGenerator.class)
                                                                        Developer developer) {

        KarumiHQs karumiHQs = new KarumiHQs();

        karumiHQs.openFridge(developer);

        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Property
    public void ifSomeKarumiesGoToTheKitchenTheNumberOfMaxibonsCannotBeLowerOrEqualThanTwo
            (List<@From(KarumiesGenerator.class) Developer> developers) {

        System.out.println(developers);

        KarumiHQs karumiHQs = new KarumiHQs();

        karumiHQs.openFridge(developers);

        assertTrue(karumiHQs.getMaxibonsLeft() > 2);
    }

    @Mock
    Chat chat;

    @Before
    public void setUp() {
        // Initializes all the mock anotations
        MockitoAnnotations.initMocks(this);
    }

    @Property
    public void sendMessageWhenThereAreNoMaxibonsInTheFridgeWithAnHungryDeveloper
            (@From(HungryDevelopersGenerator.class) Developer hungryDeveloper) {

        KarumiHQs karumiHQs = new KarumiHQs(chat);

        karumiHQs.openFridge(hungryDeveloper);

        verify(chat).sendMessage(anyString());
    }

    @Property
    public void sendMessageWhenThereAreNoMaxibonsInTheFridgeWithSeveralHungryDevelopers
            (List<@From(HungryDevelopersGenerator.class) Developer> hungryDevelopers) {

        KarumiHQs karumiHQs = new KarumiHQs(chat);

        karumiHQs.openFridge(hungryDevelopers);

        verify(chat).sendMessage(anyString());
    }
}
