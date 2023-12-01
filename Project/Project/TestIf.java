public class TestIf
{
    private static java.util.Scanner _sysin = new java.util.Scanner(System.in);

    private static int i;
    private static int j;
    private static int k;
    private static double x;
    private static double y;
    private static boolean p;
    private static boolean q;
    private static String str;
    private static String txt;

    public static void main(String[] args)
    {
        java.time.Instant _start = java.time.Instant.now();


        i = 1;
        j = 2;
        if (i == j) 
            System.out.printf("%s", "if true");
        else {
            x = -5;
            System.out.printf("%s", "if else, compound");
        }
        System.out.printf("%s", "outside if");
        while (i > 9000) 
        {
            System.out.printf("%s", "in while");
        }

        java.time.Instant _end = java.time.Instant.now();
        long _elapsed = java.time.Duration.between(_start, _end).toMillis();
        System.out.printf("\n[%,d milliseconds execution time.]\n", _elapsed);
    }
}
