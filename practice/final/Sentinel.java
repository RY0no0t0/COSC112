public class Sentinel <E> extends NiceLink <E> {

    public E getValue () {
        throw new WompException("Sentinel does not have a value!");
    } 

    public void setValue (E value) {
        throw new WompException("Sentinel cannot have a value!");
    }
}