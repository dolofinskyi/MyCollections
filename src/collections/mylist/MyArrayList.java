package collections.mylist;

public class MyArrayList <Key> implements ListInterface <Key> {

    private Key[] objects = (Key[]) new Object[0];
    public void add(Key value){

        Key[] temp = (Key[]) new Object[objects.length + 1];

        if (objects.length != 0){
            for(int i = 0; i < objects.length; i++){
                temp[i] = objects[i];
            }
        }

        temp[temp.length - 1] = value;
        objects = temp;
    }

    public void remove(int index){

        if (index < 0 || index >= size()){
            return;
        }

        Key[] firstPartArray = slice(0, index);
        Key[] secondPartArray = slice(index + 1, size());

        Key[] temp = (Key[]) new Object[firstPartArray.length + secondPartArray.length];

        int j = 0;

        for (int i = 0; i < temp.length; i++){
            if(i < firstPartArray.length){
                temp[i] = firstPartArray[i];
            } else{
                temp[i] = secondPartArray[j++];
            }
        }

        objects = temp;

    }

    public void clear(){
        objects = (Key[]) new Object[0];
    }

    public int size(){
        return objects.length;
    }

    public Key get(int index){
        try {
            return objects[index];
        } catch (Exception e){
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    private Key[] slice(int startIndex, int endIndex){

        int length = endIndex - startIndex;
        Key[] temp = (Key[]) new Object[length];

        int j = 0;

        for(int i = startIndex; i < endIndex; i++){
            temp[j++] = objects[i];
        }

        return temp;

    }

}
