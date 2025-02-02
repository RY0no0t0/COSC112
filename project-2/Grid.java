// =============================================================================
/**
 * The <code>Grid</code> class.  Manage a two-dimensional collection of
 * <code>Cell</code>s.  The specific arrangement of how this grid is internally
 * stored is left to subclasses.
 **/
// =============================================================================



// =============================================================================
abstract public class Grid {
// =============================================================================


    // =========================================================================
    // DATA MEMBERS

    /**
     * The number of rows in the grid.
     **/
    protected int _rows;

    /**
     * The number of columns in the grid.
     **/
    protected int _columns;

    /**
     * The storage for the cells.
     */
    protected Cell[][] _grid;
    // =========================================================================

    public static Grid create(String gridType, int rows, int columns, String cellType) {
        Grid grid = null;
        if (gridType == null) {
            Support.debug("Grid.create(): null type provided");
        } else if (gridType.equals("Bounded")) {
            grid = new BoundedGrid(rows, columns, cellType);
        } else if (gridType.equals("WrapAround")) {
            grid = new WrapAroundGrid(rows, columns, cellType);
        } else {
            Support.debug("Grid.create(): Unknown grid type = " + cellType);
        }
    
        return grid;
    }

    // =========================================================================
    /**
     * The constructor.  Create a grid of <code>Cell</code>s, in their default
     * initial states.
     *
     * @param rows The number of rows in the known region.
     * @param columns The number of columns in the known region.
     * @param cellType The type of cell to create.
     **/
    public Grid (int rows, int columns, String cellType) {

	// Ensure that the sizes are valid.
	if ((rows <= 0) || (columns <= 0)) {
	    Support.abort("Cannot construct a grid of size " +
			  rows +
			  ", " +
			  columns);
	}

	_rows    = rows;
	_columns = columns;

	// Create the underlying storage that holds the Cells.
	_grid = new Cell[rows][columns];

	// Create the Cells, all in their default states.
	for (int row = 0; row < rows; row += 1) {
	    for (int col = 0; col < columns; col += 1) {
		setCell(Cell.create(cellType, this, row, col));
	    }
	}

    } // Grid()
    // =========================================================================

    public void setCell (Cell cell) {
        int row = cell.getRow();
        int col = cell.getColumn();
        _grid[row][col] = cell;
    }

    // =========================================================================
    /**
     * Provide the number of rows in the known region of the grid.
     *
     * @return The number of rows in the known region.
     **/
    public int getRows () {

	return _rows;

    } // getRows()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the number of columns in the known region of the grid.
     *
     * @return The number of rows in the known region.
     **/
    public int getColumns () {

	return _columns;

    } // getColumns()
    // =========================================================================



    // =========================================================================
    /**
     * Obtain the <code>Cell</code> at the given coordinates.
     *
     * @param row    The row of the requested <code>Cell</code>.
     * @param column The column of the requested <code>Cell</code>.
     * @return the cell at these coordinates.
     * @throws OffTheGridException if the coordinates not on the grid.
     **/
    abstract public Cell getCell (int row, int column) throws OffTheGridException;
    // =========================================================================



    // =========================================================================
    /**
     * Determine whether the given coordinates are on the grid proper.
     *
     * @param row    The row component of the coordinates.
     * @param column The column component of the coordinates.
     * @return <code>true</code> if the coordinates are properly on the grid;
     *         <code>false</code> otherwise.
     */
    public boolean isOnGrid (int row, int column) {

	return 0 <= row && row < _rows && 0 <= column && column < _columns;
	
    } // isOnGrid ()
    // =========================================================================



    // =========================================================================
    /**
     * Determine whether the given coordinates are in the bounding frame that is
     * ring of cells surrounding the grid proper.
     *
     * @param row    The row component of the coordinates.
     * @param column The column component of the coordinates.
     * @return <code>true</code> if the coordinates are in the bounding
     *         frame; <code>false</code> otherwise.
     */
    public boolean isOnBoundingFrame (int row, int column) {

	return row == -1 || row == _rows || column == -1 || column == _columns;
	
    } // isOnBoundingFrame ()
    // =========================================================================
    


// =============================================================================
} // class Grid
// =============================================================================
