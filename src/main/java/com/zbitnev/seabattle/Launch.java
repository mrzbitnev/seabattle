package com.zbitnev.seabattle;

import com.zbitnev.seabattle.fieald.FieldCreator;
import com.zbitnev.seabattle.fieald.PrintField;
import com.zbitnev.seabattle.ships.CoordinatesList;
import com.zbitnev.seabattle.ships.Ships;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * the class Launch is main class, causes all methods, creates a field and a
 * coordinate sheet, determines the order of moves;
 *
 * @author Ivan Zbitnev
 * @version 1.0
 */
public class Launch {
    private String regexNumber = "[0-9]+";
    private String regexAlphabetic = "[A-J]";
    private String movePlayer = "";
    private int fieldSize = 10;
    private int indexcheckfield = 0;
    private boolean auto = false;
    FieldCreator moveFieldCreatorPlayer1 = new FieldCreator(fieldSize, fieldSize);
    FieldCreator battleFieldCreatorPlayer1 = new FieldCreator(fieldSize, fieldSize);
    FieldCreator moveFieldCreatorPlayer2 = new FieldCreator(fieldSize, fieldSize);
    FieldCreator battleFieldCreatorPlayer2 = new FieldCreator(fieldSize, fieldSize);
    Ships ships = new Ships();
    PlayerComputer playerComputer = new PlayerComputer();
    CoordinatesList coordinatesListPlayer1 = new CoordinatesList();
    CoordinatesList coordinatesListPlayer2 = new CoordinatesList();

    public void getLaunch() {
        System.out.println("Greetings Admiral, the fleet is ready to attack.\n" +
                "To select a goal, enter the letter from A to J and the number from 1 to 10.\n");
        ships.createShips(battleFieldCreatorPlayer1, coordinatesListPlayer1);
        ships.createShips(battleFieldCreatorPlayer2, coordinatesListPlayer2);

        PrintField.printField(battleFieldCreatorPlayer1.getField(), moveFieldCreatorPlayer1.getField());
        coordinatesListPlayer1.cleaningFalseValue();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                this.indexcheckfield++;
                if (indexcheckfield > 20) {
                    if (battleFieldCreatorPlayer2.checkFieldWinner()) {
                        System.out.println("Victory is yours admiral, congratulations");
                        break;
                    }
                    if (battleFieldCreatorPlayer1.checkFieldWinner()) {
                        System.out.println("Yarrr! The enemies have won, try your luck again ");
                        break;
                    }
                }
                System.out.print("\nMake a move: ");
                movePlayer = bufferedReader.readLine();

                if (movePlayer == null || movePlayer.equals("")) {
                    System.out.println("Do not be afraid to strike - the enemy will not spare you!");
                } else if (movePlayer.length() <= 3) {
                    String first = movePlayer.substring(0, 1);
                    String second = movePlayer.substring(1);

                    if (first.matches(regexAlphabetic) & second.matches(regexNumber)) {
                        Integer secondCoordinate = Integer.valueOf(second);

                        Move move = new Move(first, secondCoordinate - 1);
                        if (move.makeMove(battleFieldCreatorPlayer2, moveFieldCreatorPlayer1)) {
                            playerComputer.makeMove(battleFieldCreatorPlayer1, coordinatesListPlayer1,
                                    moveFieldCreatorPlayer2, fieldSize);

                            PrintField.printField(battleFieldCreatorPlayer1.getField(), moveFieldCreatorPlayer1.getField());
                        } else {
                            System.out.println("It's your turn again:");
                        }
                    } else {
                        System.out.println("First the letter from A to J and the number from 1 to 10.");
                    }
                } else if (movePlayer.equals("exit")) {
                    bufferedReader.close();
                    System.out.println("GoodBye");
                    break;
                } else {
                    System.out.println("String is too short or too large, please try gain");
                }
            }
        } catch (IOException e) {
            System.err.println("Something wrong is occurred with, pleas try again" + e);
        }
    }
}
