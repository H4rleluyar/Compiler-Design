/**
 * Token class for a simple interpreter.
 *
 * (c) 2020 by Ronald Mak
 * Department of Computer Science
 * San Jose State University
 */
package frontend;

import java.util.HashMap;

//import javax.xml.transform.Source;

public class Token {
    public enum TokenType // create TokenType that enables variable to be a set a predefined constants
    {
        PROGRAM, BEGIN, END, REPEAT, UNTIL, WRITE, WRITELN,
        PERIOD, COLON, COLON_EQUALS, SEMICOLON,
        PLUS, MINUS, STAR, SLASH, LPAREN, RPAREN,
        EQUALS, LESS_THAN, DIV, MOD, AND, OR, NOT, CONST, TYPE, VAR, PROCEDURE, FUNCTION,
        WHILE, DO, FOR, TO, DOWNTO, IF, THEN, ELSE, CASE, OF, COMMA, GREATER_THAN, LBRACKET, RBRACKET, CARAT,
        HUH, DOT_DOT, NOT_EQUALS, LESS_EQUALS, GREATER_EQUALS,
        IDENTIFIER, INTEGER, REAL, CHARACTER, STRING, END_OF_FILE, ERROR
    }

    /**
     * The table (as a hashmap) of reserved words. Initialize the table.
     */
    private static HashMap<String, TokenType> reservedWords;
    static {
        reservedWords = new HashMap<String, TokenType>();

        reservedWords.put("PROGRAM", TokenType.PROGRAM);
        reservedWords.put("BEGIN", TokenType.BEGIN);
        reservedWords.put("END", TokenType.END);
        reservedWords.put("REPEAT", TokenType.REPEAT);
        reservedWords.put("UNTIL", TokenType.UNTIL);
        reservedWords.put("WRITE", TokenType.WRITE);
        reservedWords.put("WRITELN", TokenType.WRITELN);
        reservedWords.put("DIV", TokenType.DIV);
        reservedWords.put("MOD", TokenType.MOD);
        reservedWords.put("AND", TokenType.AND);
        reservedWords.put("OR", TokenType.OR);
        reservedWords.put("NOT", TokenType.NOT);
        reservedWords.put("CONST", TokenType.CONST);
        reservedWords.put("TYPE", TokenType.TYPE);
        reservedWords.put("VAR", TokenType.VAR);
        reservedWords.put("PROCEDURE", TokenType.PROCEDURE);
        reservedWords.put("FUNCTION", TokenType.FUNCTION);
        reservedWords.put("WHILE", TokenType.WHILE);
        reservedWords.put("DO", TokenType.DO);
        reservedWords.put("FOR", TokenType.FOR);
        reservedWords.put("TO", TokenType.TO);
        reservedWords.put("DOWNTO", TokenType.DOWNTO);
        reservedWords.put("IF", TokenType.IF);
        reservedWords.put("THEN", TokenType.THEN);
        reservedWords.put("ELSE", TokenType.ELSE);
        reservedWords.put("CASE", TokenType.CASE);
        reservedWords.put("OF", TokenType.OF);

    }

    public TokenType type; // what type of token
    public int lineNumber = 0; // source line number of the token
    public String text = ""; // text of the token
    public Object value = null; // the value (if any) of the token

    /**
     * Constructor.
     *
     * @param firstChar the first character of the token.
     */
    private Token(char firstChar) {
        this.text += firstChar;
    }

    /**
     * Construct a word token.
     *
     * @param firstChar the first character of the token.
     * @param source    the input source.
     * @return the word token.
     */
    public static Token word(char firstChar, Source source) {
        Token token = new Token(firstChar);
        token.lineNumber = source.lineNumber();

        // Loop to get the rest of the characters of the word token.
        // Append letters and digits to the token.
        for (char ch = source.nextChar(); Character.isLetterOrDigit(ch); ch = source.nextChar()) {
            token.text += ch;
        }

        // Is it a reserved word or an identifier?
        token.type = reservedWords.get(token.text.toUpperCase());
        if (token.type == null)
            token.type = TokenType.IDENTIFIER;

        return token;
    }

    /**
     * Construct a number token and set its value.
     *
     * @param firstChar the first character of the token.
     * @param source    the input source.
     * @return the number token.
     */
    public static Token number(char firstChar, Source source) {
        Token token = new Token(firstChar);
        token.lineNumber = source.lineNumber();
        int pointCount = 0;

        // Loop to get the rest of the characters of the number token.
        // Append digits to the token.
        for (char ch = source.nextChar(); Character.isDigit(ch) || (ch == '.'); ch = source.nextChar()) {
            if (ch == '.')
                pointCount++;
            token.text += ch;
        }

        // Integer constant.
        if (pointCount == 0) {
            token.type = TokenType.INTEGER;
            token.value = Long.parseLong(token.text);
        }

        // Real constant.
        else if (pointCount == 1) {
            token.type = TokenType.REAL;
            token.value = Double.parseDouble(token.text);
        }

        else {
            token.type = TokenType.ERROR;
            tokenError(token, "Invalid number");
        }

        return token;
    }

