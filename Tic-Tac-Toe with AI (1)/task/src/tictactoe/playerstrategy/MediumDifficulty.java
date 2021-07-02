package tictactoe.playerstrategy;

import tictactoe.Grid;
import tictactoe.CellContent;

public class MediumDifficulty implements Difficulty {
    @Override
    public void makeMove(PlayerArguments arguments) {
        Grid grid = arguments.grid;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getElement(i, j) == CellContent.EMPTY) {
                    CellContent ourTurn = grid.getTurn();

                    grid.toggleTurn();
                    CellContent opponentTurn = grid.getTurn();
                    grid.toggleTurn();

                    // can we win on our turn
                    grid.setElement(i, j, ourTurn);
                    if (grid.linesUp(grid, ourTurn)) {
                        grid.toggleTurn();
                        return;
                    } else {
                        grid.setElement(i, j, CellContent.EMPTY);
                    }

                    // can opponent win on his turn
                    grid.setElement(i, j, opponentTurn);
                    if (grid.linesUp(grid, opponentTurn)) {
                        grid.setElement(i, j, ourTurn);
                        grid.toggleTurn();
                        return;
                    } else {
                        grid.setElement(i, j, CellContent.EMPTY);
                    }
                }
            }
        }

        EasyDifficulty easy = new EasyDifficulty();
        easy.makeMove(arguments);
    }
}
