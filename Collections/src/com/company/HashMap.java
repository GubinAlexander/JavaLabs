package com.company;
 
import java.util.Iterator;
 
/**
 * Created by Alexander on 13.03.17.
 */
public class HashMap<K, V> implements Map<K, V> {
    private class Node<K, V> {
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
 
        public K key;
        public V value;
    }
 
    private ArrayList<Node<K, V>>[] buckets;
    private int size;
 
    public HashMap(int size) {
        this.size = size;
        this.buckets = new ArrayList[size];
    }
 
    public int getId(int hash) {
        return  hash % size;
    }
 
    @Override
    public void put(K key, V value) {
        int id = getId(key.hashCode());
        if (buckets[id] == null) {
            buckets[id] = new ArrayList<>();
        }
        buckets[id].add(new Node<>(key, value));
    }
 
    @Override
    public void remove(K key) {
        ArrayList bucket = buckets[getId(key.hashCode())];
        if (bucket == null) {
            return;
        }
 
        Iterator<Node<K, V>> iterator = bucket.getIterator();
 
        while (iterator.hasNext()){
            Node<K, V> node = iterator.next();
            if (node.key.equals(key)) {
                bucket.remove(node);
            }
        }
    }
 
    @Override
    public void clear() {
        this.buckets = new ArrayList[size];
    }
 
    @Override
    public boolean containsKey(K key) {
        ArrayList bucket = buckets[getId(key.hashCode())];
        if (bucket == null) {
            return false;
        }
 
        Iterator<Node<K, V>> iterator = bucket.getIterator();
 
        while (iterator.hasNext()){
            if (iterator.next().key.equals(key)) {
                return  true;
            }
        }
 
        return false;
    }
 
    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            ArrayList bucket = buckets[i];
            if (bucket == null) {
                continue;
            }
 
            Iterator<Node<K, V>> iterator = bucket.getIterator();
 
            while (iterator.hasNext()){
                if (iterator.next().value.equals(value)) {
                    return  true;
                }
            }
        }
 
        return false;
    }
 
    @Override
    public V get(K key) {
        ArrayList bucket = buckets[getId(key.hashCode())];
        if (bucket == null) {
            return  null;
        }
 
        Iterator<Node<K, V>> iterator = bucket.getIterator();
 
        while (iterator.hasNext()){
            Node<K, V> node = iterator.next();
            if (node.key.equals(key)) {
                return node.value;
            }
        }
 
        return null;
    }
 
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (buckets[i] != null && buckets[i].size() != 0) {
                return false;
            }
        }
        return true;
    }
 
    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < size; i++) {
            if (buckets[i] != null) {
                size += buckets[i].size();
            }
        }
        return size;
    }
}