    /**
     * Construct a string token and set its value.
     *
     * @param firstChar the first character of the token.
     * @param source    the input source.
     * @return the string token.
     */
    public static Token string(char firstChar, Source source) {
        Token token = new Token(firstChar); // the leading '
        token.lineNumber = source.lineNumber();

        // Loop to append the rest of the characters of the string,
        // up to but not including the closing quote.
        for (char ch = source.nextChar(); ch != '\'' && ch != Character.MIN_VALUE; ch = source.nextChar()) {
            token.text += ch;
        }

        //token.text += '\''; // append the closing '
        char ch = source.nextChar(); // and consume it

        //Check if the value is a single character or not
        var text = token.text.substring(1, token.text.length());

        if (ch == Character.MIN_VALUE) { // Check if string ends with a null
            // Token is an EOF-reached error
            token.text += Character.MIN_VALUE; // End EOF string with EOF character
                                               // Appending EOF is a required anchor for the token error msg to fire.
            //tokenError(token, "String not closed"); // Token error that displays erroneous partial string
            //token.type = TokenType.ERROR; // Error recovery: we want to treat this as a good string in case we can
                                            // recover the context later.
        }
        else
            // Token is a string or character
            token.text += '\''; // append the closing '
            if (text.length() == 1)
                token.type = TokenType.CHARACTER;
            else
                token.type = TokenType.STRING;



        // Don't include the leading and trailing ' in the value.
        token.value = text;

        return token;
    }

    /**
     * Construct a special symbol token and set its value.
     *
     * @param firstChar the first character of the token.
     * @param source    the input source.
     * @return the special symbol token.
     */
    public static Token specialSymbol(char firstChar, Source source) {
        Token token = new Token(firstChar);
        token.lineNumber = source.lineNumber();

        switch (firstChar) {
            case '.': {
                char nextChar = source.nextChar();

                if (nextChar == '.') // check if next symbol is . so that it would be ..
                {
                    token.text += '.';
                    token.type = TokenType.DOT_DOT;
                } else { // else it's just a period
                    token.type = TokenType.PERIOD;
                    return token;
                }
                break;
            }
            case ',':
                token.type = TokenType.COMMA;
                break;
            case ':': {
                char nextChar = source.nextChar();
                // Is it the := symbol?
                if (nextChar == '=') {
                    token.text += '=';
                    token.type = TokenType.COLON_EQUALS;
                }
                // No, it's just the : symbol.
                else {
                    token.type = TokenType.COLON;
                    return token; // already consumed :
                }
                break;
            }
            case ';':
                token.type = TokenType.SEMICOLON;
                break;
            case '+':
                token.type = TokenType.PLUS;
                break;
            case '-':
                token.type = TokenType.MINUS;
                break;
            case '*':
                token.type = TokenType.STAR;
                break;
            case '/':
                token.type = TokenType.SLASH;
                break;
            case '(':
                token.type = TokenType.LPAREN;
                break;
            case ')':
                token.type = TokenType.RPAREN;
                break;
            case '=':
                token.type = TokenType.EQUALS;
                break;
            case '<': {
                char nextChar = source.nextChar();
                if (nextChar == '>') { // check if symbol will be <>
                    token.text += '>';
                    token.type = TokenType.NOT_EQUALS;
                } else if (nextChar == '=') { // check if symbol will be <=
                    token.text += '=';
                    token.type = TokenType.LESS_EQUALS;
                } else { // symbol is just <
                    token.type = TokenType.LESS_THAN;
                    return token;
                }
                break;
            }
            case '>': {
                char nextChar = source.nextChar();
                if (nextChar == '=') { // check if symbol will be >=
                    token.text += '=';
                    token.type = TokenType.GREATER_EQUALS;
                } else { // symbol is just >
                    token.type = TokenType.GREATER_THAN;
                    return token;
                }
                break;
            }
            case '\'':
                token.type = TokenType.HUH;
                break;
            case '[':
                token.type = TokenType.LBRACKET;
                break;
            case ']':
                token.type = TokenType.RBRACKET;
                break;
            case '^':
                token.type = TokenType.CARAT;
                break;
            case Source.EOF:
                token.type = TokenType.END_OF_FILE;
                break;

            default: {
                token.type = TokenType.ERROR;
                tokenError(token, "Invalid token");
            }
        }

        source.nextChar(); // consume the special symbol
        return token;
    }

    /**
     * Handle a token error.
     *
     * @param token   the bad token.
     * @param message the error message.
     */
    private static void tokenError(Token token, String message) {
        System.out.println("TOKEN ERROR at line " + token.lineNumber
                + ": " + message + " at '" + token.text + "'");
    }
}