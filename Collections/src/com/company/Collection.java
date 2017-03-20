package com.company;
 
import java.util.Iterator;
 
/**
 * Created by Alexander on 13.03.17.
 */
 
public interface Collection<T> {
    Iterator<T> getIterator();
    void add(T el);
    void remove(T el);
    void clear();
    boolean contains(T el);
    boolean isEmpty();
    int size();
}