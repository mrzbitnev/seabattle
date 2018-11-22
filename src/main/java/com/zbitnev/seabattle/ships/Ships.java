package com.zbitnev.seabattle.ships;

import com.zbitnev.seabattle.fieald.FieldCreator;
import com.zbitnev.seabattle.fieald.PlantField;

import java.util.*;

/**
 * the class Ships is determines the number of ships;
 * return String [][] battleField;
 *
 * @author Ivan Zbitnev
 * @version 1.0
 */
public class Ships {
    public FieldCreator createShips(FieldCreator battleFieldCreator, CoordinatesList coordinatesList) {
        Queue<Integer> queueShip = new LinkedList<>(Arrays.asList(4, 3, 3, 2, 2, 2, 1, 1, 1, 1));
        ShipCreator shipCreator = new ShipCreator();
        PlantField plantFieald = new PlantField();

        int deckCount;
        while (queueShip.peek() != null) {
            deckCount = queueShip.peek();
            if (shipCreator.setShip(coordinatesList, deckCount)) {
                queueShip.remove();
            }
        }
        plantFieald.getPlant(battleFieldCreator.getField(), coordinatesList);
        shipCreator.setShip(coordinatesList, 4);
        return battleFieldCreator;
    }
}