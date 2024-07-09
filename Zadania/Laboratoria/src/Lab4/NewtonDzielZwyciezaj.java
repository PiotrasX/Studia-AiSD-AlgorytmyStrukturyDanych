package Lab4;

public class NewtonDzielZwyciezaj
{
    public static void main(String[] args) 
    {
        final int N = 7;
        final int K = 3;
        System.out.println(newton(N,K));
    }

    static int newton(int n, int k) 
    {
        if (k==0 || k==n) return 1;
        return newton(n-1,k-1) + newton(n-1,k);
    }
}
