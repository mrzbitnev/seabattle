package com.zbitnev.seabattle.fieald;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FieldCreaterTest {

    //String [][] arr = new String[5][5];

    FieldCreator fieldCreater = new FieldCreator(5, 5);

    @Before
    public void create() {
        for (int i = 0; i < fieldCreater.getField().length; i++) {
            for (int j = 0; j < fieldCreater.getField()[i].length; j++) {
                fieldCreater.getField()[i][j] = "q";
            }
        }
        fieldCreater.changeCell(2,2, "◼");
    }

    @Test
    public void getFieldTest() {
        String [][] arr = fieldCreater.getField();
        Assert.assertEquals(arr.length, fieldCreater.getField().length);
    }

    @Test
    public void checkFieldWinnerTest() {
        boolean result = fieldCreater.checkFieldWinner();
        boolean expect = false;
        Assert.assertEquals(expect, result);

        fieldCreater.changeCell(2,2, "q");
        boolean resultTrue = fieldCreater.checkFieldWinner();
        boolean expectTrue = true;
        Assert.assertEquals(expectTrue, resultTrue);
    }

    @Test
    public void changeCellTest() {
        fieldCreater.changeCell(2,2, "q");
        boolean result = fieldCreater.checkFieldWinner();
        boolean expect = true;
        Assert.assertEquals(expect, result);
    }

    @Test
    public void getCellTest() {
        String example = fieldCreater.getCell(2,2);
        String expect = "◼";
        Assert.assertEquals(example,expect);

        String exampleZero = fieldCreater.getCell(11,9);
        String expectZero = "zero";
        Assert.assertEquals(exampleZero, expectZero);
    }
}