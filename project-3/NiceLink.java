public class NiceLink <E> {

    private NiceLink<E> _next;
    private NiceLink<E> _prev;
    private E           _value;

    public NiceLink () {
	_next  = null;
	_prev  = null;
	_value = null;
    }

    public NiceLink<E> getNext () {
	return _next;
    }

    public void setNext (NiceLink<E> next) {
	_next = next;
    }

    public NiceLink<E> getPrev () {
	return _prev;
    }

    public void setPrev (NiceLink<E> prev) {
	_prev = prev;
    }

    public E getValue () {
	return _value;
    }

    public void setValue (E value) {
	_value = value;
    }    

}
