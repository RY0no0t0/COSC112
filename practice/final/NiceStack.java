public class NiceStack <E> implements NiceData {

    private NiceLinkedList<E> _list;

    public NiceStack () {
        _list = new NiceLinkedList<>();
    }

    public void push (E value) {
        _list.insert(0, value);
    }

    public E pop () {
        return _list.remove(0);
    }

    public E top (int index) {
        return _list.get(0);
    }

    public int size () {
        return _list.size();
    }
}