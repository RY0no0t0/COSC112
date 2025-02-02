// =============================================================================
/**
 * The <code>SmartTextUserInterface</code> for the <i>Game of Life</i>.
 * Displays the state of a Game of Life by a drawing, in a consistent location
 * on a controllable terminal, a textual representation of the cells.
 **/
// =============================================================================




// =============================================================================
public class SmartTextInterface implements UserInterface {
// =============================================================================



    // =========================================================================
    /**
     * The constructor.  Hold onto a pointer to the <code>Game</code> for which
     * this <code>SmartTextInterface</code> is providing interaction.
     *
     * @param game The <code>Game</code> whose state to draw.
     **/
    public SmartTextInterface (Game game) {

	_game = game;

    } // SmartTextInterface ()
    // =========================================================================



    // =========================================================================
    /**
     * Display the state of the <code>Cell</code>s in the <code>Grid</code>.
     **/
    public void display () throws OffTheGridException {

	// Provide generation and population counts.
	System.out.printf("Generation = %4d, Population = %4d\n",
			  _game.getGeneration(),
			  _game.getPopulation());

	// Provide a textual representation of the grid of cells themselves.
	for (int row = 0; row < _game.getRows(); row += 1) {
	    for (int column = 0; column < _game.getColumns(); column += 1) {

		Cell cell = _game.getCell(row, column);
		System.out.print(cell);

	    }

	    // Move to a new line for the next row.
	    System.out.println();

	}

	System.out.println();
	System.out.printf("\u001b[%dF", _game.getRows() + 2);

    } // display ()
    // =========================================================================



    // =========================================================================
    /**
     * Keep control of the program until it is time to advance the state of the
     * <code>Game</code>.
     **/
    public void triggerMove () {

	try {
	    Thread.sleep(500);
	} catch (InterruptedException e) {
	    Support.abort("SmartTextInterface.triggerMove(): Unexpected interruption");
	}
	
    }
    // =========================================================================



    // =========================================================================
    // DATA MEMBERS

    /**
     * The <code>Game</code> that this interface is controlling.
     */
    private Game _game;
    // =========================================================================



// =============================================================================
} // class SmartTextInterface
// =============================================================================
