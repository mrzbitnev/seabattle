package com.zbitnev.seabattle.fieald;

import com.zbitnev.seabattle.ships.CoordinatesList;

/**
 * the class PlantField is load coordinateList with coordinate in String[][] field;
 *
 * @author Ivan Zbitnev
 * @version 1.0
 */
public class PlantField {
    public String[][] getPlant(String[][] field, CoordinatesList coordinatesList) {
        for (int i = 0; i < coordinatesList.getList().size(); i++) {
            int x = coordinatesList.getList().get(i).getX();
            int y = coordinatesList.getList().get(i).getY();
            field[x][y] = coordinatesList.getList().get(i).getValue();
        }
        return field;
    }
}