public class MorphingCell extends Cell {

    public MorphingCell (Grid grid, int row, int col) {

        super(grid, row, col);
        // i need this right

    }

    // define abstract methods
    public String toString () {
        if (_isAlive) {
            return "#";
        } else {
            return "^";
        }
    }

    public void evolve () throws OffTheGridException {
        if (isAlive()) {
            _willBeAlive = ((countLiveNeighbors() == 4) || (countLiveNeighbors() == 5));
        }
        else{
            if (countLiveNeighbors() == 2) {
                Cell newcell = Cell.create("Conway", _grid, _row, _column);
                newcell.makeWillAlive();
                _grid.setCell(newcell);
            } else if (countLiveNeighbors() == 3) {
                Cell newcell = Cell.create("Highlife", _grid, _row, _column);
                newcell.makeWillAlive();
                _grid.setCell(newcell);
            } else {
                _willBeAlive = false;
            }
        }
    }
}