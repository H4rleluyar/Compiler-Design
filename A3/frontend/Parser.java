/**
 * Parser class for a simple interpreter.
 *
 * (c) 2020 by Ronald Mak
 * Department of Computer Science
 * San Jose State University
 */
package frontend;

import java.util.HashSet;

import intermediate.*;
import static frontend.Token.TokenType.*;
import static intermediate.Node.NodeType.*;

public class Parser {
    private Scanner scanner;
    private Symtab symtab;
    private Token currentToken;
    private int lineNumber;
    private int errorCount;

    public Parser(Scanner scanner, Symtab symtab) {
        this.scanner = scanner;
        this.symtab = symtab;
        this.currentToken = null;
        this.lineNumber = 1;
        this.errorCount = 0;
    }

    public int errorCount() {
        return errorCount;
    }

    public Node parseProgram() {
        Node programNode = new Node(Node.NodeType.PROGRAM);

        currentToken = scanner.nextToken(); // first token!

        if (currentToken.type == Token.TokenType.PROGRAM) {
            currentToken = scanner.nextToken(); // consume PROGRAM
        } else
            syntaxError("Expecting PROGRAM");

        if (currentToken.type == IDENTIFIER) {
            String programName = currentToken.text;
            symtab.enter(programName);
            programNode.text = programName;

            currentToken = scanner.nextToken(); // consume program name
        } else
            syntaxError("Expecting program name");

        if (currentToken.type == SEMICOLON) {
            currentToken = scanner.nextToken(); // consume ;
        } else
            syntaxError("Missing ;");

        if (currentToken.type != BEGIN)
            syntaxError("Expecting BEGIN");

        // The PROGRAM node adopts the COMPOUND tree.
        programNode.adopt(parseCompoundStatement());

        if (currentToken.type != PERIOD)
            syntaxError("Expecting .");
        return programNode;
    }

    private static HashSet<Token.TokenType> statementStarters;
    private static HashSet<Token.TokenType> statementFollowers;
    private static HashSet<Token.TokenType> relationalOperators;
    private static HashSet<Token.TokenType> simpleExpressionOperators;
    private static HashSet<Token.TokenType> termOperators;

    static {
        statementStarters = new HashSet<Token.TokenType>();
        statementFollowers = new HashSet<Token.TokenType>();
        relationalOperators = new HashSet<Token.TokenType>();
        simpleExpressionOperators = new HashSet<Token.TokenType>();
        termOperators = new HashSet<Token.TokenType>();

        // Tokens that can start a statement.
        statementStarters.add(BEGIN);
        statementStarters.add(IDENTIFIER);
        statementStarters.add(REPEAT);
        statementStarters.add(Token.TokenType.WRITE);
        statementStarters.add(Token.TokenType.WRITELN);
        statementStarters.add(Token.TokenType.WHILE);
        statementStarters.add(Token.TokenType.IF);
        statementStarters.add(Token.TokenType.FOR);
        statementStarters.add(Token.TokenType.CASE);

        // Tokens that can immediately follow a statement.
        statementFollowers.add(SEMICOLON);
        statementFollowers.add(END);
        statementFollowers.add(UNTIL);
        statementFollowers.add(END_OF_FILE);

        relationalOperators.add(EQUALS);
        relationalOperators.add(NOT_EQUALS);
        relationalOperators.add(LESS_THAN);
        relationalOperators.add(LESS_EQUALS);
        relationalOperators.add(GREATER_THAN);
        relationalOperators.add(GREATER_EQUALS);

        simpleExpressionOperators.add(PLUS);
        simpleExpressionOperators.add(MINUS);
        simpleExpressionOperators.add(Token.TokenType.OR);

        termOperators.add(STAR);
        termOperators.add(SLASH);
        termOperators.add(DIV);
        termOperators.add(MOD);
        termOperators.add(Token.TokenType.AND);
    }

