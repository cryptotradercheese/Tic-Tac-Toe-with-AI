package tictactoe;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: ");
            String[] inputs = scanner.nextLine().split(" ");
            if ("exit".equals(inputs[0])) {
                return;
            } else if (inputs.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            ConsoleGame game = new ConsoleGame(inputs[1], inputs[2]);
            game.printGrid();

            while (game.getGameState() == GameState.NOT_FINISHED) {
                game.makeMove();
                game.printGrid();
            }
        }
    }
}