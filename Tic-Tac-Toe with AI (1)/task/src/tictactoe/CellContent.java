package tictactoe;

public enum CellContent {
    X('X'),
    O('O'),
    EMPTY(' ');

    char symbol;
    CellContent(char symbol) {
        this.symbol = symbol;
    }
}
