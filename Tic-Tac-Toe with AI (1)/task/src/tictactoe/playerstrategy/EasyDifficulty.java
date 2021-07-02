package tictactoe.playerstrategy;

import java.util.Random;
import tictactoe.Grid;
import tictactoe.CellContent;

public class EasyDifficulty implements Difficulty {
    @Override
    public void makeMove(PlayerArguments arguments) {
        Grid grid = arguments.grid;
        final Random random = new Random();
        System.out.println("Making move level \"easy\"");

        int row;
        int column;
        do {
            int rand = random.nextInt(9);
            row = rand / 3;
            column = rand % 3;
        } while (grid.getElement(row, column) != CellContent.EMPTY);

        grid.setElement(row, column, grid.getTurn());
        grid.toggleTurn();
    }
}
