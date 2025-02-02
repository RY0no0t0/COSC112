public class NiceLink {

    private NiceLink _next;
    private Object   _value;

    public NiceLink () {
	_next = null;
	_value = null;
    }

    public NiceLink getNext () {
	return _next;
    }

    public void setNext (NiceLink next) {
	_next = next;
    }

    public Object getValue () {
	return _value;
    }

    public void setValue (Object value) {
	_value = value;
    }

} // class NiceLink
