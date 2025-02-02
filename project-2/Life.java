// =============================================================================
/**
 * The <code>Life</code> class.  This class is the entry point -- that is, it is
 * the class that is invoked on the command line to begin the creation of
 * objects used to play the game.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edu
 **/
// =============================================================================



// =============================================================================
public class Life {
// =============================================================================


    
    // =========================================================================
    /**
     * The program's entry point.
     *
     * @param args Command line arguments containing the pathname to the initial
     *             state of the universe and the number of generations to
     *             compute.
     **/
    public static void main (String[] args) throws OffTheGridException {

	// If the wrong number of arguments were passed, show the usage and
	// exit.
	if (args.length != 5) {
	    showUsageAndExit();
	}

	// Assign names to the command line arguments.
	String initialStatePathname = args[0];
	int generations = 0;
	try {
	    generations = Integer.parseInt(args[1]);
	} catch (NumberFormatException e) {
	    showUsageAndExit();
	}
	String cellType = args[2];
	String gridType = args[3];
	String uiType   = args[4];

	// Create and play the game, evolving one generation at a time.
	Game game = new Game(initialStatePathname, cellType, gridType, uiType);
	game.play(generations);

    } // main ()
    // =========================================================================



    // =========================================================================
    /**
     * Print the correct command-line usage and then exit.
     **/
    protected static void showUsageAndExit () {

	Support.abort("USAGE: java Life <initial state pathname>\n" +
		      "                 <number of generations to compute>\n" +
		      "                 <cell type [Conway | Highlife | Morphing]>\n" +
		      "                 <grid type [Bounded | WrapAround]>\n" +
		      "                 <interface type [Text | SmartText | Graphic]>");
	
    }
    // =========================================================================



// =============================================================================
} // class Life
// =============================================================================
