package com.zbitnev.seabattle.fieald;

/**
 * the class PrintField just output String [][] battlefield with String [][] moveField;
 *
 * @author Ivan Zbitnev
 * @version 1.0
 */
public class PrintField {
    public static void printField(String[][] battlefield, String[][] moveChronologyField) {
        System.out.println("       Battlefield            Movefield");
        printNumeralScale();
        int alphabeticIndex = 65;
        for (int i = 0; i < battlefield.length; i++) {
            System.out.println(" ");
            System.out.print((char) alphabeticIndex + " ");
            for (int j = 0; j < battlefield[i].length; j++) {
                System.out.print(battlefield[i][j] + " ");
            }
            System.out.print("  ");
            System.out.print((char) alphabeticIndex++ + " ");
            for (int j = 0; j < moveChronologyField[i].length; j++) {
                System.out.print(moveChronologyField[i][j] + " ");
            }
        }
    }

    static void printNumeralScale() {
        System.out.print("  ");
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.print("   ");
        }
    }
}