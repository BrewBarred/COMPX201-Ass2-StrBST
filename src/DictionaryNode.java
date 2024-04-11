/**
 * Creates a node object that stores a string value with two child Nodes (left and right)
 */
public class DictionaryNode {
    /**
     * The dictionary value of this node
     */
    public String value;
    /**
     * The definition of this dictionary value
     */
    public String definition;
    /**
     * The left child of this node
     */
    public DictionaryNode left;
    /**
     * The right child of this node
     */
    public DictionaryNode right;

    /**
     * Construct a new node with the passed string value
     * @param dictionaryValue The string value to be stored in this node
     */
    public DictionaryNode(String dictionaryValue, String dictionaryDefinition) {
        value = dictionaryValue;
        definition = dictionaryDefinition;
        left = null;
        right = null;

    } // end node

} // end class
