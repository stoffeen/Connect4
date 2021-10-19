package com.company;

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {
    private Board board;
    private String color1;
    private String color2;

    // true if player1's turn
    // false if player2's turn
    private boolean is1Playing;

    // color for players
    public Connect4Game(String color1, String color2) {
        board = new Board();
        this.color1 = color1;
        this.color2 = color2;

        is1Playing = (new Random()).nextBoolean();
    }

    public boolean checkForWinner(int column) {
        String winningColor = is1Playing ? color1 : color2;

        return board.checkForWinner(column, winningColor);
    }

    public void startGame() {
        boolean running = true;

        // turns of play
        while(running) {
            board.printBoard();
            String color;
            if(is1Playing) {
                color = color1;
                System.out.println("Spelare 1's tur");
            } else {
                color = color2;
                System.out.println("Spelare 2's tur");
            }

            System.out.println("Var god välj vilken kolumn du vill lägga ditt mynt i.");
            System.out.println("Välj mellan 1 och " + board.getColumns() + ": ");

            Scanner input = new Scanner(System.in);
            int column = input.nextInt() - 1;

            boolean succes = board.addPiece(column, color);

            if(succes) {
                if(checkForWinner(column)) {
                    running = false;
                    if(is1Playing) {
                        System.out.println("Spelare 1 vann!");
                    } else {
                        System.out.println("Spelare 2 vann!");
                    }
                }
                is1Playing = !is1Playing;
            }
        }
    }
}
