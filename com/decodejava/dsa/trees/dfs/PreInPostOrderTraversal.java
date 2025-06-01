package com.decodejava.dsa.trees.dfs;

import com.decodejava.dsa.trees.impl.Node;

import java.util.*;

public class PreInPostOrderTraversal {
    public static void main(String[] args) {
        PreInPostOrderTraversal all = new PreInPostOrderTraversal();
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        all.allInSingleTraversal(root, preOrder, inOrder, postOrder);
        ans.add(preOrder);
        ans.add(inOrder);
        ans.add(postOrder);

        System.out.println(ans);
    }

    private void allInSingleTraversalRec(Node<Integer> root, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {
        if (root == null) return;

        preOrder.add(root.data);
        allInSingleTraversalRec(root.left, preOrder, inOrder, postOrder);
        inOrder.add(root.data);
        allInSingleTraversalRec(root.right, preOrder, inOrder, postOrder);
        postOrder.add(root.data);
    }

    private void allInSingleTraversal(Node<Integer> root, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {
        //Now mimic the same thing as recursion.
        //if node is first time visited then add it to preOrder and go left.
        //if node is second time visited then add it to inOrder and go right.
        //if node is third time visited then add it to postOrder and remove that entry from stack.

        //Same as recursion. in recursion first tym when root is visited then gets added and goes to left.
        //It comes back from left adds the root in inOrder then goes right.
        //It again comes back from right then adds the root in postOrder then removes entry from the stack.

        Stack<Pair<Node<Integer>, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<Node<Integer>, Integer> top = stack.peek();
            if (top.val == 1) {
                preOrder.add(top.key.data);
                top.val = 2;
                if (top.key.left != null)
                    stack.push(new Pair<>(top.key.left, 1));
            } else if (top.val == 2) {
                inOrder.add(top.key.data);
                top.val = 3;
                if (top.key.right != null)
                    stack.push(new Pair<>(top.key.right, 1));
            } else {
                postOrder.add(top.key.data);
                stack.pop();
            }
        }
    }

    private static class Pair<T1, T2> {
        T1 key;
        T2 val;
        Pair(T1 k, T2 v) {
            key = k;
            val = v;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}
