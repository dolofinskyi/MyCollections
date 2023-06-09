package collections.mylist;
import java.util.Objects;

public class MyArrayList <Key> implements ListInterface <Key> {

    private static final int defaultSize = 10;
    private int initialSize;
    private Object[] objects;

    public MyArrayList(){
        this(defaultSize);
    }

    public MyArrayList(int size){

        if (size < 0){
            throw new IllegalArgumentException("Invalid capacity");
        }

        objects = new Object[initialSize = size];

    }


    public void add(Key value){

        if (size() + 1 > initialSize){

            Object[] temp = new Object[initialSize *= 2];
            System.arraycopy(objects, 0, temp, 0, objects.length);

            temp[objects.length] = value;
            objects = temp;


        } else {
            objects[size()] = value;
        }


    }

    public void remove(int index){

        if (Objects.checkIndex(index, size()) == -1){
            throw new IndexOutOfBoundsException();
        }

        Object[] temp;

        if (size() > initialSize){
            temp = new Object[objects.length - 1];
        } else{
            temp = new Object[objects.length];
        }

        int j = 0;

        for (int i = 0; i < temp.length; i++){
            if (index != i)
                temp[j++] = objects[i];
        }

        objects = temp;

    }

    public void clear(){
        objects = new Object[0];
    }

    public int size(){

        int i = 0;

        for (Object object: objects) {
            if (object != null)
                i++;
        }

        return i;

    }

    public Object get(int index){

        if (Objects.checkIndex(index, size()) == -1){
            throw new IndexOutOfBoundsException();
        }

        return objects[index];
    }

}
