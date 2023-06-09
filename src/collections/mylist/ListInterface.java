package collections.mylist;

interface ListInterface <Key>
{
    void add(Key key);
    void remove(int index);
    void clear();
    int size();
    Object get(int index);

}
