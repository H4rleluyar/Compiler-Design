import antlr4.Pcl4Lexer;
import antlr4.Pcl4Parser;
import backend.interpreter.Executor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Pcl4Main
{
    public static void main(String[] args) throws Exception
    {
        String inputFile = null;

        // Create the input stream.
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);

        // Create the character stream from the input stream.
        CharStream cs = CharStreams.fromStream(is);

        // Create a lexer which scans the character stream
        // to create a token stream.
        Pcl4Lexer lexer = new Pcl4Lexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Print the token stream.
        /*System.out.println("Tokens:");
        tokens.fill();
        for (Token token : tokens.getTokens())
        {
            System.out.println(token.toString());
        }*/

        // Create a parser which parses the token stream
        // to create a parse tree.
        Pcl4Parser parser = new Pcl4Parser(tokens);
        ParseTree tree = parser.program();

        // Print the parse tree in Lisp format.
        /*System.out.println("\nParse tree (Lisp format):");
        System.out.println(tree.toStringTree(parser));
         */

        // Execution
        Executor executor = new Executor();
        executor.visit(tree);
    }
}