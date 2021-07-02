package tictactoe.playerstrategy;

import java.util.Scanner;
import tictactoe.Grid;
import tictactoe.CellContent;

public class RealPlayer implements Player {
    @Override
    public void makeMove(PlayerArguments arguments) {
        Grid grid = arguments.grid;
        int row = arguments.row;
        int column = arguments.column;

        if (row < 0 || row > 2 || column < 0 || column > 2) {
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
        } else if (grid.getElement(row, column) != CellContent.EMPTY) {
            throw new IllegalArgumentException("This cell is occupied! Choose another one!");
        }

        grid.setElement(row, column, grid.getTurn());
        grid.toggleTurn();
    }
}
