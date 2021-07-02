package tictactoe;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays.*;

class Main {
    private static boolean isXWinner = false;
    private static boolean isOWinner = false;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] inputs = new String[3];

        while (!"exit".equals(inputs[0])) {
            char[][] grid = setGrid();
            System.out.print("Input command: ");
            inputs = scanner.nextLine().split(" ");
            if ("exit".equals(inputs[0])) {
                continue;
            } else if (inputs.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (("easy".equals(inputs[1]) || "medium".equals(inputs[1])) && "user".equals(inputs[2])) {
                while (!isGameFinished(grid)) {
                    showResult(grid);
                    makeMoveAI(grid, inputs[1]);

                    if (!isGameFinished(grid)) {
                        showResult(grid);
                        makeMovePlayer(grid);
                    }
                }
                showResult(grid);
            } else if ("user".equals(inputs[1]) && ("easy".equals(inputs[2]) || "medium".equals(inputs[2]))) {
                while (!isGameFinished(grid)) {
                    showResult(grid);
                    makeMovePlayer(grid);

                    if (!isGameFinished(grid)) {
                        showResult(grid);
                        makeMoveAI(grid, inputs[2]);
                    }
                }
                showResult(grid);
            } else if ("easy".equals(inputs[1]) && "easy".equals(inputs[2]) ||
                    "medium".equals(inputs[1]) && "medium".equals(inputs[2]) ||
                    "easy".equals(inputs[1]) && "medium".equals(inputs[2]) ||
                    "medium".equals(inputs[1]) && "easy".equals(inputs[2])) {
                while (!isGameFinished(grid)) {
                    showResult(grid);
                    makeMoveAI(grid, inputs[1]);

                    if (!isGameFinished(grid)) {
                        showResult(grid);
                        makeMoveAI(grid, inputs[2]);
                    }
                }
                showResult(grid);
            } else if ("user".equals(inputs[1]) && "user".equals(inputs[2])) {
                while (!isGameFinished(grid)) {
                    showResult(grid);
                    makeMovePlayer(grid);
                }
                showResult(grid);
            }
        }
    }

    public static char[][] setGrid() {
        char[][] grid = new char[3][3];
        for (int i = 0, totalIteration = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, totalIteration++) {
                grid[i][j] = ' ';
            }
        }
        return grid;
    }

    public static void makeMovePlayer(char[][] grid) {
        final Scanner scanner = new Scanner(System.in);
        boolean isLegalMove = false;

        while (!isLegalMove) {
            System.out.print("Enter the coordinates: ");
            final String rowsAndColumns = scanner.nextLine();

            if (rowsAndColumns.matches("\\d \\d")) {
                final int row = Integer.parseInt(rowsAndColumns.split(" ")[0]) - 1;
                final int column = Integer.parseInt(rowsAndColumns.split(" ")[1]) - 1;
                final int xs = countXsAndOs(grid)[0];
                final int os = countXsAndOs(grid)[1];
                if (row < 0 || row > 2 || column < 0 || column > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (grid[row][column] == 'X' || grid[row][column] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (xs <= os) {
                        grid[row][column] = 'X';
                    } else if (xs > os) {
                        grid[row][column] = 'O';
                    }
                    isLegalMove = true;
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void makeMoveAI(char[][] grid, String difficulty) {
        final Random random = new Random();
        final int xs = countXsAndOs(grid)[0];
        final int os = countXsAndOs(grid)[1];

        int rand, row, column;
        do {
            rand = random.nextInt(9);
            row = rand / 3;
            column = rand % 3;
        } while (grid[row][column] != ' ');

        if ("easy".equals(difficulty)) {
            System.out.println("Making move level \"easy\"");
        } else if ("medium".equals(difficulty)) {
            System.out.println("Making move level \"medium\"");
            makeMoveAIIfTwoInLine(grid);
        }

        if (xs + os == countXsAndOs(grid)[0] + countXsAndOs(grid)[1]) {
            if (xs <= os) {
                grid[row][column] = 'X';
            } else if (xs > os) {
                grid[row][column] = 'O';
            }
        }
    }

    public static void showResult(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            String line = "| ";
            for (int j = 0; j < 3; j++) {
                line += grid[i][j] + " ";
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("---------");

        int XsAndOs = countXsAndOs(grid)[0] + countXsAndOs(grid)[1];
        if (isXWinner) {
            isXWinner = false;
            isOWinner = false;
            System.out.println("X wins");
        } else if (isOWinner) {
            isXWinner = false;
            isOWinner = false;
            System.out.println("O wins");
        } else if (XsAndOs == 9) {
            isXWinner = false;
            isOWinner = false;
            System.out.println("Draw");
        }
    }

    public static boolean isGameFinished(char[][] grid) {
        boolean isGameFinished = false;
        int XsAndOs = countXsAndOs(grid)[0] + countXsAndOs(grid)[1];

        // win either in row or in column
        for (int i = 0; i < 3; i++) {
            for (int m = 0; m < 2 && grid[i][m] == grid[i][m + 1]; m++) {
                if (m == 1) {
                    if (grid[i][m] == 'X') {
                        isXWinner = true;
                    } else if (grid[i][m] == 'O') {
                        isOWinner = true;
                    }
                }
            }

            for (int k = 0; k < 2 && grid[k][i] == grid[k + 1][i]; k++) {
                if (k == 1) {
                    if (grid[k][i] == 'X') {
                        isXWinner = true;
                    } else if (grid[k][i] == 'O') {
                        isOWinner = true;
                    }
                }
            }
        }
        // win in diagonal
        if (
                grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O' ||
                        grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O'
        ) {
            isOWinner = true;
        } else if (
                grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X' ||
                        grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X'
        ) {
            isXWinner = true;
        }

        if (isXWinner || isOWinner || XsAndOs == 9) {
            isGameFinished = true;
        }
        return isGameFinished;
    }

    public static void makeMoveAIIfTwoInLine(char[][] grid) {
        final int xs = countXsAndOs(grid)[0];
        final int os = countXsAndOs(grid)[1];

        // main diagonal
        if (grid[0][0] == grid[1][1] && grid[0][0] != ' ' && grid[2][2] == ' ' ||
                grid[1][1] == grid[2][2] && grid[1][1] != ' ' && grid[0][0] == ' ' ||
                grid[0][0] == grid[2][2] && grid[0][0] != ' ' && grid[1][1] == ' ') {
            //figure out ' ' position
            for (int i = 0; i < 3; i++) {
                if (grid[i][i] == ' ') {
                    if (xs <= os) {
                        grid[i][i] = 'X';
                    } else if (xs > os) {
                        grid[i][i] = 'O';
                    }
                }
            }
            return;
        }

        // secondary diagonal
        if (grid[0][2] == grid[1][1] && grid[0][2] != ' ' && grid[2][0] == ' ' ||
                grid[0][2] == grid[2][0] && grid[0][2] != ' ' && grid[1][1] == ' ' ||
                grid[1][1] == grid[2][0] && grid[1][1] != ' ' && grid[0][2] == ' ') {
            //figure out ' ' position
            for (int i = 0; i < 3; i++) {
                if (grid[i][2 - i] == ' ') {
                    if (xs <= os) {
                        grid[i][2 - i] = 'X';
                    } else if (xs > os) {
                        grid[i][2 - i] = 'O';
                    }
                }
            }
            return;
        }


        // rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0]  == grid[i][1] && grid[i][0] != ' ' && grid[i][2] == ' ' ||
                grid[i][0]  == grid[i][2] && grid[i][0] != ' ' && grid[i][1] == ' ' ||
                grid[i][1]  == grid[i][2] && grid[i][1] != ' ' && grid[i][0] == ' ') {
                //figure out ' ' position
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == ' ') {
                        if (xs <= os) {
                            grid[i][j] = 'X';
                        } else if (xs > os) {
                            grid[i][j] = 'O';
                        }
                    }
                }
                return;
            }
        }

        // columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i]  == grid[1][i] && grid[0][i] != ' ' && grid[2][i] == ' ' ||
                grid[0][i]  == grid[2][i] && grid[0][i] != ' ' && grid[1][i] == ' ' ||
                grid[1][i]  == grid[2][i] && grid[1][i] != ' ' && grid[0][i] == ' ') {
                //figure out ' ' position
                for (int j = 0; j < 3; j++) {
                    if (grid[j][i] == ' ') {
                        if (xs <= os) {
                            grid[j][i] = 'X';
                        } else if (xs > os) {
                            grid[j][i] = 'O';
                        }
                    }
                }
                return;
            }
        }
    }

//    public static void inputCommand() {
//        final Scanner scanner = new Scanner(System.in);
//        String input = "";
//
//        while (!"exit".equals(input)) {
//            System.out.println("Input command: ");
//            input = scanner.nextLine();
//
//            if ("start easy user".equals(input)) {
//                char[][] grid = setGrid();
//
//                while (!isGameFinished(grid)) {
//                    showResult(grid);
//                    makeMoveAI(grid);
//
//                    if (!isGameFinished(grid)) {
//                        makeMovePlayer(grid);
//                    } else {
//                        showResult(grid);
//                    }
//                }
//            } else if ("start easy easy".equals(input)) {
//                System.out.println("");
//            } else if ("start user user".equals(input)) {
//                System.out.println("");
//            } else if (!"exit".equals(input)) {
//                System.out.println("Bad parameters!");
//            }
//        }
//    }

    //auxiliary method
    public static int[] countXsAndOs(char[][] grid) {
        int xs = 0;
        int os = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') {
                    xs++;
                } else if (grid[i][j] == 'O') {
                    os++;
                }
            }
        }
        return new int[] {xs, os};
    }
}