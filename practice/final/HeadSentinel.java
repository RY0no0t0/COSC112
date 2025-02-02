public class HeadSentinel <E> extends Sentinel <E> {

    public NiceLink <E> getPrev () {
        throw new WompException("Head Sentinel does not have a prev!");
    } 

    public void setPrev (E value) {
        throw new WompException("Head Sentinel cannot have a prev!");
    }
}