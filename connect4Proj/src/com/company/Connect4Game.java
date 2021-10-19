package com.company;

public class Connect4Game {
    private Board board;
    private String color1;
    private String color2;

    // color for players
    public Connect4Game(String color1, String color2) {
        board = new Board();
        this.color1 = color1;
        this.color2 = color2;
    }

    public void startGame() {

    }
}
