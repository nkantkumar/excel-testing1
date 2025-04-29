package tdd;

public class BinarySearchTree {
    private static class Node {
        int value;
        Node left, right;

        Node(int val) {
            this.value = val;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insertRec(node.left, value);
        else if (value > node.value) node.right = insertRec(node.right, value);
        return node;
    }

    public boolean contains(int value) {
        return containsRec(root, value);
    }

    private boolean containsRec(Node node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        if (value < node.value) return containsRec(node.left, value);
        else return containsRec(node.right, value);
    }
    public String inorderTraversal() {
        StringBuilder sb = new StringBuilder();
        inorderRec(root, sb);
        return sb.toString().trim();
    }

    private void inorderRec(Node node, StringBuilder sb) {
        if (node != null) {
            inorderRec(node.left, sb);
            sb.append(node.value).append(" ");
            inorderRec(node.right, sb);
        }
    }
}