    private Node parseStatement() {
        Node stmtNode = null;
        int savedLineNumber = currentToken.lineNumber;
        lineNumber = savedLineNumber;

        switch (currentToken.type) {
            case IDENTIFIER:
                stmtNode = parseAssignmentStatement();
                break;
            case BEGIN:
                stmtNode = parseCompoundStatement();
                break;
            case REPEAT:
                stmtNode = parseRepeatStatement();
                break;
            case WRITE:
                stmtNode = parseWriteStatement();
                break;
            case WRITELN:
                stmtNode = parseWritelnStatement();
                break;
            case WHILE:
                stmtNode = parseWhileStatement();
                break;
            case FOR:
                stmtNode = parseForStatement();
                break;
            case IF:
                stmtNode = parseIfStatement();
                break;
            // case CASE : stmtNode = parseCaseStatement(); break; //readd this later
            case SEMICOLON:
                stmtNode = null;
                break; // empty statement

            default:
                syntaxError("Unexpected token");
        }

        if (stmtNode != null)
            stmtNode.lineNumber = savedLineNumber;
        return stmtNode;
    }

    public Node parseWhileStatement() {

        Node loopNode = new Node(LOOP);
        currentToken = scanner.nextToken();

        Node testNode = new Node(TEST);
        Node notNode = new Node(Node.NodeType.NOT);
        loopNode.adopt(testNode);
        testNode.adopt(notNode);

        notNode.adopt(parseExpression());

        if (currentToken.type != Token.TokenType.DO) {
            syntaxError("Expecting DO");
        } else {
            currentToken = scanner.nextToken();
        }

        loopNode.adopt(parseStatement());
        return loopNode;
    }

    public Node parseIfStatement() {

        Node ifNode = new Node(Node.NodeType.IF);
        currentToken = scanner.nextToken();

        ifNode.adopt(parseExpression());

        if (currentToken.type != Token.TokenType.THEN) {
            syntaxError("Expecting THEN");
        } else {
            currentToken = scanner.nextToken();
        }

        ifNode.adopt(parseStatement());

        if (currentToken.type == Token.TokenType.ELSE) {
            currentToken = scanner.nextToken();
            ifNode.adopt(parseStatement());
        }

        return ifNode;
    }

    private Node parseForStatement() {
        // The current token should be FOR
        Node compoundNode = new Node(COMPOUND);
        currentToken = scanner.nextToken(); // consume FOR

        // First assign node will have identifier, colon equals, and an expression
        Node assignNode = parseAssignmentStatement();
        compoundNode.adopt(assignNode);

        Node loopNode = new Node(LOOP);
        compoundNode.adopt(loopNode);

        Node testNode = new Node(TEST);
        loopNode.adopt((testNode));

        boolean isTo = true;
        Node opNode = null;

        //Will be GT or LT node depending on TO or DOWNTO
        if (currentToken.type == TO) {
            opNode = new Node(Node.NodeType.GT);
            currentToken = scanner.nextToken(); // consume TO
        } else if (currentToken.type == DOWNTO) {
            isTo = false;
            opNode = new Node(Node.NodeType.LT);
            currentToken = scanner.nextToken(); // consume DOWNTO
        } else {
            syntaxError("Expecting TO or DOWNTO");
        }

        // Copy the control variable
        testNode.adopt(opNode);
        assert opNode != null;
        opNode.adopt(assignNode.getChildren().get(0).copy());

        // Parse final value expression
        Node finalValue = parseExpression();
        opNode.adopt(finalValue);

        if (currentToken.type != DO) {
            syntaxError("Expecting DO");
        }
        currentToken = scanner.nextToken(); // consume DO

        // Parse loop body
        Node loopBody = parseStatement();
        loopNode.adopt(loopBody);

        // Adding the part to increment or decrement the control variable
        Node assignBody = new Node(ASSIGN);
        loopNode.adopt(assignBody);
        assignBody.adopt(assignNode.getChildren().get(0).copy());

        Node changeNode = null;
        if (isTo) {
            changeNode = new Node(ADD);
        } else {
            changeNode = new Node(SUBTRACT);
        }

        assignBody.adopt(changeNode);
        changeNode.adopt(assignNode.getChildren().get(0).copy());
        Node integerNode = new Node(INTEGER_CONSTANT);
        integerNode.value = 1L; // increments or decrements by 1 (Long)
        changeNode.adopt(integerNode);

        return compoundNode;
    }

