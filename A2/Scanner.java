/**
 * Scanner class for a simple interpreter.
 *
 * (c) 2020 by Ronald Mak
 * Department of Computer Science
 * San Jose State University
 */
package frontend;

//import javax.xml.transform.Source;

public class Scanner {
    private Source source;

    /**
     * Constructor.
     *
     * @param source the input source.
     */
    public Scanner(Source source) {
        this.source = source;
    }

    /**
     * Extract the next token from the source.
     *
     * @return the token.
     */
    public Token nextToken() {
        char ch = source.currentChar();

        // Boolean used for checking if currently reading a comment
        boolean inComment = false;
        if (ch == '{')
            inComment = true;

        // Skip blanks and other whitespace characters. Also skips characters if currently reading a comment
        while (Character.isWhitespace(ch) || inComment) {
            if (ch == '}')
                inComment = false;

            ch = source.nextChar();

            if (ch == '{')
                inComment = true;
        }

        if (Character.isLetter(ch))
            return Token.word(ch, source);
        else if (Character.isDigit(ch))
            return Token.number(ch, source);
        else if (ch == '\'')
            return Token.string(ch, source);
        else
            return Token.specialSymbol(ch, source);
    }
}
