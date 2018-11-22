package com.zbitnev.seabattle;

import com.zbitnev.seabattle.fieald.FieldCreator;
import com.zbitnev.seabattle.fieald.PrintField;
import com.zbitnev.seabattle.ships.CoordinatesList;
import org.junit.Assert;
import org.junit.Test;

public class PlayerComputerTest {
    int edge = 1;
    private String move = "x";
    private String dot = ".";

    FieldCreator fieldCreator = new FieldCreator(edge, edge);
    FieldCreator moveFieldCreator = new FieldCreator(edge, edge);
    CoordinatesList coordinatesList = new CoordinatesList();
    PlayerComputer playerComputer = new PlayerComputer();

    @Test
    public void makeMoveTest() {
        fieldCreator.getField()[0][0] = dot;
        playerComputer.makeMove(fieldCreator, coordinatesList, moveFieldCreator, edge);
        String moveExpect = fieldCreator.getField()[0][0];
        Assert.assertEquals(move, moveExpect);
    }
}