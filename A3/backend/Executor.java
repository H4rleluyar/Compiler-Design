package backend;

import intermediate.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Executor {
    private int lineNumber;

    private static HashSet<Node.NodeType> singletons;
    private static HashSet<Node.NodeType> relationals;

    static {
        singletons = new HashSet<>();
        relationals = new HashSet<>();

        singletons.add(Node.NodeType.VARIABLE);
        singletons.add(Node.NodeType.INTEGER_CONSTANT);
        singletons.add(Node.NodeType.REAL_CONSTANT);
        singletons.add(Node.NodeType.STRING_CONSTANT);
        singletons.add(Node.NodeType.NEGATE);
        singletons.add(Node.NodeType.NOT);

        relationals.add(Node.NodeType.EQ);
        relationals.add(Node.NodeType.NE);
        relationals.add(Node.NodeType.LT);
        relationals.add(Node.NodeType.AND);
        relationals.add(Node.NodeType.OR);
        relationals.add(Node.NodeType.GT);
        relationals.add(Node.NodeType.LE);
        relationals.add(Node.NodeType.GT);
        relationals.add(Node.NodeType.GE);
    }

    public Executor(Symtab symtab) {
    }

    public Object visit(Node node) {
        switch (node.type) {
            case PROGRAM:
                return visitProgram(node);

            case COMPOUND:
            case ASSIGN:
            case LOOP:
            case IF:
            case CASE:
            case WRITE:
            case WRITELN:
                return visitStatement(node);

            case TEST:
                return visitTest(node);

            default:
                return visitExpression(node);
        }
    }

    private Object visitProgram(Node programNode) {
        Node compoundNode = programNode.children.get(0);
        return visit(compoundNode);
    }

    private Object visitStatement(Node statementNode) {
        lineNumber = statementNode.lineNumber;

        switch (statementNode.type) {
            case COMPOUND:
                return visitCompound(statementNode);
            case ASSIGN:
                return visitAssign(statementNode);
            case LOOP:
                return visitLoop(statementNode);
            case IF:
                return visitIf(statementNode);
            case CASE:
                return visitCase(statementNode);
            case WRITE:
                return visitWrite(statementNode);
            case WRITELN:
                return visitWriteln(statementNode);

            default:
                return null;
        }
    }

    private Object visitCompound(Node compoundNode) {
        for (Node statementNode : compoundNode.children)
            visit(statementNode);

        return null;
    }

    private Object visitAssign(Node assignNode) {
        Node lhs = assignNode.children.get(0);
        Node rhs = assignNode.children.get(1);

        // Evaluate the right-hand-side expression;
        double value = (Double) visit(rhs);

        // Store the value into the variable's symbol table entry.
        SymtabEntry variableId = lhs.entry;
        variableId.setValue(value);

        return null;
    }

    private Object visitLoop(Node loopNode) {
        boolean b = false;
        do {
            for (Node node : loopNode.children) {
                Object value = visit(node); // statement or test

                // Evaluate the test condition. Stop looping if true.
                b = (node.type == Node.NodeType.TEST) && ((boolean) value);
                if (b)
                    break;
            }
        } while (!b);

        return null;
    }

    private Object visitTest(Node testNode) {
        return (Boolean) visit(testNode.children.get(0));
    }

    private Object visitIf(Node ifNode) {
        Node exprNode = ifNode.children.get(0);
        Node thenStmtNode = ifNode.children.get(1);
        Node elseStmtNode = ifNode.children.size() > 2 ? ifNode.children.get(2) : null;

        boolean b = (Boolean) visit(exprNode);

        if (b)
            return visit(thenStmtNode);
        else if (elseStmtNode != null)
            return visit(elseStmtNode);

        return null;
    }

    private Object visitCase(Node switchNode) {
        // Evaluate the expression.
        long value = ((Double)visit(switchNode.children.get(0))).longValue();

        // Loop over the SELECT_BRANCH subtrees to look for a value match.
        boolean foundMatch = false;
        for (int i = 1; (i < switchNode.children.size()) && !foundMatch; i++) {
            Node branchNode = switchNode.children.get(i);
            Node constantsNode = branchNode.children.get(0);

            // Loop over the branch constants.
            for (Node constantNode : constantsNode.children) {
                // Handle negative integer constants
                // Normal:      SELECT_CONSTANT -> INTEGER_CONSTANT (actual value)
                // Negative:    SELECT_CONSTANT -> NEGATE -> INTEGER_CONSTANT (positive, needs to be multiplied with -1)
                long constantValue = constantNode.type == Node.NodeType.NEGATE
                        ? (long) constantNode.getChildren().get(0).value * -1   // Constant is Negative
                        : (long) constantNode.value;                            // Constant is Positive

                // Match?
                if (value == constantValue) {
                    Node stmtNode = branchNode.children.get(1);
                    visit(stmtNode);

                    foundMatch = true;
                    break;
                }
            }
        }

        /*if (!foundMatch) {
            // Do stuff if nothing was found
        }*/

        return null;
    }

    private Object visitWrite(Node writeNode) {
        printValue(writeNode.children);
        return null;
    }

    private Object visitWriteln(Node writelnNode) {
        if (writelnNode.children.size() > 0)
            printValue(writelnNode.children);
        System.out.println();

        return null;
    }

    private void printValue(ArrayList<Node> children) {
        long fieldWidth = -1;
        long decimalPlaces = 0;

        // Use any specified field width and count of decimal places.
        if (children.size() > 1) {
            double fw = (Double) visit(children.get(1));
            fieldWidth = (long) fw;

            if (children.size() > 2) {
                double dp = (Double) visit(children.get(2));
                decimalPlaces = (long) dp;
            }
        }

        // Print the value with a format.
        Node valueNode = children.get(0);
        if (valueNode.type == Node.NodeType.VARIABLE) {
            String format = "%";
            if (fieldWidth >= 0)
                format += fieldWidth;
            if (decimalPlaces >= 0)
                format += "." + decimalPlaces;
            format += "f";

            Double value = (Double) visit(valueNode);
            System.out.printf(format, value);
        } else // node type STRING_CONSTANT
        {
            String format = "%";
            if (fieldWidth > 0)
                format += fieldWidth;
            format += "s";

            String value = (String) visit(valueNode);
            System.out.printf(format, value);
        }
    }

    private Object visitExpression(Node expressionNode) {
        // Single-operand expressions.
        if (singletons.contains(expressionNode.type)) {
            switch (expressionNode.type) {
                case VARIABLE:
                    return visitVariable(expressionNode);
                case INTEGER_CONSTANT:
                    return visitIntegerConstant(expressionNode);
                case REAL_CONSTANT:
                    return visitRealConstant(expressionNode);
                case STRING_CONSTANT:
                    return visitStringConstant(expressionNode);
                case NEGATE:
                    double value = (Double) visit(expressionNode.children.get(0));
                    return -value;
                case NOT:
                    boolean b = (Boolean) visit(expressionNode.children.get(0));
                    return !b;
                default:
                    return null;
            }
        }

        // Binary expressions.

        // Relational expressions.
        if (relationals.contains(expressionNode.type)) {
            Object value1 = visit(expressionNode.children.get(0));
            Object value2 = visit(expressionNode.children.get(1));
            boolean value = false;

            switch (expressionNode.type) {
                case EQ:
                    value = value1.equals(value2);
                    break;
                case NE:
                    value = !value1.equals(value2);
                    break;
                case LT:
                    value = (Double) value1 < (Double) value2;
                    break;
                case LE:
                    value = (Double) value1 <= (Double) value2;
                    break;
                case GT:
                    value = (Double) value1 > (Double) value2;
                    break;
                case GE:
                    value = (Double) value1 >= (Double) value2;
                    break;
                case AND:
                    value = (Boolean) value1 && (Boolean) value2;
                    break;
                case OR:
                    value = (Boolean) value1 || (Boolean) value2;
                    break;
                default:
                    break;
            }

            return value;
        }

        double value1 = (Double) visit(expressionNode.children.get(0));
        double value2 = (Double) visit(expressionNode.children.get(1));
        double value = 0.0;

        // Arithmetic expressions.
        switch (expressionNode.type) {
            case ADD:
                value = value1 + value2;
                break;
            case SUBTRACT:
                value = value1 - value2;
                break;
            case MULTIPLY:
                value = value1 * value2;
                break;

            case DIVIDE:
                if (value2 != 0.0)
                    value = value1 / value2;
                else {
                    runtimeError(expressionNode, "Division by zero");
                    return 0.0;
                }

                break;
            default:
                break;
        }

        return value;
    }

    private Object visitVariable(Node variableNode) {
        // Obtain the variable's value from its symbol table entry.
        SymtabEntry variableId = variableNode.entry;
        Double value = (Double) variableId.getValue();

        return value;
    }

    private Object visitIntegerConstant(Node integerConstantNode) {
        long value = (Long) integerConstantNode.value;
        return (double) value;
    }

    private Object visitRealConstant(Node realConstantNode) {
        return (Double) realConstantNode.value;
    }

    private Object visitStringConstant(Node stringConstantNode) {
        return (String) stringConstantNode.value;
    }

    private void runtimeError(Node node, String message) {
        System.out.printf("RUNTIME ERROR at line %d: %s: %s\n",
                lineNumber, message, node.text);
        System.exit(-2);
    }
}
