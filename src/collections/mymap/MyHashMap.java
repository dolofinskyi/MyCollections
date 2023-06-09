package collections.mymap;
import java.util.Objects;

public class MyHashMap <Key, Value> implements HashMapInterface<Key, Value> {
    private Node<Key, Value> next = null;
    private int size = 0;

    private static class Node<Key, Value> {
        private Node<Key, Value> next;
        private final Key key;
        private Value value;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

        public Key getKey(){
            return key;
        }

        public Value getValue(){
            return value;
        }

        public void setValue(Value value){
            this.value = value;
        }

    }

    public void put(Key key, Value value) {
        Node<Key, Value> nextNode = new Node<Key, Value>(key, value);
        Node<Key, Value> lastNode = next;

        if (next == null){
            next = nextNode;
        } else{

            while(lastNode.next != null){

                if(lastNode.getKey().equals(key)){
                    lastNode.setValue(value);
                }

                lastNode = lastNode.next;
            }

            lastNode.next = nextNode;

            if(lastNode.getKey().equals(key)){
                lastNode.setValue(value);
            }

        }

        size++;

    }

    public void remove(Key key) {
        Objects.checkIndex(getIndexByKey(key), size);

        int index = getIndexByKey(key);
        int idx = 0;

        Node<Key, Value> prevNode = null,
                         lastNode = next,
                         nextNode = null;

        while(lastNode.next != null){
            if (idx == index - 1){
                prevNode = lastNode;
            }
            if (idx == index){
                nextNode = lastNode.next;
            }
            idx++;
            lastNode = lastNode.next;

        }

        if (prevNode != null){
            prevNode.next = nextNode;
        } else {
            next = nextNode;
        }

        size--;
    }

    public void clear() {
        next = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(Key key){
        Node<Key, Value> lastNode = next;

        while(lastNode.next != null){
            if(lastNode.getKey().equals(key)){
                return lastNode.getValue();
            }
            lastNode = lastNode.next;
        }

        if(lastNode.getKey().equals(key)){
            return lastNode.getValue();
        }

        throw new IllegalArgumentException("Invalid key");
    }


    private int getIndexByKey(Key key){
        Node<Key, Value> lastNode = next;
        int i = 0;

        while(lastNode.next != null){
            if(lastNode.getKey().equals(key)){
                return i;
            }
            i++;
            lastNode = lastNode.next;
        }

        if(lastNode.getKey().equals(key)){
            return i;
        }

        throw new IllegalArgumentException("Invalid key");
    }
}
