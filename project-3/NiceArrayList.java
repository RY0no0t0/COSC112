// =============================================================================
public class NiceArrayList<E> implements NiceList<E> {
// =============================================================================



    // =========================================================================
    // DATA MEMBERS

    /**
     * Pointer to the storage array.  We are not allowed to have a generic
     * array, so we will have to do the casting ourselves in the relevant
     * methods.
     **/
    private Object[] _array;

    /**
     * The current number of elements in the list.  To be maintained
     * at all times.
     **/
    private int _length;
    // =========================================================================




    // =========================================================================
    /**
     * The default constructor.  Creates an empty list.
     */
    public NiceArrayList () {

	_array  = new Object[1];
	_length = 0;

    } // NiceArrayList ()
    // =========================================================================



    // =========================================================================
    public void insert (int index, E value) {

	_length += 1;
	boundsCheck(index);
	
	if (_length == _array.length) {
	    growArray();
	}
	    
	for (int i = _length - 1; i > index; i -= 1) {
	    _array[i] = _array[i - 1];
	}
	
	_array[index] = value;

    } // insert ()
    // =========================================================================



    // =========================================================================
    public E remove (int index) {

	boundsCheck(index);

	Object removed = _array[index];
	for (int i = index; i < _length - 1; i +=1) {
	    _array[i] = _array[i + 1];
	}
	
	_length -= 1;
	return (E)removed;

    } // remove ()
    // =========================================================================



    // =========================================================================
    public void set (int index, E value) {

	boundsCheck(index);
	_array[index] = value;

    } // set ()
    // =========================================================================



    // =========================================================================
    public E get (int index) {

	boundsCheck(index);
	return (E)_array[index];

    } // get ()
    // =========================================================================



    // =========================================================================
    public int length () {

	return _length;

    } // length ()
    // =========================================================================



    // =========================================================================
    private void growArray () {

	Object[] old = _array;
	_array = new Object[old.length * 2];

	for (int i = 0; i < old.length; i += 1) {
	    _array[i] = old[i];
	}
	
    } // growArray ()
    // =========================================================================



    // =========================================================================
    private void boundsCheck (int index) {

	if (! (0 <= index && index < _length)) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

    } // boundsCheck ()
    // =========================================================================



// =============================================================================
} // class NiceArrayList <E>
// =============================================================================
