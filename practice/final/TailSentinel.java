public class TailSentinel <E> extends Sentinel <E> {

    public NiceLink <E> getNext () {
        throw new WompException("Head Sentinel does not have a prev!");
    } 

    public void setNext (E value) {
        throw new WompException("Head Sentinel cannot have a prev!");
    }
}