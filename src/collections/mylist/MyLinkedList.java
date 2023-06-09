package collections.mylist;

public class MyLinkedList <Key> implements ListInterface<Key> {
    private Node<Key> next = null;
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
    }


    public void remove(int index){

        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Invalid index.");
        }

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

    }
    public void clear(){
        next = null;
    }

    public Key get(int index){

        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Invalid index.");
        }

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

        int i = 0;

        if (next != null){
            i++;
            Node<Key> lastNode = next;
            while(lastNode.next != null){
                lastNode = lastNode.next;
                i++;
            }
        }

        return i;
    }

}
