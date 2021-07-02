package tictactoe;

public class Grid {
    private CellContent[][] grid;
    private CellContent turn = CellContent.X;

    Grid() {
        setGrid();
    }

    private void setGrid() {
        this.grid = new CellContent[3][3];
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                this.grid[i][j] = CellContent.EMPTY;
            }
        }
    }

    @Override
    public Grid clone() {
        Grid newGrid = new Grid();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newGrid.setElement(i, j, grid[i][j]);
            }
        }
        return newGrid;
    }

    public GameState getGameState() {
        if (linesUp(this, CellContent.X)) {
            return GameState.X_WINS;
        } else if (linesUp(this, CellContent.O)) {
            return GameState.O_WINS;
        } else if (getXs() + getOs() == 9) {
            return GameState.DRAW;
        } else {
            return GameState.NOT_FINISHED;
        }
    }

    public boolean linesUp(Grid grid, CellContent content) {
        if (
                grid.getElement(0, 0) == content && grid.getElement(1, 1) == content && grid.getElement(2, 2) == content || // main diagonal
                grid.getElement(0, 2) == content && grid.getElement(1,1) == content && grid.getElement(2, 0) == content || // secondary diagonal
                grid.getElement(0, 0) == content && grid.getElement(0, 1) == content && grid.getElement(0, 2) == content || // row 1
                grid.getElement(1, 0) == content && grid.getElement(1, 1) == content && grid.getElement(1, 2) == content || // row 2
                grid.getElement(2, 0) == content && grid.getElement(2, 1) == content && grid.getElement(2, 2) == content || // row3
                grid.getElement(0, 0) == content && grid.getElement(1, 0) == content && grid.getElement(2, 0) == content || // column 1
                grid.getElement(0, 1) == content && grid.getElement(1, 1) == content && grid.getElement(2, 1) == content || // column 2
                grid.getElement(0, 2) == content && grid.getElement(1, 2) == content && grid.getElement(2, 2) == content    // column 3
        ) {
            return true;
        }

        return false;
    }

    public CellContent getElement(int row, int column) {
        return this.grid[row][column];
    }

    public void setElement(int row, int column, CellContent content) {
        this.grid[row][column] = content;
    }

    public CellContent getTurn() {
        return this.turn;
    }

    public void toggleTurn() {
        if (this.turn == CellContent.X) {
            this.turn = CellContent.O;
        } else if (this.turn == CellContent.O) {
            this.turn = CellContent.X;
        }
    }

    public int getXs() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == CellContent.X) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getOs() {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == CellContent.O) {
                    count++;
                }
            }
        }

        return count;
    }
}