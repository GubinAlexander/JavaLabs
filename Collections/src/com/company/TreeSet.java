package com.company;
 
import java.util.Iterator;
 
/**
 * Created by Alexander on 13.03.17.
 */
 
public class TreeSet<T extends Comparable<T>> implements Collection<T> {
    @SuppressWarnings("hiding")
	private class Node<T> {
        public Node<T> left;
        public Node<T> parent;
        public Node<T> right;
        public T el;
 
        public Node(T el, Node<T> left, Node<T> right, Node<T> parent) {
            @SuppressWarnings("unused")
			int [] a = new int[6];
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.el = el;
        }
 
        public boolean isLeft() {
            if (this.parent == null) {
                return false;
            } else if (this.parent.left == this) {
                return true;
            }
            return false;
        }
    }
 
    private Node<T> root; 
 
    @Override
    public void add(T el) {
        if (root == null) {
            root = new Node<T>(el, null, null, null);
        } else {
            add(root, el);
        }
    }
 
    @Override
    public void remove(T el) {
        Node<T> removeEl = findNode(root, el);
        removeNode(removeEl);
    }
 
    @Override
    public void clear() {
        root = null;
    }
 
    @Override
    public int size() {
        return size(root);
    }
 
    @Override
    public Iterator<T> getIterator() {
        return null;
    }
 
    @Override
    public boolean contains(T el) {
        if (findNode(root, el) != null) {
            return true;
        }
        return false;
    }
 
    private int size(Node<T> root) {
        if (root != null) {
            int size = 1;
            size += size(root.left);
            size += size(root.right);
            return size;
        }
        return 0;
    }
 
    @Override
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }
 
    private boolean add(Node<T> root, T el) {
        if (el.compareTo(root.el) < 0) {
            if (root.left == null) {
                root.left = new Node<>(el, null, null, root);
            } else {
                add(root.left, el);
            }
        } else if (el.compareTo(root.el) > 0) {
            if (root.right == null) {
                root.right = new Node<>(el, null, null, root);
            } else {
                add(root.right, el);
            }
        }
        return false;
    }
 
    private void removeNode(Node<T> node) {
        if (node.left == null && node.right == null) {
            if (node.isLeft()) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            node.parent = null;
        } else if (node.left == null || node.right == null) {
            if (node.left == null) {
                if (node.isLeft()) {
                    node.parent.left = node.left;
                    node.left.parent = node.parent.left;
                } else {
                    node.parent.right = node.left;
                    node.left.parent = node.parent.right;
                }
            } else {
                if (node.isLeft()) {
                    node.parent.left = node.right;
                    node.right.parent = node.parent.left;
                } else {
                    node.parent.right = node.right;
                    node.right.parent = node.parent.right;
                }
            }
        } else {
            Node<T> replace = findLeft(node.right);
            removeNode(replace);
            if (node.parent == null) {
                node.parent = null;
                root = replace;
            } else if (node.isLeft()) {
                node.parent.left = replace;
            } else {
                node.parent.right = replace;
            }
            replace.right = node.right;
            replace.left = node.left;
        }
    }
 
    private Node<T> findNode(Node<T> root, T el) {
        if (root == null) {
            return null;
        }
 
        if (el.compareTo(root.el) < 0) {
            return findNode(root.left, el);
        } else if (el.compareTo(root.el) > 0) {
            return findNode(root.right, el);
        } else {
            return root;
        }
    }
 
    private Node<T> findLeft(Node<T> root) {
        if (root.left == null) {
            return root;
        } else {
            return findLeft(root.left);
        }
    }
}