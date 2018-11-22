package com.zbitnev.seabattle.ships;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesListTest {

    CoordinatesList coordinatesList = new CoordinatesList();

    @Before
    public void createCoordinateList() {
        coordinatesList.getList().get(10).setValue("Q");
        coordinatesList.getList().get(10).setFlag(false);
    }

    @Test
    public void getElementTest() {
        String example = coordinatesList.getList().get(10).getValue();
        String expected = "Q";
        String expectedEdge = ".";

        Assert.assertEquals(expected, example);
        Assert.assertEquals(expectedEdge, coordinatesList.getList().get(99).getValue());
    }

    @Test
    public void cleaningFalseValueTest() {
        coordinatesList.cleaningFalseValue();
        boolean expected = true;
        Assert.assertEquals(expected,  coordinatesList.getList().get(10).isFlag());
    }
}