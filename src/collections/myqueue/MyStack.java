package collections.myqueue;
import collections.mylist.MyLinkedList;

public class MyStack<Key> extends MyLinkedList<Key> implements StackInterface<Key> {
    public void push(Key key) { add(key); }

    public Key peek() {
        return get(0);
    }

    public Key pop(){
        Key firstNode = get(0);
        remove(0);
        return firstNode;
    }
}
