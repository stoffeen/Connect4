package Connect4;

public class Board {

    private static final int rows = 6;
    private static final int columns = 7;

    Piece [][]ourBoard = new Piece[rows][columns];

    public static int getColumns() {
        return columns;
    }

    public boolean checkDiagonal(int row, int col, String winningColor, boolean rightDiagonal) {
        int winningStreak = 4;
        int reverser = 1;

        if(rightDiagonal) reverser = -1;

        // look at the diagonal
        for(int winRow = row - 3, winCol = col - (3 * reverser); winRow <= row + 3; winRow++, winCol += reverser) {
            if(!rightDiagonal) {
                if (winRow < 0 || winCol < 0) continue;
                if (winRow >= rows || winCol >= columns) break;
            } else {
                if(winRow < 0 || winCol >= columns) continue;
                if(winRow >= rows  || winCol < 0) break;
            }
            if(ourBoard[winRow][winCol] != null && ourBoard[winRow][winCol].getTokenColor().equals(winningColor)) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }

    public boolean checkForWinner(int col, String winningColor) {
        for(int row = 0; row < rows; row++) {
            if(ourBoard[row][col] != null) {

                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                    if(ourBoard[winRow][col].getTokenColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 3;
                }
                winningStreak = 4;

                // look at the horizontal
                for(int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;

                    if(ourBoard[row][winCol] != null && ourBoard[row][winCol].getTokenColor().equals(winningColor)) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 4;
                }

                // check left diagonal
                if(checkDiagonal(row, col, winningColor, false))
                    return true;
                // check right diagonal
                return checkDiagonal(row, col, winningColor, true);
            }
        }
        return false;

    }

    public boolean addPiece(int colToAdd, String color) {
        // within normal range
        if(colToAdd >= 0 && colToAdd < columns) {
            if(ourBoard[0][colToAdd] == null){
                boolean addedThePiece = false;
                for(int row = rows - 1; row >= 0; row--)
                    if(ourBoard[row][colToAdd] == null) {
                        ourBoard[row][colToAdd] = new Piece();
                        ourBoard[row][colToAdd].setTokenColor(color);
                        addedThePiece = true;
                        break;
                    }
                return addedThePiece;
            } else {
                // that row is full
                System.err.println("Denna kolumn är full, var god välj en annan rad.");
                return false;
            }
        } else {
            // outside normal range
            System.err.println("Du kan ej lägga ditt mynt på denna plats.");
            return false;
        }
    }

    // Building the board
    public void printBoard() {
        for(int col = 0; col < 2*columns + 1; col++) System.out.print("-");
        System.out.println();
        for(int row = 0; row < rows; row++) {
            System.out.print("|");
            for(int col = 0; col < columns; col++) {
                if (ourBoard[row][col] == null) System.out.print("_");
                else System.out.print(ourBoard[row][col].getTokenColor());
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-1-2-3-4-5-6-7-");
    }

    public Board() {
        for(int row = 0; row < rows; row++)
            for(int col = 0; col < columns; col++) ourBoard[row][col] = null;
    }
}
