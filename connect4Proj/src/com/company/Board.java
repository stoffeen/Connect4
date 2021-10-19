package com.company;

public class Board {

    private static int rows = 6;
    private static int columns = 7;

    Piece [][]ourBoard = new Piece[rows][columns];

    // Building the board
    public void printBoard() {
        for(int row = 0; row < rows; row++) {
            System.out.print("|");
            for(int col = 0; col < columns; col++) {
                if (ourBoard[row][col] == null) {
                    System.out.print("_");
                } else {
                    System.out.print(ourBoard[row][col].getColor());
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }


    public Board() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                ourBoard[row][col] = null;
            }
        }
    }


}
