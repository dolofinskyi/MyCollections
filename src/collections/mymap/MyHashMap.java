package collections.mymap;

import java.security.KeyException;

public class MyHashMap <Key, Value> implements HashMapInterface<Key, Value> {

    private Node<Key, Value> next = null;
    private Node<Key, Value>[] nodes = new Node[0];

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

        int newLength = nodes.length + 1;

        Node<Key, Value>[] temp = new Node[newLength];
        Node<Key, Value> nextNode = new Node<>(key, value);

        if (nodes.length == 0){
            nodes = temp;
        } else{
            for (int i = 0; i < nodes.length; i++){
                temp[i] = nodes[i];
            }
        }

        Node<Key, Value> node = temp[0];

        if (node == null){
            next = nextNode;
            temp[0] = next;
            nodes = temp;
        } else{

            while(node.next != null){

                if (node.getKey().equals(key)){
                    node.setValue(value);
                    return;
                }

                node = node.next;

            }

            if (node.getKey().equals(key)){
                node.setValue(value);
                return;
            }

            node.next = nextNode;

            temp[newLength - 1] = node.next;

            nodes = temp;

        }

    }

    public void remove(Key key) {

        int index = getIndex(key);

        if (index == -1){
            return;
        }

        Node<Key, Value>[] ftemp = slice(0, index);
        Node<Key, Value>[] stemp = slice(index + 1, nodes.length);


        Node<Key, Value> prevNode = null,
                lastNode = next,
                nextNode = null;

        int idx = 0;

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
        } else{
            next = nextNode;
        }

        int newLength = ftemp.length + stemp.length;
        Node<Key, Value>[] temp = new Node[newLength];

        int j = 0;

        for (int i = 0; i < temp.length; i++){

            if(i < ftemp.length){
                temp[i] = ftemp[i];
            } else{
                temp[i] = stemp[j++];
            }

        }

        nodes = temp;

    }

    public void clear() {
        next = null;
        nodes = new Node[0];
    }

    public int size() {
       return nodes.length;
    }

    public Value get(Key key){

        for(Node<Key, Value> node: nodes){
            if (node.getKey().equals(key)){
                return node.getValue();
            }
        }

        return null;

    }


    private int getIndex(Key key){

        int i = 0;

        for(Node<Key, Value> node: nodes){
            if (node.getKey().equals(key)){
                return i;
            }
            i++;
        }

        return -1;

    }

    private Node[] slice(int startIndex, int endIndex){

        int newLength = endIndex - startIndex;

        Node<Key, Value>[] temp = new Node[newLength];

        int j = 0;

        for (int i = startIndex; i < endIndex; i++){
            temp[j++] = nodes[i];
        }

        return temp;

    }

}