    private Node parseAssignmentStatement() {
        // The current token should now be the left-hand-side variable name.

        Node assignmentNode = new Node(ASSIGN);

        // Enter the variable name into the symbol table
        // if it isn't already in there.
        String variableName = currentToken.text;
        SymtabEntry variableId = symtab.lookup(variableName.toLowerCase());
        if (variableId == null)
            variableId = symtab.enter(variableName);

        // The assignment node adopts the variable node as its first child.
        Node lhsNode = new Node(VARIABLE);
        lhsNode.text = variableName;
        lhsNode.entry = variableId;
        assignmentNode.adopt(lhsNode);

        currentToken = scanner.nextToken(); // consume the LHS variable;

        if (currentToken.type == COLON_EQUALS) {
            currentToken = scanner.nextToken(); // consume :=
        } else
            syntaxError("Missing :=");

        // The assignment node adopts the expression node as its second child.
        Node rhsNode = parseExpression();
        assignmentNode.adopt(rhsNode);

        return assignmentNode;
    }

    private Node parseCompoundStatement() {
        Node compoundNode = new Node(COMPOUND);
        compoundNode.lineNumber = currentToken.lineNumber;

        currentToken = scanner.nextToken(); // consume BEGIN
        parseStatementList(compoundNode, END);

        if (currentToken.type == END) {
            currentToken = scanner.nextToken(); // consume END
        } else
            syntaxError("Expecting END");

        return compoundNode;
    }

    private void parseStatementList(Node parentNode, Token.TokenType terminalType) {
        while ((currentToken.type != terminalType)
                && (currentToken.type != END_OF_FILE)) {
            Node stmtNode = parseStatement();
            if (stmtNode != null)
                parentNode.adopt(stmtNode);

            // A semicolon separates statements.
            if (currentToken.type == SEMICOLON) {
                while (currentToken.type == SEMICOLON) {
                    currentToken = scanner.nextToken(); // consume ;
                }
            } else if (statementStarters.contains(currentToken.type)) {
                syntaxError("Missing ;");
            }
        }
    }

    private Node parseRepeatStatement() {
        // The current token should now be REPEAT.

        // Create a LOOP node.
        Node loopNode = new Node(LOOP);
        currentToken = scanner.nextToken(); // consume REPEAT

        parseStatementList(loopNode, UNTIL);

        if (currentToken.type == UNTIL) {
            // Create a TEST node. It adopts the test expression node.
            Node testNode = new Node(TEST);
            lineNumber = currentToken.lineNumber;
            testNode.lineNumber = lineNumber;
            currentToken = scanner.nextToken(); // consume UNTIL

            testNode.adopt(parseExpression());

            // The LOOP node adopts the TEST node as its final child.
            loopNode.adopt(testNode);
        } else
            syntaxError("Expecting UNTIL");

        return loopNode;
    }

    private Node parseWriteStatement() {
        // The current token should now be WRITE.

        // Create a WRITE node. It adopts the variable or string node.
        Node writeNode = new Node(Node.NodeType.WRITE);
        currentToken = scanner.nextToken(); // consume WRITE

        parseWriteArguments(writeNode);
        if (writeNode.children.size() == 0) {
            syntaxError("Invalid WRITE statement");
        }

        return writeNode;
    }

    private Node parseWritelnStatement() {
        // The current token should now be WRITELN.

        // Create a WRITELN node. It adopts the variable or string node.
        Node writelnNode = new Node(Node.NodeType.WRITELN);
        currentToken = scanner.nextToken(); // consume WRITELN

        if (currentToken.type == LPAREN)
            parseWriteArguments(writelnNode);
        return writelnNode;
    }

