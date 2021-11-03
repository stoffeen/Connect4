import Connect4.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




public class Testing {

    // kolla så att man bara kan skriva in 1-7
    @Test
    public void testNumbersYouCanType() {
        Board board = new Board();
        assertTrue(board.addPiece(1, "R"));
        assertFalse(board.addPiece(8, "G"));
    }

    // Check for win vertical
    @Test
    public void testVerticalWin() {
        Board board = new Board();
        for (int i = 0; i < 4; i++) {
            board.addPiece(1, "R");
        }
        assertTrue(board.checkForWinner(1, "R"));
    }

    // Check for win horizontal
    @Test
    public void testHorizontalWin() {
        Board board = new Board();
        for (int i = 1; i <= 4; i++) {
            board.addPiece(i, "R");
        }
        assertTrue(board.checkForWinner(1, "R"));
    }

    // Check for win diagonal
    @Test
    public void testDiagonalWin() {
        Board board = new Board();
        for (int j = 4; j >= 1; j--) {       // start at col 4 and goes down to 1
            for (int k = 1; k < j; k++) {    // start at 0 and goes up to j
                board.addPiece(j, "G");    // adding yellow pieces
            }
        }
        for (int i = 1; i <= 4; i++) {
            board.addPiece(i, "R");
        }
        assertTrue(board.checkForWinner(1, "R"));
    }

    // Checks so that you don't win if there's a gap
    @Test
    public void testGapNoWin() {
        Board board = new Board();
        for (int i = 1; i <= 5; i++){
            if (i != 4) {
                board.addPiece(i,"G");
            }
        }
        assertFalse(board.checkForWinner(5, "G"));
    }
}
