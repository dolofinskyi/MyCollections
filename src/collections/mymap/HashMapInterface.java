package collections.mymap;

interface HashMapInterface <Key, Value>{
    void put(Key key, Value value);
    void remove(Key key);
    void clear();
    int size();
    Object get(Key key);

}
