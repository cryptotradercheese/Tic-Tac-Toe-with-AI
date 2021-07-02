package tictactoe;

public abstract class Game {
    protected Grid grid = new Grid();
    private String firstPlayer;
    private String secondPlayer;
    protected String currentPlayer;

    public Game(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = firstPlayer;
    }

    public void toggleCurrentPlayer() {
        if (currentPlayer == firstPlayer) {
            currentPlayer = secondPlayer;
        } else if (currentPlayer == secondPlayer) {
            currentPlayer = firstPlayer;
        }
    }

    public GameState getGameState() {
        return grid.getGameState();
    }
}