package collections.mymap;

public class MyHashMap <Key, Value> implements HashMapInterface<Key, Value> {
    private static final int defaultSize = 16;
    private int size = 0;
    private final Node<Key, Value>[] table;

    private static class Node<Key, Value> {
        private Node<Key, Value> next;
        private final Key key;
        private final Value value;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

    }

    public MyHashMap(){
        this(defaultSize);
    }

    public MyHashMap(int size){
        if (size < 0)
            throw new IllegalArgumentException("Invalid capacity: " + size);

        table = new Node[size];
    }

    public void put(Key key, Value value) {
        if (key == null) return;

        int hash = hash(key);
        Node<Key, Value> newNode = new Node<Key, Value>(key, value);

        if (table[hash] == null){
            table[hash] = newNode;
        } else{
            Node<Key, Value> previous = null;
            Node<Key, Value> current = table[hash];

            while(current != null){
                if(current.key.equals(key)){
                    newNode.next = current.next;
                    if(previous==null){
                        table[hash] = newNode;
                    }
                    else{
                        previous.next = newNode;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }

            if (previous != null){
                previous.next = newNode;
            }
        }
        size++;
    }

    public boolean remove(Key key) {
        int hash = hash(key);

        if (table[hash] != null) {
            Node<Key, Value> current = table[hash];
            Node<Key, Value> previous = null;

            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){
                        table[hash] = table[hash].next;
                    } else{
                        previous.next = current.next;
                    }
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
        }
        throw new IllegalArgumentException("Invalid key: " + key);
    }

    public void clear() {
        for (int i = 0; i < table.length; i++){
            table[i] = null;
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(Key key) {
        int hash = hash(key);

        if (table[hash] != null) {
            Node<Key, Value> current = table[hash];
            while (current != null) {
                if (current.key.equals(key))
                    return current.value;
                current = current.next;
            }
        }
        throw new IllegalArgumentException("Invalid key: " + key);
    }

    private int hash(Key key){
        return Math.abs(key.hashCode()) % table.length;
    }
}
