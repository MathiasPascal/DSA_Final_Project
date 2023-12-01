package RestaurantReservationSystem;

/**
 * This class represents a node in a binary search tree. A node has a table and
 * left and right children. The table is the data stored in the node. The left
 * and right children are the nodes that are less than and greater than the node
 * respectively.
 */

/*
 * The time complexity of the Node class methods is O(1),
 * which means they have constant time complexity. This is because the methods
 * perform
 * a fixed number of operations, regardless of the size of the input.
 */
class Node {
    private Table table;
    private Node left;
    private Node right;

    public Node(Table table) {
        this.table = table;
        left = null;
        right = null;
    }

    public Table getTable() {
        return table;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node other = (Node) o;
            return table.equals(other.getTable());
        } else {
            return false;
        }
    }
}

/*
 * The time complexity of the insert, delete, search, and inorder methods in the
 * BinarySearchTree class is O(log n), where n is the number of nodes in the
 * tree. This is because these methods recurse down the tree to find the desired
 * node or perform the desired operation, and the number of recursive calls
 * depends on the height of the tree, which is logarithmic in the number of
 * nodes in the tree (if the tree is balanced). The space complexity of these
 * methods is also O(log n), because the recursive calls consume space on the
 * call stack.
 */
public class BinarySearchTree {
    private Node root;

    /**
     * // The time complexity of the BinarySearchTree constructor is O(1)
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    public void insert(Table table) { 
        root = insert(root, table);
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    private Node insert(Node node, Table table) { 
        if (node == null) {
            node = new Node(table);
        } else {
            if (table.getCapacity() <= node.getTable().getCapacity()) {
                node.setLeft(insert(node.getLeft(), table));
            } else {
                node.setRight(insert(node.getRight(), table));
            }
        }
        return node;
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    public void delete(int tableNumber) {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            if (!search(tableNumber)) {
                System.out.println("Table not found");
            } else {
                root = delete(root, tableNumber);
                System.out.println("Table deleted");
            }
        }
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    private Node delete(Node node, int tableNumber) { 
        if (node == null) {
            return null;
        }

        if (tableNumber < node.getTable().getCapacity()) {
            node.setLeft(delete(node.getLeft(), tableNumber));
        } else if (tableNumber > node.getTable().getCapacity()) {
            node.setRight(delete(node.getRight(), tableNumber));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setTable(minValue(node.getRight()).getTable());
            node.setRight(delete(node.getRight(), node.getTable().getCapacity()));
        }
        return node;
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    private Node minValue(Node node) { 
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    public boolean search(int tableNumber) { 
        return search(root, tableNumber);
    }

    /**
     * // The time complexity of the insert function is O(log n)
     */
    private boolean search(Node node, int tableNumber) { 
        if (node == null) {
            return false;
        }

        int nodeTableNumber = node.getTable().getCapacity();
        if (tableNumber < nodeTableNumber) {
            return search(node.getLeft(), tableNumber);
        } else if (tableNumber > nodeTableNumber) {
            return search(node.getRight(), tableNumber);
        } else {
            return true;
        }
    }

    public void inorder() {
        inorder(root);
    }

    /**
     * // The time complexity of the inorder method is O(n)
     */
    private void inorder(Node node) { 
        if (node != null) {
            inorder(node.getLeft());
            System.out.println(node.getTable().getCapacity() + " ");
            inorder(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }
}
