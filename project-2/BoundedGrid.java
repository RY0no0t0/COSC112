public class BoundedGrid extends Grid {

    public BoundedGrid (int rows, int columns, String cellType) {
        super(rows, columns, cellType);
    }

    public Cell getCell (int row, int column) throws OffTheGridException {
        // Is this cell within the known region?
        if (isOnGrid(row, column)) {
            return _grid[row][column];
        } else if (isOnBoundingFrame(row, column)) {
            Cell Zombie = new ZombieCell();
            return Zombie;
        } else {
            throw new OffTheGridException ();
        }
    }
}