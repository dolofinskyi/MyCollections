package collections.mylist;

interface ListInterface <Key>
{
    public void add(Key key);
    void remove(int index);
    void clear();
    int size();
    Key get(int index);

}
