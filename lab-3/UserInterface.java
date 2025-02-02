// =============================================================================
/**
 * The <code>UserInterface</code> for the <i>Game of Life</i>.  A
 * <code>UserInterface</code> controls the progression from one generation to
 * the next, displaying the state at each generation.
 **/
// =============================================================================



// =============================================================================
public interface UserInterface {
// =============================================================================



    // =========================================================================
    /**
     * Create a new <code>UserInterface</code> of the desired type.
     *
     * @param type A textual representation of the type of UI desired.
     * @param game The <code>Game</code> for which this UI is interacting.
     * @return The newly created <code>UserInterface</code>.
     */
    public static UserInterface create (String type, Game game) {

	UserInterface ui = null;
	if (type == null) {
	    Support.debug("UserInterface.create(): null type provided");
	} else if (type.equals("Text")) {
	    ui = new TextInterface(game);
	} else if (type.equals("Graphic")) {
	    ui = new GraphicInterface(game);
	} else {
	    Support.debug("UserInterface.create(): Unknown UI type = " + type);
	}

	return ui;
	
    } // create ()
    // =========================================================================



    // =========================================================================
    /**
     * Display the state of the <code>Cell</code>s in the <code>Grid</code>.
     */
    public void display ();
    // =========================================================================



    // =========================================================================
    /**
     * Keep control of the program until it is time to advance the state of the
     * <code>Game</code>.
     */
    public void triggerMove ();
    // =========================================================================



// =============================================================================
} // class UserInterface
// =============================================================================
