package com.company;
/**
 * Created by Alexander on 13.03.17.
 */
 
public interface Map<K, V> {
    void put(K key, V value);
    void remove(K key);
    void clear();
    boolean containsKey(K key);
    boolean containsValue(V value);
    V get(K key);
    boolean isEmpty();
    int size();
}