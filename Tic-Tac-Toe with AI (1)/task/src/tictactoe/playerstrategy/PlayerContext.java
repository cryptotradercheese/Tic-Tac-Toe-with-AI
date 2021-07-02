package tictactoe.playerstrategy;

public class PlayerContext {
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void makeMove(PlayerArguments arguments) {
        this.player.makeMove(arguments);
    }
}