    private void parseWriteArguments(Node node) {
        // The current token should now be (

        boolean hasArgument = false;

        if (currentToken.type == LPAREN) {
            currentToken = scanner.nextToken(); // consume (
        } else
            syntaxError("Missing left parenthesis");

        if (currentToken.type == IDENTIFIER) {
            node.adopt(parseVariable());
            hasArgument = true;
        } else if ((currentToken.type == CHARACTER)
                || (currentToken.type == STRING)) {
            node.adopt(parseStringConstant());
            hasArgument = true;
        } else
            syntaxError("Invalid WRITE or WRITELN statement");

        // Look for a field width and a count of decimal places.
        if (hasArgument) {
            if (currentToken.type == COLON) {
                currentToken = scanner.nextToken(); // consume ,

                if (currentToken.type == INTEGER) {
                    // Field width
                    node.adopt(parseIntegerConstant());

                    if (currentToken.type == COLON) {
                        currentToken = scanner.nextToken(); // consume ,

                        if (currentToken.type == INTEGER) {
                            // Count of decimal places
                            node.adopt(parseIntegerConstant());
                        } else
                            syntaxError("Invalid count of decimal places");
                    }
                } else
                    syntaxError("Invalid field width");
            }
        }

        if (currentToken.type == RPAREN) {
            currentToken = scanner.nextToken(); // consume )
        } else
            syntaxError("Missing right parenthesis");
    }

    private Node parseExpression() {
        // The current token should now be an identifier or a number.

        // The expression's root node.
        Node exprNode = parseSimpleExpression();

        // The current token might now be a relational operator.
        if (relationalOperators.contains(currentToken.type)) {
            Token.TokenType tokenType = currentToken.type;
            Node opNode = null;

            switch (tokenType) {
                case EQUALS:
                    opNode = new Node(Node.NodeType.EQ);
                    break;
                case NOT_EQUALS:
                    opNode = new Node(Node.NodeType.NE);
                    break;
                case LESS_THAN:
                    opNode = new Node(Node.NodeType.LT);
                    break;
                case LESS_EQUALS:
                    opNode = new Node(Node.NodeType.LE);
                    break;
                case GREATER_THAN:
                    opNode = new Node(Node.NodeType.GT);
                    break;
                case GREATER_EQUALS:
                    opNode = new Node(Node.NodeType.GE);
                    break;
                default:
                    syntaxError("Unexpected token");
            }

            currentToken = scanner.nextToken(); // consume relational operator

            // The relational operator node adopts the first simple expression
            // node as its first child and the second simple expression node
            // as its second child. Then it becomes the expression's root node.
            if (opNode != null) {
                opNode.adopt(exprNode);
                opNode.adopt(parseSimpleExpression());
                exprNode = opNode;
            }
        }

        return exprNode;
    }

    private Node parseSimpleExpression() {
        // The current token should now be an identifier or a number.

        // The simple expression's root node.
        Node simpExprNode = parseTerm();

        // Keep parsing more terms as long as the current token
        // is a + or - operator.
        while (simpleExpressionOperators.contains(currentToken.type)) {
            Node opNode = null;

            switch (currentToken.type) {
                case PLUS:
                    opNode = new Node(Node.NodeType.ADD);
                    break;
                case MINUS:
                    opNode = new Node(Node.NodeType.SUBTRACT);
                    break;
                case OR:
                    opNode = new Node(Node.NodeType.OR);
                    break;
                default:
                    syntaxError("Unexpected token");
            }

            currentToken = scanner.nextToken(); // consume the operator

            // The add or subtract node adopts the first term node as its
            // first child and the next term node as its second child.
            // Then it becomes the simple expression's root node.
            opNode.adopt(simpExprNode);
            opNode.adopt(parseTerm());
            simpExprNode = opNode;
        }

        return simpExprNode;
    }

