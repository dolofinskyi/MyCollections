package collections.myqueue;

public interface StackInterface<Key> {
    void push(Key value);
    void remove(int index);
    void clear();
    int size();
    Key peek();
    Key pop();
}
