package tictactoe.playerstrategy;

import java.util.ArrayList;
import tictactoe.Grid;
import tictactoe.CellContent;

public class HardDifficulty implements Difficulty {
    @Override
    public void makeMove(PlayerArguments arguments) {
        Grid grid = arguments.grid;

        Integer[] minimax = minimax(grid, grid.getTurn());
        grid.setElement(minimax[0], minimax[1], grid.getTurn());
        grid.toggleTurn();
    }





    private Integer[] minimax(Grid grid, CellContent player) {
        grid.toggleTurn();
        CellContent huPlayer = grid.getTurn();
        grid.toggleTurn();

        CellContent aiPlayer = grid.getTurn();
        // checks for the terminal states such as win, lose, and tie
        //and returning a value accordingly
        if (grid.linesUp(grid, huPlayer)) {
            return new Integer[] {0, 0, -10};
        } else if (grid.linesUp(grid, aiPlayer)) {
            return new Integer[] {0, 0, 10};
        } else if (grid.getOs() + grid.getXs() == 9) {
            return new Integer[] {0, 0, 0};
        }

        // an array to collect all the objects
        ArrayList<Integer[]> moves = new ArrayList<>();


        // loop through available spots
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getElement(i, j) == CellContent.EMPTY) {
                    //create an object for each and store the index of that spot
                    Integer[] move = new Integer[] {i, j, 0};

                    // set the empty spot to the current player
                    grid.setElement(i, j, player);

                    /*collect the score resulted from calling minimax
                      on the opponent of the current player*/
                    if (player == aiPlayer) {
                        move[2] = minimax(grid, huPlayer)[2];
                    } else {
                        move[2] = minimax(grid, aiPlayer)[2];
                    }

                    // reset the spot to empty
                    grid.setElement(i, j, CellContent.EMPTY);

                    // push the object to the array
                    moves.add(move);
                }
            }
        }

        // if it is the computer's turn loop over the moves and choose the move with the highest score
        int bestMove = 0;

        if (player == aiPlayer) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i)[2] > bestScore) {
                    bestScore = moves.get(i)[2];
                    bestMove = i;
                }
            }
        } else {
// else loop over the moves and choose the move with the lowest score
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i)[2] < bestScore) {
                    bestScore = moves.get(i)[2];
                    bestMove = i;
                }
            }
        }

// return the chosen move (object) from the moves array
        return moves.get(bestMove);
    }
}
