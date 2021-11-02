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
    // kolla så att man vinner ifall man har 4 i rad vertikalt
    @Test
    public void testVerticalWin(){
        Board board = new Board();
        for(int i = 0; i < 4; i++) {
            board.addPiece(1, "R");
        }
        assertTrue(board.checkForWinner(1,"R"));
    }
    // kolla så att man vinner ifall man har 4 i rad horisontelt
    @Test
    public void testHorizontalWin(){
        Board board = new Board();
        for(int i = 1; i <= 4; i++) {
            board.addPiece(i, "R");
        }
        assertTrue(board.checkForWinner(1,"R"));
    }
    // kolla så att man vinner ifall man har 4 i rad diagonalt
    @Test
    public void testDiagonalWin() {
        Board board = new Board();
        for (int i = 1; i <= 4; i++) {
            board.addPiece(i, "R");
        }
        assertTrue(board.checkForWinner(1, "R"));
    }
    // kolla så att det blir rätt spelares tur
}
