package collections.mylist;
import java.util.Objects;

public class MyArrayList <Key> implements ListInterface <Key> {
    private static final int defaultSize = 10;
    private Object[] objects;
    private int size = 0;

    public MyArrayList(){
        this(defaultSize);
    }

    public MyArrayList(int size){
        if (size < 0){
            throw new IllegalArgumentException("Invalid capacity");
        }
        objects = new Object[size];
    }

    public void add(Key value){
        if (size >= objects.length){
            resizeArray(objects.length * 2);
        }
        objects[size++] = value;
    }

    private void resizeArray(int newSize){
        Object[] newArray = new Object[newSize];
        System.arraycopy(objects, 0, newArray, 0, size);
        objects = newArray;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);
        for (int i = 0; i < size - 1; i++){
            if (i >= index){
                objects[i] = objects[i + 1];
            }
        }
        objects[size - 1] = null;
        size--;
    }

    public int size(){
        return size;
    }

    public void clear(){
        objects = new Object[defaultSize];
        size = 0;
    }

    public Object get(int index){
        Objects.checkIndex(index, size);
        return objects[index];
    }
}
