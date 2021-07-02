package tictactoe.playerstrategy;

import tictactoe.Grid;

public class PlayerArguments {
    public Grid grid;
    public int row;
    public int column;

    public PlayerArguments(Grid grid) {
        this.grid = grid;
    }
}
