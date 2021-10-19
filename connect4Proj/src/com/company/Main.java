package com.company;

public class Main {

    public static void main(String[] args) {
        Board boardGame = new Board();
        boardGame.printBoard();
        boardGame.addPiece(0, "X");
        boardGame.addPiece(0, "O");
        boardGame.addPiece(1, "X");
        boardGame.addPiece(2, "O");
        boardGame.addPiece(1, "X");
        boardGame.printBoard();
    }
}
