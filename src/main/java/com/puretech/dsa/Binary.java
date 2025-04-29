package com.puretech.dsa;

public class Binary {

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        class BinaryTree {
            public Node insert(Node node, int data){
                if(node == null){
                    return new Node(data);
                }
                if(data < node.data){
                    node.left = insert(node.left, data);
                }else{
                    node.right = insert(node.right, data);
                }
                return node;
            }
        }
       
    }
}
