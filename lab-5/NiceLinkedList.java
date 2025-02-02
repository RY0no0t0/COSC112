// =============================================================================
public class NiceLinkedList implements NiceList {
// =============================================================================



    // =========================================================================
    // DATA MEMBERS

    /**
     * Pointer to the head link.
     **/
    private NiceLink _head;

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
    public NiceLinkedList () {

	_head   = null;
	_length = 0;

    } // NiceLinkedList ()
    // =========================================================================



    // =========================================================================
    public void insert (int index, Object value) {

        NiceLink current = new NiceLink();
        current.setValue(value);
    
        if (index == 0) {
            current.setNext(_head);
            _head = current;
        } else {

            NiceLink previous = walkTo(index-1);

            current.setNext(previous.getNext());

            previous.setNext(current);
        }
        
        _length += 1;

    } // insert ()
    // =========================================================================



    // =========================================================================
    public Object remove (int index) {

        NiceLink current = walkTo(index);
        
        if (index == 0) {
            _head = walkTo(1);
        } else {
            NiceLink previous = walkTo(index-1);
            previous.setNext(current.getNext());
        }
        
        // just in case
        current.setNext(null);

        _length -= 1;
        return current.getValue();

    } // remove ()
    // =========================================================================



    // =========================================================================
    public void set (int index, Object value) {

	NiceLink current = walkTo(index);
	current.setValue(value);

    } // set ()
    // =========================================================================



    // =========================================================================
    public Object get (int index) {

	NiceLink current = walkTo(index);
	return current.getValue();

    } // get ()
    // =========================================================================



    // =========================================================================
    public int length () {

	return _length;

    } // length ()
    // =========================================================================



    // =========================================================================
    private NiceLink walkTo (int index) {

	if (! (0 <= index && index < _length)) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	NiceLink current = _head;
	for (int i = 0; i < index; i += 1) {
	    current = current.getNext();
	}

	return current;

    } // walkTo ()
    // =========================================================================

    // public String toString() {
    //     String toReturn = "[";
    //     NiceLink c = _head;
    //     while (c != null) {
    //         toReturn += c.getValue();
    //         toReturn += ", ";
    //         c = c.getNext();
    //     }
    //     toReturn += "]";
    //     return toReturn;
    // }

// =============================================================================
} // NiceLinkedList <E>
// =============================================================================
