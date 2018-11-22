package com.zbitnev.seabattle.ships;

import com.zbitnev.seabattle.fieald.FieldCreator;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipsTest {
    String ship = "◼";

    CoordinatesList coordinatesList = new CoordinatesList();
    FieldCreator fieldCreator = new FieldCreator(10, 10);

    @Test
    public void createShipsTest() {
        int shipIndex = 0;
        int deckCount = 20;
        Ships ships = new Ships();
        FieldCreator field = ships.createShips(fieldCreator, coordinatesList);

        for (int i = 0; i < field.getField().length; i++) {
            for (int j = 0; j < field.getField()[i].length; j++) {
                if (field.getField()[i][j].equals(ship)) {
                    shipIndex++;
                }
            }
        }
        Assert.assertEquals(deckCount, shipIndex);
    }
}