class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    Node root;

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        BST tree = new BST();

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            tree.root = tree.insert(tree.root, x);

        System.out.println("BST Inorder Traversal:");
        tree.inorder(tree.root);
    }
}