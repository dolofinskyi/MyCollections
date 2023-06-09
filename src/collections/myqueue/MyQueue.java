package collections.myqueue;
import collections.mylist.MyLinkedList;

public class MyQueue<Key> extends MyLinkedList<Key> implements QueueInterface<Key> {
    public Key peek(){
        return get(size() - 1);
    }

    public Key poll(){
        Key lastNode = get(size() - 1);
        remove(size() - 1);
        return lastNode;
    }


}
