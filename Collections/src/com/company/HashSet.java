package com.company;
 
import java.util.Iterator;
 
/**
 * Created by Alexander on 13.03.17.
 */
public class HashSet<T> implements Collection<T> {
    private HashMap<T, T> map;
 
    public static final int FIED_SIZE = 10;
 
    public HashSet() {
        this.map = new HashMap<T, T>(FIED_SIZE);
    }
 
    @Override
    public Iterator<T> getIterator() {
        return null;
    }
 
    @Override
    public void add(T el) {
        this.map.put(el, null);
    }
 
    @Override
    public void remove(T el) {
        this.map.remove(el);
    }
 
    @Override
    public void clear() {
        this.map.clear();
    }
 
    @Override
    public boolean contains(T el) {
        return this.map.containsKey(el);
    }
 
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
 
    @Override
    public int size() {
        return this.map.size();
    }
}