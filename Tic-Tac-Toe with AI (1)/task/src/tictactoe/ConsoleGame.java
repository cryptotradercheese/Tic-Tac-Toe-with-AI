package tictactoe;

import java.util.Scanner;
import tictactoe.playerstrategy.*;

public class ConsoleGame extends Game {
    private Scanner scanner = new Scanner(System.in);
    private PlayerContext context = new PlayerContext();
    private PlayerArguments arguments = new PlayerArguments(grid);

    public ConsoleGame(String firstPlayer, String secondPlayer) {
        super(firstPlayer, secondPlayer);
    }

    public void makeMove() {
        switch (currentPlayer) {
            case "easy":
                context.setPlayer(new EasyDifficulty());
                context.makeMove(arguments);
                break;
            case "medium":
                context.setPlayer(new MediumDifficulty());
                context.makeMove(arguments);
                break;
            case "hard":
                context.setPlayer(new HardDifficulty());
                context.makeMove(arguments);
                break;
            case "user":
                while (true) {
                    System.out.print("Enter the coordinates: ");
                    String rowsAndColumns = scanner.nextLine();

                    if (rowsAndColumns.matches("\\d \\d")) {
                        int row = Integer.parseInt(rowsAndColumns.split(" ")[0]) - 1;
                        int column = Integer.parseInt(rowsAndColumns.split(" ")[1]) - 1;
                        arguments.row = row;
                        arguments.column = column;

                        context.setPlayer(new RealPlayer());
                        context.makeMove(arguments);
                        break;
                    } else {
                        System.out.println("You should enter numbers!");
                    }
                }

                break;
        }

        toggleCurrentPlayer();
    }

    public void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            String line = "| ";
            for (int j = 0; j < 3; j++) {
                line += grid.getElement(i, j).symbol + " ";
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---------");
    }

    public GameState getGameState() {
        GameState gameState = super.getGameState();

        if (gameState == GameState.X_WINS) {
            System.out.println("X wins");
        } else if (gameState == GameState.O_WINS) {
            System.out.println("O wins");
        } else if (gameState == GameState.DRAW) {
            System.out.println("Draw");
        }

        return gameState;
    }
}