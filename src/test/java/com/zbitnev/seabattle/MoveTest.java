package com.zbitnev.seabattle;

import com.zbitnev.seabattle.fieald.FieldCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {
    private String move = "x";
    private String blow = "✱";
    private String ship = "◼";
    private String dot = ".";

    FieldCreator fieldCreator = new FieldCreator(10, 10);

    @Before
    public void createFieldMarker() {
        fieldCreator.getField()[0][1] = move;
        fieldCreator.getField()[0][2] = blow;
        fieldCreator.getField()[0][3] = ship;
        fieldCreator.getField()[0][4] = dot;
    }

    @Test
    public void makeMoveTest() {
        Move move = new Move("A", 1);
        boolean moveConfirmed = move.makeMove(fieldCreator, fieldCreator);
        String moveExpect = fieldCreator.getField()[0][1];
        Assert.assertEquals(this.move, moveExpect);
        Assert.assertFalse(moveConfirmed);

        Move blowMove = new Move("A", 1);
        boolean blowConfirmed = blowMove.makeMove(fieldCreator, fieldCreator);
        String blowExpect = fieldCreator.getField()[0][2];
        Assert.assertEquals(this.blow, blowExpect);
        Assert.assertFalse(blowConfirmed);

        Move shipMove = new Move("A", 1);
        boolean shipConfirmed = shipMove.makeMove(fieldCreator, fieldCreator);
        String shipExpect = fieldCreator.getField()[0][3];
        Assert.assertEquals(this.ship, shipExpect);
        Assert.assertFalse(shipConfirmed);

        Move dotMove = new Move("A", 1);
        boolean dotConfirmed = blowMove.makeMove(fieldCreator, fieldCreator);
        String dotExpect = fieldCreator.getField()[0][4];
        Assert.assertEquals(this.dot, dotExpect);
        Assert.assertFalse(dotConfirmed);
    }
}