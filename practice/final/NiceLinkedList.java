public class NiceLinkedList <E> implements NiceData{

    private HeadSentinel<E> _head;
    private TailSentinel<E> _tail;

    private int _length;

    public NiceLinkedList () {
        _head = new HeadSentinel<>();
        _tail = new TailSentinel<>();
        _head.setNext(_tail);
        _tail.setPrev(_head);
        _length = 0;
    }

    public void insert (int index, E value) {
    
        NiceLink<E> current = new NiceLink<E>();
        current.setValue(value);

        NiceLink<E> next = walkTo(index);
        NiceLink<E> previous = next.getPrev();

        previous.setNext(current);

        current.setPrev(previous);
        current.setNext(next);

        next.setPrev(current);
        
        _length += 1;

    } // insert ()

    public E remove (int index) {
    
        NiceLink<E> current = walkTo(index);
        
        NiceLink<E> next = current.getNext();
        NiceLink<E> previous = current.getPrev();

        previous.setNext(next);
        next.setPrev(previous);
        
        // just in case
        current.setNext(null);
        current.setPrev(null);

        _length -= 1;
        return current.getValue();

    } // remove ()

    public void set (int index, E value) {
    
        NiceLink<E> current = walkTo(index);
        current.setValue(value);
    
    } // set ()

    public E get (int index) {
    
        NiceLink<E> current = walkTo(index);
        return current.getValue();
    
    } // get ()

    public int size () {
    
        return _length;
    
    } // length ()

    private NiceLink<E> walkTo (int index) {
    
        if (! (0 <= index && index <= _length)) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
    
        // Start at the head sentinel, which is conceptually before index 0.
        NiceLink<E> current = _head;
        for (int i = -1; i < index; i += 1) {
            current = current.getNext();
        }
    
        return current;
    
    } // walkTo ()
}