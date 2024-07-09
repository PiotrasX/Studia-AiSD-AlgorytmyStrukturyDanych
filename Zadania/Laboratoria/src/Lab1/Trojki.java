package Lab1;

public class Trojki
{
    public static final int N = 20;
    public static void main(String[] args)
    {
        int a = 0, b = 0, c = 0;
        for (int x = 1; x <= N; x++)
        {
            a++;
            for (int y = x; y <= N; y++)
            {
                b++;
                for (int z = y; z <= N; z++)
                {
                    c++;
                    if (x*x + y*y == z*z)
                    {
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
        System.out.println("\n\"Złożoność\": " + a + " + " + b + " + " + c + " = " + (a + b + c));
    }
}
