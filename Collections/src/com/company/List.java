package com.company;
 
/**
 * Created by Alexander on 13.03.17.
 */
 
public interface List<T> extends Collection<T> {
    void add(int index, T el);
    void remove(int index);
    T get(int index);
    int indexOf(T el);
    int lastIndexOf(T el);
}