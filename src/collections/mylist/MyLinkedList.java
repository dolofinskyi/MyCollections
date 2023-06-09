package collections.mylist;
import java.util.Objects;

public class MyLinkedList <Key> implements ListInterface<Key> {
    private Node<Key> next = null;
    private int size = 0;

    private static class Node<Key> {
        private Node<Key> next;
        private Node<Key> prev;
        private final Key key;

        public Node(Key key){
            this.key = key;
        }
        public Key getKey(){
            return key;
        }
    }


    public void add(Key key){
        Node<Key> nextNode = new Node<>(key);

        if (next == null){
            next = nextNode;
            nextNode.prev = null;
        } else{
            Node<Key> lastNode = next;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }

            lastNode.next = nextNode;
            nextNode.prev = lastNode;
        }

        size++;
    }


    public void remove(int index){
        Objects.checkIndex(index, size);

        int idx = 0;

        Node<Key> prevNode = null,
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

        if(nextNode != null){
            nextNode.prev = prevNode;
        }

        size--;
    }
    public void clear(){
        next = null;
        size = 0;
    }

    public Key get(int index){
        Objects.checkIndex(index, size());

        int i = 0;
        Node<Key> lastNode = next;

        while(lastNode.next != null){
            if(i++ == index){
                break;
            }
            lastNode = lastNode.next;
        }

        return lastNode.getKey();

    }

    public int size() {
        return size;
    }

}
