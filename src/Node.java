/**
 * Creates a node object that stores a string value with two child Nodes (left and right)
 */
public class Node {
    /**
     * The string value of this node
     */
    public String value;
    /**
     * The left child of this node
     */
    public Node left;
    /**
     * The right child of this node
     */
    public Node right;

    /**
     * Construct a new node with the passed string value
     * @param stringValue The string value to be stored in this node
     */
    public Node(String stringValue) {
        value = stringValue;
        left = null;
        right = null;

    } // end node

} // end class
