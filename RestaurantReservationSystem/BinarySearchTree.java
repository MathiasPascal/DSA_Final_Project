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

    /**
     * Constructs a new Node object with the specified table.
     * Has a time complexity of O(1) because it performs a fixed number of
     * operations
     * regardless of the input.
     * 
     * @param table
     */
    public Node(Table table) {
        this.table = table;
        left = null;
        right = null;
    }

    /**
     * Returns the table stored in the node.
     * Has a time complexity of O(1) because it performs one operation (returning
     * the table)
     * 
     * @return the table stored in the node
     */
    public Table getTable() {
        return table;
    }

    /**
     * Returns the left child of the node.
     * Has a time complexity of O(1) because it performs one operation (returning
     * the left child)
     * 
     * @return the left child of the node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Returns the right child of the node.
     * Has a time complexity of O(1) because it performs one operation (returning
     * the right child)
     * 
     * @return the right child of the node
     */
    public Node getRight() {
        return right;
    }

    /**
     * Sets the table stored in the node.
     * Has a time complexity of O(1) because it performs one operation (setting the
     * table)
     * 
     * @param table the table to be stored in the node
     */
    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * Sets the left child of the node.
     * Has a time complexity of O(1) because it performs one operation (setting the
     * left child)
     * 
     * @param left the left child of the node
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Sets the right child of the node.
     * Has a time complexity of O(1) because it performs one operation (setting the
     * right child)
     * 
     * @param right the right child of the node
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Returns a string representation of the node.
     * Has a time complexity of O(1) because it performs one operation (returning
     * the string representation)
     * 
     * @return a string representation of the node
     */
    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node other = (Node) o;
            return table.equals(other.getTable());
        } else {
            return false;
        }
    }
}

/**
 * This class represents a binary search tree. A binary search tree is a binary
 * tree where the left child of a node is less than the node and the right child
 * of
 * a node is greater than the node. This class has methods to insert, delete,
 * and
 * search for a node in the tree. It also has a method to print the tree in
 * inorder traversal order.
 * 
 * The time complexity of the insert, delete, search, and inorder methods in the
 * BinarySearchTree class is O(log n), where n is the number of nodes in the
 * tree. This is because these methods recurse down the tree to find the desired
 * node or perform the desired operation, and the number of recursive calls
 * depends on the height of the tree, which is logarithmic in the number of
 * nodes in the tree (if the tree is balanced). At each step in the recursion,
 * the algorithms seem to divide the tree in half, which is why the time
 * complexity
 * is logarithmic in the number of nodes in the tree. The worst case time
 * complexity of these methods is O(n), which occurs when the tree is unbalanced
 * and the algorithms must recurse through all the nodes in the tree.
 */
public class BinarySearchTree {
    private Node root;

    /**
     * The time complexity of the BinarySearchTree constructor is O(1).
     * This is because it performs a fixed number of operations every time it is
     * called (setting the root to null).
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * The time complexity of the insert function is O(log n) where n is the number
     * of nodes in the tree. This is because the insert method calls the private
     * insert method, which recurses down the tree to find the correct place to
     * insert the node. The dominant operation in the insert method is the
     * recursive call to the private insert method, which is called once for each
     * level of the tree. Since the tree is balanced, the height of the tree is
     * logarithmic in the number of nodes in the tree, so the insert method has a
     * time complexity of O(log n).
     */
    public void insert(Table table) {
        root = insert(root, table);
    }

    /**
     * The time complexity of the insert function is O(log n)
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
     * The time complexity of the insert function is O(log n). This is because the
     * delete method calls the private delete method, which recurses down the tree
     * to find the node to delete. At each step in the recursion, the algorithm
     * seems to divide the tree in half, which is why the time complexity is
     * logarithmic in the number of nodes in the tree. As such, at each step, the
     * input size
     * is divided by 2^k, where k is the number of steps in the recursion. This
     * resolves to
     * n/2^k, where n is the number of nodes in the tree. This makes the time
     * complexity
     * logarithmic in the number of nodes in the tree (O(log n)).
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
     * The time complexity of the insert function is O(log n). This is because the
     * delete method calls the private delete method, which recurses down the tree
     * to find the node to delete. At each step in the recursion, the algorithm
     * seems to divide the tree in half, which is why the time complexity is
     * logarithmic in the number of nodes in the tree. As such, at each step, the
     * input size is divided by 2^k, where k is the number of steps in the
     * recursion. This resolves to n/2^k, where n is the number of nodes in the
     * tree. This makes the time complexity logarithmic in the number of nodes in
     * the tree (O(log n)).
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
     * The time complexity of the minValue method is O(log n). This is because the
     * minValue method recurses down the tree to find the minimum value. It
     * recursively
     * calls the getLeft method, which recurses down the tree to find the leftmost
     * node. As such, it runs as many times as the height of the tree, which makes
     * the time
     * complexity O(h) where h is the height of the tree. The height of the tree is
     * logarithmic in the number of nodes in the tree, so the time complexity is
     * logarithmic in the number of nodes in the tree (O(log n)).
     */
    private Node minValue(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    /**
     * The time complexity of the search function is O(log n).
     * This is because the search method calls the private search method, which
     * recurses down the tree to find the node. At each step in the recursion, the
     * algorithm seems to divide the tree in half, which is why the time complexity
     * is logarithmic in the number of nodes in the tree. As such, at each step, the
     * input size is divided by 2^k, where k is the number of steps in the
     * recursion.
     * This resolves to n/2^k, where n is the number of nodes in the tree. This
     * makes
     * the time complexity logarithmic in the number of nodes in the tree (O(log
     * n)).
     */
    public boolean search(int tableNumber) {
        return search(root, tableNumber);
    }

    /**
     * The time complexity of the search function is O(log n).
     * This is because the search method recurses down the tree to find the node.
     * At each step in the recursion, the algorithm seems to divide the tree in
     * half,
     * which is why the time complexity is logarithmic in the number of nodes in the
     * tree. As such, at each step, the input size is divided by 2^k, where k is the
     * number of steps in the recursion. This resolves to n/2^k, where n is the
     * number of nodes in the tree. This makes the time complexity logarithmic in
     * the
     * number of nodes in the tree (O(log n)).
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

    /**
     * The time complexity of the inorder method is O(n), where n is the number of
     * nodes in the tree. This is because the inorder method calls the private
     * inorder method, which recurses down the tree to print the nodes in order.
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * The time complexity of the inorder method is O(n).
     * This is because the inorder method recurses down the tree to print the nodes. Starting
     * 
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
