import collections.mylist.MyArrayList;
import collections.mylist.MyLinkedList;
import collections.mymap.MyHashMap;
import collections.myqueue.MyQueue;
import collections.myqueue.MyStack;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyQueue<String> queue = new MyQueue<>();
        MyStack<String> stack = new MyStack<>();
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
    }
}