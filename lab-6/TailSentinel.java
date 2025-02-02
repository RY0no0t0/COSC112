public class TailSentinel <E> extends Sentinel <E> {

    public NiceLink<E> getNext () {
	throw new RuntimeException("Cannot get next of tail");
    }

    public void setNext (NiceLink<E> next) {
	throw new RuntimeException("Cannot set next of tail");
    }

}
