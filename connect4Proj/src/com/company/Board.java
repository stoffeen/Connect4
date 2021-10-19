package com.company;

public class Board {

    private static final int rows = 6;
    private static final int columns = 7;

    Piece [][]ourBoard = new Piece[rows][columns];

    public static int getColumns() {
        return columns;
    }

    public static int getRows() {
        return rows;
    }

    public boolean checkForWinner(int col, String winningColor) {
        boolean someoneWon = false;

        for(int row = 0; row < rows; row++) {
            if(ourBoard[row][col] != null) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                    if(ourBoard[winRow][col].getColor() == winningColor) {
                        winningStreak--;
                    } else {
                        winningStreak = 3;
                    }
                }

            }
        }

        return someoneWon;

    }

    public boolean addPiece(int colToAdd, String color) {
        // within normal range
        if(colToAdd >= 0 && colToAdd < columns) {
            if(ourBoard[0][colToAdd] == null){
                boolean addedThePiece = false;
                for(int row = rows - 1; row >= 0; row--) {
                    if(ourBoard[row][colToAdd] == null) {
                        ourBoard[row][colToAdd] = new Piece();
                        ourBoard[row][colToAdd].setColor(color);
                        addedThePiece = true;
                        break;
                    }
                }
                return addedThePiece;
            } else {
                // that row is full
                System.err.println("Denna kolumn är full, var god välj en annan rad.");
                return false;
            }
        } else {
            // outside normal range
            System.out.println("Du kan ej lägga ditt mynt på denna plats.");
            return false;
        }
    }

    // Building the board
    public void printBoard() {
        for(int col = 0; col < columns + 2; col++) System.out.print("-");
        System.out.println();
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
        for(int col = 0; col < columns + 2; col++) System.out.print("-");
        System.out.println();
    }


    public Board() {
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                ourBoard[row][col] = null;
            }
        }
    }
}
