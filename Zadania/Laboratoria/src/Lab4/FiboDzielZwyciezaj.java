package Lab4;

public class FiboDzielZwyciezaj
{
    public static void main(String[] args)
    {
        final int N = 7; // N-ty wyraz ciągu
        System.out.println(fibo(N));
    }

    static int fibo(int n)
    {
        if (n==1 || n==2) return 1;
        return fibo(n-1) + fibo(n-2);
    }
}
