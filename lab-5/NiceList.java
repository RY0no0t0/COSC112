// =============================================================================
/**
 * A <code>NiceList</code> stores values in a linear order, providing indexed
 * access.
 **/
// =============================================================================



// =============================================================================
public interface NiceList {
// =============================================================================



    // =========================================================================
    /**
     * Increase the length of the list by one, inserting the given value at the
     * given index, increasing the index of all subsequent values by one
     * position.
     *
     * @param index The position at which to insert.
     * @param value The value to insert.
     * @throws IndexOutOfBoundsException if <code>index</code> is negative, or
     *                                   if <code>index</code> is beyond the
     *                                   position immediately after the last
     *                                   valid one.
     **/
    public void insert (int index, Object value);
    // =========================================================================



    // =========================================================================
    /**
     * Reduce the length of the list by one, removing the value at the given
     * index, decreasing the index of all subsequent values by one position.
     *
     * @param index The position from which to remove.
     * @return The value at the given position.
     * @throws IndexOutOfBoundsException if <code>index</code> does not refer to
     *                                   a valid position.
     **/
    public Object remove (int index);
    // =========================================================================



    // =========================================================================
    /**
     * Set an existing position to hold a new value.
     *
     * @param index The position at which to assign a new value.
     * @param value The new value to assign.
     * @throws IndexOutOfBoundsException if <code>index</code> does not refer to
     *                                   a valid position.
     **/
    public void set (int index, Object value);
    // =========================================================================



    // =========================================================================
    /**
     * Get the value at an existing position.
     *
     * @param index The position from which to retrieve a value.
     * @returns the value at the given position.
     * @throws IndexOutOfBoundsException if <code>index</code> does not refer to
     *                                   a valid position.
     **/
    public Object get (int index);
    // =========================================================================



    // =========================================================================
    /**
     * Provide the current length of the list.
     *
     * @returns The current length of the list.
     **/
    public int length ();
    // =========================================================================



// =============================================================================
} // interface NiceList
// =============================================================================
