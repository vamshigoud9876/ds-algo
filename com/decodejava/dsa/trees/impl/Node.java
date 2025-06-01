package com.decodejava.dsa.trees.impl;

public class Node<T> {
    public Node<T> left;
    public T data;
    public Node<T> right;

    public Node(Node<T> left, T data, Node<T> right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
