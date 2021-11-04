package Connect4;

import java.util.Random;
import java.util.Scanner;

public class Connect4Game {
    private Board board;
    private String colorRed;
    private String colorYellow;

    // true if it's player1's turn
    // false if it's player2's turn
    private boolean is1Playing;

    // color for the players
    public Connect4Game(String color1, String color2) {
        board = new Board();
        this.colorRed = color1;
        this.colorYellow = color2;

        is1Playing = (new Random()).nextBoolean();
    }

    public boolean checkForWinner(int column) {
        String winningColor;

        if(is1Playing) {
            winningColor = colorRed;
        } else {
            winningColor = colorYellow;
        }

        return board.checkForWinner(column, winningColor);
    }

    public void reset() {
        this.board = new Board();
        is1Playing = (new Random()).nextBoolean();
    }

    public void startGame() {
        boolean running = true;

        // turns of play
        while(running) {
            board.printBoard();
            String color;
            if(is1Playing) {
                color = colorRed;
                System.out.println("Spelare 1(Röd) tur ");
            } else {
                color = colorYellow;
                System.out.println("Spelare 2(Gul) tur ");
            }

            System.out.println("Välj en kolumn som du vill lägga ditt mynt i.");
            System.out.println("Välj mellan 1 och " + Board.getColumns() + ": ");

            Scanner input = new Scanner(System.in);
            int column = input.nextInt() - 1;

            boolean succes = board.addPiece(column, color);

            // check for winner
            if(succes) {
                if(checkForWinner(column)) {
                    board.printBoard();
                    if(is1Playing) {
                        System.out.println("Spelare 1 (Röd) vann!");
                    } else {
                        System.out.println("Spelare 2 (Gul) vann!");
                    }

                    // Reset, asking if you want to play again
                    System.out.println("Vill du spela igen?");
                    System.out.println("Tryck J för Ja, N för Nej: ");
                    Scanner input2 = new Scanner(System.in);
                    String playAgain = input2.nextLine();
                    if(playAgain.equalsIgnoreCase("j")) {
                        reset();
                    } else {
                        running = false;
                    }
                }
                is1Playing = !is1Playing;
            }
        }
    }
}
