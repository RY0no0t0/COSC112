public class Sentinel <E> extends NiceLink <E> {

    public E getValue () {
	throw new RuntimeException("Cannot get value at sentinel");
    }

    public void setValue (E value) {
	throw new RuntimeException("Cannot set value at sentinel");
    }

}