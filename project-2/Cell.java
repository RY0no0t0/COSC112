// =============================================================================
/**
 * A <code>Cell</code> keeps track of its own liveness.  It also can determine
 * its own evolution by examining its neighbors and applying its survival rules.
 * This abstract class must have its <code>evolve()</code> method, which
 * implements specific rules, implemented by subclasses; it must also have its
 * own <code>toString()</code> method, determinng its own textual
 * representation.
 **/
// =============================================================================



// =============================================================================
abstract public class Cell{
// =============================================================================

    

    // =========================================================================
    // DATA MEMBERS

    /**
     * The current liveness.
     **/
    protected boolean _isAlive;

    /**
     * The liveness in the next generation.
     **/
    protected boolean _willBeAlive;

    /**
     * The <code>Grid</code> that contains this cell.
     **/
    protected Grid _grid;

    /**
     * The cell's row coordinate within its <code>Grid</code>.
     **/
    protected int _row;

    /**
     * The cell's column coordinate within its <code>Grid</code>.
     **/
    protected int _column;
    // =========================================================================



    // =========================================================================
    /**
     * Create a new cell of a given subclass.
     *
     * @param type The kind of cell---the subclass name---to create.
     * @param grid The <code>Grid</code> to which this cell belongs.
     * @param row This cell's row within the grid.
     * @param col This cell's column within the grid.
     * @return The created cell.
     **/
    public static Cell create (String type, Grid grid, int row, int col) {

	Cell cell = null;
	if (type == null) {
	    Support.debug("Cell.create(): null type provided");
	} else if (type.equals("Conway")) {
	    cell = new ConwayCell(grid, row, col);
	} else if (type.equals("Highlife")) {
	    cell = new HighlifeCell(grid, row, col);
    } else if (type.equals("Morphing")) {
	    cell = new MorphingCell(grid, row, col);
	} else {
	    Support.debug("Cell.create(): Unknown cell type = " + type);
	}

	return cell;
	
    } // create()
    // =========================================================================
    
    public Cell () {
        _isAlive = false;
    }

    // =========================================================================
    /**
     * The specialized constructor.  Create a new, initially-dead cell.
     *
     * @param grid The <code>Grid</code> that contains this cell.
     * @param row The row coordinate of this cell within its <code>Grid</code>.
     * @param column The column coordinate of this cell within its
     *               <code>Grid</code>.
     **/
    public Cell (Grid grid, int row, int column) {

	// Set the initial state to be dead.
	_isAlive = false;

	// Store the grid and the coorindates within that grid.
	_grid = grid;
	_row = row;
	_column = column;

    } // Cell()
    // =========================================================================



    // =========================================================================
    /**
     * Indicate whether this cell is currently dead or alive.
     *
     * @return <code>true</code> if the cell is alive; <code>false</code> if it
     *         is dead.
     **/
    public boolean isAlive () {

	return _isAlive;

    } // isAlive()
    // =========================================================================



    // =========================================================================
    /**
     * Set the cell to be alive.
     **/
    public void makeAlive () {

	_isAlive = true;
	
    } // makeAlive ()
    // =========================================================================

    public void makeWillAlive () {

        _willBeAlive = true;
        
        } // makeAlive ()


    // =========================================================================
    /**
     * Set the cell to be dead.
     **/
    public void makeDead () {

	_isAlive = false;
	
    } // makeDead ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the row coordinate of this cell in its <code>Grid</code>.
     *
     * @return The row coordinate of this cell.
     **/
    public int getRow () {

	return _row;

    } // getRow ()
    // =========================================================================




    // =========================================================================
    /**
     * Provide the column coordinate of this cell in its <code>Grid</code>.
     *
     * @return The column coordinate of this cell.
     **/
    public int getColumn () {

	return _column;

    } // getColumn ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide a textual representation of the cell's state.
     *
     * @return One particular character to represent liveness, another to
     *         represent deadness.  The characters chosen depend on the type of
     *         cell, and thus are determined by the subclasses.
     **/
    abstract public String toString ();
    // =========================================================================



    // =========================================================================
    /**
     * Traverse the standard neighborhood (the surrounding 8 <code>Cell</code>s
     * in the <code>Grid</code>) and count the number of neighbors that are
     * alive.
     *
     * @return The number of live neighbors in the standard neighborhood.
     **/
    protected int countLiveNeighbors () throws OffTheGridException {

	// Traverse the neighborhood and count those that are live.
	int liveNeighbors = 0;
	for (int row = _row - 1; row <= _row + 1; row += 1) {
	    for (int column = _column - 1; column <= _column + 1; column += 1) {

		// If the neighbor is not this center cell, exists, and is
		// alive, then count it.
		Cell neighbor = null;
        try {
            neighbor = _grid.getCell(row, column);
        } catch (OffTheGridException e) {
            Support.abort(row+", "+column+" outside of range that should be requested");
        }
		if ((neighbor != this) &&
		    (neighbor != null) &&
		    (neighbor.isAlive())) {

		    liveNeighbors += 1;

		}

	    } // column loop
	} // row loop

	return liveNeighbors;

    }
    // =========================================================================



    // =========================================================================
    /**
     * Evolve this cell by determinuing its state for <i>next</i> generation.
     **/
    abstract public void evolve () throws OffTheGridException;
    // =========================================================================



    // =========================================================================
    /**
     * Advance to the next generation.
     **/
    public void advance () {

	_isAlive = _willBeAlive;
	
    }
    // =========================================================================



// =============================================================================
} // class Cell
// =============================================================================
