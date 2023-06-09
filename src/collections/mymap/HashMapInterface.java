package collections.mymap;

import java.security.KeyException;

public interface HashMapInterface <Key, Value>{
    void put(Key key, Value value);
    void remove(Key key) throws KeyException;
    void clear();
    int size();
    Value get(Key key);

}
