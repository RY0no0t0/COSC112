// =============================================================================
/**
 * Print a variety of basic 2D patterns to the console.
 *
 * @author sfkaplan@amherst.edu
 */
public class Towers {
// =============================================================================


    // =========================================================================
    /**
     * The program's entry point.
     *
     * @param args The command-line arguments provided by the user.
     */
    public static void main (String[] args) {

	// If an incorrect number of arguments was provided on the command-line,
	// then print the correct usage and exit.
	if (args.length != 1) {
	    showUsageAndExit();
	}

	// Grab the argument.
	int rings = 0;
	try {
	    rings = Integer.parseInt(args[0]);
	} catch (NumberFormatException e) {
	    showUsageAndExit();
	}
	if (rings < 0) {
	    showUsageAndExit();
	}

	int[][] towers = initialize(rings);
	System.out.println();
	solve(towers);

    } // main()
    // =========================================================================



    // =========================================================================
    public static void solve (int[][] towers) {

	int numRings = towers[0].length;
	print(towers);
	doSolve(towers, 0, 2, 1, numRings);

    } // solve()
    // =========================================================================



    // =========================================================================
    public static void doSolve (int[][] towers, int from, int to, int other, int n) {
		if (n==0) {
			return;
		}

		else {
			// move the top rings fo what you want to move to the other bar
			doSolve(towers, from, other, to, n-1);

			// move the bottom ring to the target bar
			Move(n, from, to, towers);

			// print each step
			print(towers);

			// move the top rings from the other bar to the target bar, above the bottom ring
			doSolve(towers, other, to, from, n-1);
			
		}


    } // doSolve()
    // =========================================================================



    // =========================================================================
    public static int[][] initialize (int n) {

	int[][] towers = new int[3][n];
	for (int i = 0; i < n; i += 1) {
	    towers[0][i] = n - i;
	}

	return towers;

    } // initialize()
    // =========================================================================



    // =========================================================================
    public static void print (int[][] towers) {

	int rings = towers[0].length;
	for (int row = rings - 1; row >= 0; row -= 1) {
	    for (int tower = 0; tower < 3; tower += 1) {
		printRing(towers[tower][row], rings);
		System.out.print("\t");
	    }
	    System.out.println();
	}
	System.out.println();

    }
    // =========================================================================



    // =========================================================================

	public static void printRing (int size, int rings) {

	int spaces = rings - size;
	printChar(' ', spaces);
	printChar('=', size);
	printChar('|', 1);
	printChar('=', size);
	printChar(' ', spaces);

    }
    // =========================================================================



    // =========================================================================
    public static void printChar (char c, int reps) {

	for (int i = 0; i < reps; i += 1) {
	    System.out.print(c);
	}

    }
    // =========================================================================


	// =========================================================================
	//Moving a ring from "from" to "to"
	public static void Move (int n, int from, int to, int[][] towers) {
		int fromindx = Findn(n, from, towers);
		int toindx = Findnext(to, towers);

		if (fromindx == -1 || toindx == -1){
			System.out.println("Problem finding index");
			System.exit(1);
		}

		// moving == rewriting
		towers[from][fromindx] = 0;
		towers[to][toindx] = n;
	}
	// =========================================================================

	// =========================================================================
	// find the index value of the ring that I want to move
	public static int Findn (int n, int from, int[][] towers) {
		for (int i = 0; i<towers[from].length; i++) {
			if (towers[from][i] == n) {
				return i;
			}
		}
		return -1;
	}
	// =========================================================================


	// =========================================================================
	// find the index value of the first 0 in the bar I want to move the ring to
	public static int Findnext (int to, int[][] towers) {
		for (int i = 0; i<towers[to].length; i++) {
			if (towers[to][i] == 0) {
				return i;
			}
		}
		return -1;
	}
	// =========================================================================


    // =========================================================================
    /**
     * Print the correct form for running this program and exit with an error
     * code.
     */
    public static void showUsageAndExit () {

	System.err.println("USAGE: java Towers <number of rings>");
	System.exit(1);
	
    } // showUsageAndExit()
    // =========================================================================



// =============================================================================
} // class Towers
// =============================================================================

