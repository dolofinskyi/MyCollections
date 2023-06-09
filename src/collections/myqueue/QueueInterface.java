package collections.myqueue;

public interface QueueInterface<Key>{
    void add(Key key);
    void clear();
    int size();
    Key peek();
    Key poll();
}
