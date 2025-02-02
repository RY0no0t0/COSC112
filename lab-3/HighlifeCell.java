public class HighlifeCell extends Cell {

    public HighlifeCell (Grid grid, int row, int col) {

        super(grid, row, col);
        // i need this right

    }

    // define abstract methods
    public String toString () {
        if (_isAlive) {
            return "*";
        } else {
            return "~";
        }
    }

    public void evolve () {
        if (isAlive()) {
            _willBeAlive = ((countLiveNeighbors() == 2) || (countLiveNeighbors() == 3));
        }
        else{
            _willBeAlive = ((countLiveNeighbors() == 6) || (countLiveNeighbors() == 3));
        }
    }

}