public class WrapAroundGrid extends Grid {

    public WrapAroundGrid (int rows, int columns, String cellType) {
        super(rows, columns, cellType);
    }

    public Cell getCell (int row, int column) throws OffTheGridException {
        if (isOnGrid(row, column)) {
            return this._grid[row][column];
        } else if (isOnBoundingFrame(row, column)) {
            if (row == -1 || row == _rows) {
                row = _rows-Math.abs(row);
            }
            if (column == -1 || column == _columns) {
                column = _columns-Math.abs(column);
            }
            return _grid[row][column];
        } else{
            throw new OffTheGridException ();
        }

    }
}