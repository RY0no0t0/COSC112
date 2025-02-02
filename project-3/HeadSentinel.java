public class HeadSentinel <E> extends Sentinel <E> {
    
    public NiceLink<E> getPrev () {
	throw new RuntimeException("Cannot get prev of head sentinel");
    }

    public void setPrev (NiceLink<E> prev) {
	throw new RuntimeException("Cannot set prev of head sentinel");
    }

}
