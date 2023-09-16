/**
 * Parse tree node class for a simple interpreter.
 * 
 * (c) 2020 by Ronald Mak
 * Department of Computer Science
 * San Jose State University
 */
package intermediate;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    public enum NodeType
    {
        PROGRAM, COMPOUND, ASSIGN, LOOP, TEST, WRITE, WRITELN,
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQ, LT,IF,NOT,SWITCH, WHILE,SELECT_BRANCH, SELECT_CONSTANTS,MODULO,INTEGER_DIVIDE, GT, NE, LE,GE,AND,OR, NEGATE, compareNodeType,
        VARIABLE, INTEGER_CONSTANT, REAL_CONSTANT, STRING_CONSTANT;

    }

    public NodeType type;
    public int lineNumber;
    public String text;
    public SymtabEntry entry;
    public Object value;
    public ArrayList<Node> children;
    
    /**
     * Constructor
     * @param type node type.
     */
    public Node(NodeType type)
    {
        this.type = type;
        this.lineNumber = 0;
        this.text = null;
        this.entry = null;
        this.value = null;
        this.children = new ArrayList<Node>();
    }
    
    /**
     * Adopt a child node.
     * @param child the child node.
     */
    public void adopt(Node child) { children.add(child); }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node copy() {
        Node copyNode = new Node(type);
        copyNode.lineNumber = lineNumber;
        copyNode.text = text;
        copyNode.entry = entry;
        copyNode.value = value;

        // Clone children and add them to the copyNode.
        for (Node child : children) {
            copyNode.adopt(child.copy());
        }

        return copyNode;
    }

    public List<Node> getChildren() {
        return children;
    }
}
