/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */


// Binary Search Tree (BST) class
public class BST<T> {
    private BSTNode<T> root, current;
    public int count = 0;

    // Constructor initializes an empty BST
    public BST() {
        root = current = null;
        
    }

    // Check if the tree is empty
    public boolean empty() {
        return root == null;
    }

    // Check if the tree is full (not relevant in basic BST, hence returns false)
    public boolean full() {
        return false;
    }

    // Retrieve the current node's data
    public T retrieve() {
        return current.data;
    }
    public boolean findKey1(String k) {
    BSTNode<T> p = root;
    while (p != null) {
        count++;
        current = p;
        if (k.compareToIgnoreCase(p.key) == 0) {
            return true;
        } else if (k.compareToIgnoreCase(p.key) < 0) {
            p = p.left;
        } else {
            p = p.right;
        }
    }
    return false;
}

    // Find a node by key and set the current node if found
    public boolean findKey(String k) {
    BSTNode<T> p = root;
    while (p != null) {
        current = p;
        if (k.compareToIgnoreCase(p.key) == 0) {
            return true;
        } else if (k.compareToIgnoreCase(p.key) < 0) {
            p = p.left;
        } else {
            p = p.right;
        }
    }
    return false;
}


    // Insert a new key-value pair in the BST
    public boolean insert(String k, T val) {
    if (root == null) {
        current = root = new BSTNode<T>(k, val);
        return true;
    }

    BSTNode<T> p = current;
    if (findKey(k)) {
        current = p;
        return false;
    }

    BSTNode<T> tmp = new BSTNode<T>(k, val);
    if (k.compareToIgnoreCase(current.key) < 0) {
        current.left = tmp;
    } else {
        current.right = tmp;
    }
    current = tmp;
    return true;
}


    // Remove a node by key
    public boolean removeKey(String k) {
        String k1 = k;
        BSTNode<T> p = root;
        BSTNode<T> q = null; // Parent of p
        
        while( p != null){
            if(k1.compareTo(p.key) < 0){
                q = p ; 
                p = p.left;
            } else if (k1.compareTo(p.key) > 0) {
                q = p;
                 p = p.right;
            } else {
                if( (p.left != null) && (p.right != null) ){
                
                    BSTNode<T> min = p.right;
                
                q = p ;
                while ( min.left != null ){
                    q = min ;
                    min = min.left;
                }
                
                p.key = min.key;
                p.data = min.data;
                k1 = min.key;
                p = min;
            }
                
                if (p.left != null)
                    p = p.left;
                else
                    p = p.right;
                
                if(q == null)
                    root = p ;
                else {
                    
                    if (k1.compareToIgnoreCase(q.key) < 0)
                        q.left = p ;
                    else 
                        q.right = p;
                        
                }
                
                current = root;
                return true;
                    
                
            }
                
                
        }
        
        return false;
    }

    // Helper method to delete a node
    private void deleteNode(BSTNode<T> p, BSTNode<T> q) {
        if (p.left == null && p.right == null) { // Case 1: Leaf node
            if (q.left == p) {
                q.left = null;
            } else {
                q.right = null;
            }
        } else if (p.left != null && p.right == null) { // Case 2: Node has left child
            if (q.left == p) {
                q.left = p.left;
            } else {
                q.right = p.left;
            }
        } else if (p.left == null && p.right != null) { // Case 2: Node has right child
            if (q.left == p) {
                q.left = p.right;
            } else {
                q.right = p.right;
            }
        }
    }

// Definition for a Binary Search Tree Node
    public class BSTNode<T> {
    public String key;
    public T data;
    public BSTNode<T> left, right;

    // Constructor for node creation with key and value
    public BSTNode(String k, T val) {
        key = k;
        data = val;
        left = right = null;
    }

    // Constructor with left and right children
    public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {
        key = k;
        data = val;
        left = l;
        right = r;
    }
}
}

