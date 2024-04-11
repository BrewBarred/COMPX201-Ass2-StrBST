/**
 * Constructs a Binary Search Tree that takes String values, capitalizing them and storing in lexicographical order.
 */
public class StrBST {

    /**
     * Enable to display debug messages to console while testing
     */
    boolean debug = true;
    /**
     * The root node of this tree
     */
    Node root;

    /**
     * Inserts the passed String value into the tree
     * @param s The String value to be inserted
     */
    public void insert(String s) {
        // converts the passed value to an uppercase string for simpler comparisons
        s = s.toUpperCase();

        // if the tree has no root, sets the root to a new node with the passed value
        if (root == null)
            root = new Node(s);

        // else if the passed string is not empty, calls the recursive insert method on the node to insert it into the tree
        if (!s.isEmpty())
            insert(s, root);

    } // end node

    /**
     * Inserts the passed String value into the tree using recursion
     * @param s The string value being inserted
     * @param currentNode The currentNode being processed
     * @return The current Node object being processed
     */
    public Node insert(String s, Node currentNode) {
        // if the currentNode has no value, inserts the passed value
        if (currentNode == null)
            currentNode = new Node(s);

        // if the passed value is less than zero, insert it in the left subtree
        if (s.compareTo(currentNode.value) < 0)
            currentNode.left = insert(s, currentNode.left);
        // else if the passed value is greater than zero, insert it in the right subtree
        else if (s.compareTo(currentNode.value) > 0)
            currentNode.right = insert(s, currentNode.right);
        else
            debug("Unable to add String value \"" + s + "\", value already exists!");

        return currentNode;

    } // end void

    /**
     * Recursively checks if the passed string value is contained within this tree and removes it
     * @param s The string value to remove from this tree
     */
    public void remove(String s) {
        // converts the passed value to an uppercase string for simpler comparisons
        s = s.toUpperCase();
        debug("Attempting to remove value " + s + " from this tree...");
        // if the root is not null and this value is contained within the tree
        if (root != null && search(s))
            remove(s, root);
        else
            System.out.println("Unable to remove the passed value! Value \"" + s + "\" was not found...");

    } // end void

    /**
     * Recursively checks if the passed string value is contained within this tree and removes it
     * @param s The string value to remove from this tree
     * @param currentNode The currentNode being processed
     * @return The most recent node that was manipulated/traversed
     */
    public Node remove(String s, Node currentNode) {
        // if the passed value is less than the currentNode value, traverse down the right subTree
        if (s.compareTo(currentNode.value) > 0)
            currentNode.right = remove(s, currentNode.right);
        // else if the passed value is greater than the currentNode value, traverse down the left subTree
        else if (s.compareTo(currentNode.value) < 0)
            currentNode.left = remove(s, currentNode.left);
        // else, the currentNode must be the node of interest, start removal process
        else {
            // if the current node is a leaf node, remove it from the tree
            if (currentNode.left == null && currentNode.right == null)
                currentNode = null;
            // else if the current node has 1 child, replace the current node with its child
            else if (currentNode.left == null || currentNode.right == null)
                currentNode = currentNode.right == null ? currentNode.left : currentNode.right;
            // else, the current node must have 2 children
            else {
                // finds and stores the left most node of the right subTree
                Node successor = getSuccessor(currentNode.right);
                // replaces this nodes value with the left most nodes value
                currentNode.value = successor.value;
                // traverses the rest of the tree to ensure proper deletion of the left-most node
                currentNode.right = remove(successor.value, currentNode.right);

            } // end if

        } // end if

        return currentNode;

    } // end node

    /**
     * Traverses the tree to find and return the left-most node of the passed SubTree
     * @param currentNode The currentNode being processed
     * @return The left-most Node object of the passed SubTree
     */
    public Node getSuccessor(Node currentNode) {
        if (currentNode.left == null)
            return currentNode;
        return getSuccessor(currentNode.left);

    } // end node

    /**
     * Recursively checks if the passed string value is contained within the tree
     * @param s The string value to search for in the tree
     * @return True if the value is found in this tree, else returns false
     */
    public boolean search(String s) {
        // converts the passed value to an uppercase string for simpler comparisons
        s = s.toUpperCase();
        debug("Attempting to find value " + s + "...");
        if (root == null)
            return false;

        return search(s, root);

    } // end boolean

    /**
     * Recursively checks if the passed string value is contained within the tree
     * @param s The string value to search for in the tree
     * @return True if the value is found in this tree, else returns false
     */
    public boolean search(String s, Node currentNode) {
        try {
            // if the currentNode is null, the was not found in this path
            if (currentNode == null) {
                System.out.println("Unable to find value! Value \"" + s + "\" was not found :'(");
                return false;
            // else if the currentNode contains the passed value
            } else if (s.compareTo(currentNode.value) == 0) {
                debug(" Successfully found value " + s + "!");
                print();
                return true;

            } // end if

            // if the passed value is smaller than the currentNodes value, traverse the left subtree
            if (s.compareTo(currentNode.value) < 0) {
                debug(" Finding value \"" + s + "\", currentNode value " + currentNode.value + ", traversing left subTree");
                return search(s, currentNode.left);
            }
            // else if the passed value is greater than the currentNodes value, traverse the right subtree
            else {
                debug(" Finding value \"" + s + "\", currentNode value " + currentNode.value + ", traversing right subTree");
                return search(s, currentNode.right);

            } // end if

        } catch (Exception e) {
            // gracefully catches any errors and prints stack trace info for debugging
            e.printStackTrace();
            return false;

        } // end try

    } // end void

    /**
     * Prints the out the tree following an in-order traversal with each value on a separate line.
     */
    public void print() {
        debug("Printing BST in order...");
        if (root != null)
            print(root);
        else
            System.out.println("Root: Null | Left: Null | Right: Null");

    } // end void

    /**
     * Prints each node in order from the smallest value to the largest value
     * @param currentNode The currentNode being processed
     */
    public void print(Node currentNode) {
        // prints the current nodes root and left/right child if they aren't null
        String left = currentNode.left == null ? "Null" : currentNode.left.value;
        String right = currentNode.right == null ? "Null" : currentNode.right.value;

        // traverses the left tree printing each value in-order from lowest to highest
        if (currentNode.left != null)
            print(currentNode.left);

        System.out.println("Root: " + currentNode.value + " | Left: " + left + " | Right: " + right);

        // traverses the right tree printing each value in-order from lowest to highest
        if (currentNode.right != null)
            print(currentNode.right);

    } // end node

    /**
     * Writes debug info to the console when debug mode is enabled (Hard-coded)
     * @param debugMsg The debug message to print to the console
     */
    public void debug(String debugMsg) {
        if (debug)
            System.out.println(debugMsg);

    } // end void

} // end class