    private Node parseTerm() {
        // The current token should now be an identifier or a number.

        // The term's root node.
        Node termNode = null;

        if (currentToken.type == Token.TokenType.PLUS) {
            currentToken = scanner.nextToken(); // consume +
            termNode = parseFactor();
        } else if (currentToken.type == Token.TokenType.MINUS) {
            currentToken = scanner.nextToken(); // consume -
            termNode = new Node(Node.NodeType.NEGATE);
            termNode.adopt(parseFactor());
        } else {
            termNode = parseFactor();
        }

        // Keep parsing more factors as long as the current token
        // is a * or / operator.
        while (termOperators.contains(currentToken.type)) {
            Node opNode = null;

            switch (currentToken.type) {
                case STAR:
                    opNode = new Node(Node.NodeType.MULTIPLY);
                    break;
                case SLASH:
                    opNode = new Node(Node.NodeType.DIVIDE);
                    break;
                case DIV:
                    opNode = new Node(Node.NodeType.INTEGER_DIVIDE);
                    break;
                case MOD:
                    opNode = new Node(Node.NodeType.MODULO);
                    break;
                case AND:
                    opNode = new Node(Node.NodeType.AND);
                    break;
                default:
                    syntaxError("Unexpected token");
            }

            currentToken = scanner.nextToken(); // consume the operator

            // The multiply or divide node adopts the first factor node as its
            // as its first child and the next factor node as its second child.
            // Then it becomes the term's root node.
            opNode.adopt(termNode);
            opNode.adopt(parseFactor());
            termNode = opNode;
        }

        return termNode;
    }

    private Node parseFactor() {
        // The current token should now be an identifier or a number or (

        if (currentToken.type == IDENTIFIER)
            return parseVariable();
        else if (currentToken.type == INTEGER)
            return parseIntegerConstant();
        else if (currentToken.type == REAL)
            return parseRealConstant();

        else if (currentToken.type == LPAREN) {
            currentToken = scanner.nextToken(); // consume (
            Node exprNode = parseExpression();

            if (currentToken.type == RPAREN) {
                currentToken = scanner.nextToken(); // consume )
            } else
                syntaxError("Expecting )");

            return exprNode;
        }

        else if (currentToken.type == Token.TokenType.NOT) {
            Node notNode = new Node(Node.NodeType.NOT);
            currentToken = scanner.nextToken(); // consume NOT

            notNode.adopt(parseFactor());
            return notNode;
        }

        else
            syntaxError("Unexpected token");
        return null;
    }

    private Node parseVariable() {
        // The current token should now be an identifier.

        // Has the variable been "declared"?
        String variableName = currentToken.text;
        SymtabEntry variableId = symtab.lookup(variableName.toLowerCase());
        if (variableId == null)
            semanticError("Undeclared identifier");

        Node node = new Node(VARIABLE);
        node.text = variableName;
        node.entry = variableId;

        currentToken = scanner.nextToken(); // consume the identifier
        return node;
    }

    private Node parseIntegerConstant() {
        // The current token should now be a number.

        Node integerNode = new Node(INTEGER_CONSTANT);
        integerNode.value = currentToken.value;

        currentToken = scanner.nextToken(); // consume the number
        return integerNode;
    }

    private Node parseRealConstant() {
        // The current token should now be a number.

        Node realNode = new Node(REAL_CONSTANT);
        realNode.value = currentToken.value;

        currentToken = scanner.nextToken(); // consume the number
        return realNode;
    }

    private Node parseStringConstant() {
        // The current token should now be CHARACTER or STRING.

        Node stringNode = new Node(STRING_CONSTANT);
        stringNode.value = currentToken.value;

        currentToken = scanner.nextToken(); // consume the string
        return stringNode;
    }

    private void syntaxError(String message) {
        System.out.println("SYNTAX ERROR at line " + lineNumber
                + ": " + message + " at '" + currentToken.text + "'");
        errorCount++;

        // Recover by skipping the rest of the statement.
        // Skip to a statement follower token.
        while (!statementFollowers.contains(currentToken.type)) {
            currentToken = scanner.nextToken();
        }
    }

    private void semanticError(String message) {
        System.out.println("SEMANTIC ERROR at line " + lineNumber
                + ": " + message + " at '" + currentToken.text + "'");
        errorCount++;
    }
}