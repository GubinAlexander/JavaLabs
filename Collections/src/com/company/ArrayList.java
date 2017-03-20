package com.company;
 
import java.util.Iterator;
 
/**
 * Created by Alexander on 13.03.17.
 */
 
public class ArrayList<T> implements List<T> {
    private class Node<T> {
        public T el;
        public Node<T> next;
 
        public Node(T el, Node<T> next) {
            this.el = el;
            this.next = next;
        }
    }
 
    @SuppressWarnings("hiding")
	private class ArrayListIterator<T> implements Iterator<T> {
        private Node<T> iterator;
 
        public ArrayListIterator(Node<T> iterator) {
            this.iterator = iterator;
        }
 
        @Override
        public boolean hasNext() {
            return iterator != null;
        }
 
        @Override
        public T next() {
            T el = iterator.el;
            iterator = iterator.next;
            return el;
        }
    }
 
    private Node<T> head;
    private int size;
 
    @Override
    public Iterator<T> getIterator() {
        if (size != 0) {
            return new ArrayListIterator<T>(head);
        } else {
            return null;
        }
    }
 
    @Override
    public void add(T el) {
        if (size == 0) {
            head = new Node<>(el, null);
        } else {
            head = new Node<>(el, head);
        }
        size++;
    }
 
    @Override
    public void add(int index, T el) {
        if (index >= size) {
            return;
        }
 
        if (index == 0) {
            add(el);
        }
 
        Node<T> iterator = head;
        for (int i = 0; i < index; iterator = iterator.next);
 
        iterator.next = new Node<T>(el, iterator.next.next);
        size++;
    }
 
    @Override
    public void remove(T el) {
        if (size == 0) {
            return;
        }
        if (el.equals(head.el)) {
            head = head.next;
            return;
        }
 
        Node<T> iterator = head;
        while (iterator.next.el != el) {
            iterator = iterator.next;
            if (iterator.next == null) {
                return;
            }
        }
 
        iterator.next = iterator.next.next;
        size--;
    }
 
    @Override
    public void clear() {
        size = 0;
        head = null;
    }
 
    @Override
    public void remove(int index) {
        if (index >= size && index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
 
        Node<T> iterator = head;
        for (int i = 0; i < index; iterator = iterator.next);
 
        iterator.next = iterator.next.next;
        size--;
    }
 
    @Override
    public boolean contains(T el) {
        Iterator<T> iterator = getIterator();
 
        while (iterator.hasNext()) {
            if (iterator.next().equals(el)) {
                return true;
            }
        }
 
        return true;
    }
 
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return  null;
        }
 
        Iterator<T> iterator = getIterator();
 
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
 
        return iterator.next();
    }
 
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return  true;
        }
        return false;
    }
 
    @Override
    public int indexOf(T el) {
        Iterator<T> iterator = getIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            if (iterator.next().equals(el)) {
                return i;
            }
        }
 
        return -1;
    }
 
    @Override
    public int size() {
        return size;
    }
 
    @Override
    public int lastIndexOf(T el) {
        Iterator<T> iterator = getIterator();
        int last = -1;
        for (int i = 0; iterator.hasNext(); i++) {
            if (iterator.next().equals(el)) {
                last = i;
            }
        }
 
        return last;
    }
}