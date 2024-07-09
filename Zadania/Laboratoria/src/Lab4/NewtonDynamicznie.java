package Lab4;

public class NewtonDynamicznie
{
    public static void main(String[] args)
    {
        final int N = 7;
        final int K = 3;
        System.out.println(newton(N,K));
    }

    static int newton(int n, int k)
    {
        int[][] tab = new int[n+1][k+1];
        for (int i = 0; i <= n; i++)
        {
            tab[i][0] = 1;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= k; j++)
            {
                tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
            }
        }
        return tab[n][k];
    }
}
