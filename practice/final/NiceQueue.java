public class NiceQueue <E> implements NiceData {

    private NiceLinkedList<E> _list;

    public NiceQueue () {
        _list = new NiceLinkedList<>();
    }

    public void enqueue (E value) {
        _list.insert(0, value);
    }

    public E dequeue () {
        return _list.remove(_list.size());
    }

    public E peek (int index) {
        return _list.get(0);
    }

    public int size () {
        return _list.size();
    }
}