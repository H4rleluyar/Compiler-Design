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

        else if (ch == '\'') {
            Token fullString = Token.string(ch, source);

            //newCh used in case of consecutive single quote to append the following string
            char newCh = source.currentChar();

            //loops until the following character is no longer a single quote
            //Appends next chunk of string into fullString, then checks if
            //the value is a single character or a string
            while (newCh == '\'') {
                Token consecutivePart = Token.string(newCh, source);
                fullString.text += consecutivePart.text.substring(1);
                fullString.value += consecutivePart.text.substring(1, consecutivePart.text.length() - 1);

                if (fullString.text.substring(1, fullString.text.length() - 1).length() == 1)
                    fullString.type = Token.TokenType.CHARACTER;
                else
                    fullString.type = Token.TokenType.STRING;

                newCh = source.currentChar();
            }

            return fullString;
        } else
            return Token.specialSymbol(ch, source);
    }
}
