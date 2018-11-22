package com.zbitnev.seabattle.ships;

/**
 * the class Coordinates is main class in field, for created ships;
 *
 * @author Ivan Zbitnev
 * @version 1.0
 */
public class Coordinates {
    private int x;
    private int y;
    private String value;
    private boolean flag = true;
    private boolean target = false;

    public Coordinates(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }
}