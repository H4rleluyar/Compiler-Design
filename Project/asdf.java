public class asdf
{
    private static java.util.Scanner _sysin = new java.util.Scanner(System.in);

    private static int i;
    private static int j;
    private static int a;
    private static int b;
    private static int c;
    private static double k;
    private static int x;
    private static int y;
    private static String line;

    public static void main(String[] args)
    {
        java.time.Instant _start = java.time.Instant.now();


        line = "Hello World";
        i = 1;
        j = 2;
        if (i == j) 
        {
            x = 3;
        }
        else {
            x = -5;
        }
        if (i != j) 
        {
            y = 3;
        }
        else {
            y = -5;
        }
        System.out.printf("%d", i);
        System.out.printf("%s", "\n");
        System.out.printf("%d", j);
        System.out.printf("%s", "\n");
        System.out.printf("%d", x);
        System.out.printf("%s", "\n");
        System.out.printf("%d", y);
        System.out.printf("%s", "\n");
        System.out.printf("%s", "Hello World\n");
        if (i == j) 
        {
            x = -7;
        }
        else {
            x = 8;
        }
        if (i != j) 
        {
            y = 14;
        }
        else {
            y = -2;
        }
        line = "Goodbye World!\n";
        System.out.printf("%d", i);
        System.out.printf("%s", "\n");
        System.out.printf("%d", j);
        System.out.printf("%s", "\n");
        System.out.printf("%d", x);
        System.out.printf("%s", "\n");
        System.out.printf("%d", y);
        System.out.printf("%s", "\n");
        System.out.printf("%s", line);
        if (10 >= 12) 
        {
            System.out.printf("%s", "Ten is not bigger than 12 dummy!");
        }
        System.out.printf("%s", "\n");
        if (10 <= 12) 
        {
            System.out.printf("%s", "Ten is less than 12");
        }

        java.time.Instant _end = java.time.Instant.now();
        long _elapsed = java.time.Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
