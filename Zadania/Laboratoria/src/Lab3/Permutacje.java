package Lab3;

public class Permutacje
{
    final static int N = 3; // Permutacje n-elementowe
    private static final int[] L = new int[N];
    public static void main(String[] args) { permutacje(0); }

    static void permutacje(int i)
    {
        if (i == N)
        {
            for (int j = 0; j < N; j++) { System.out.print(L[j] + " "); }
            System.out.println();
        }
        else
        {
            for (int j = 1; j <= N; j++)
            {
                int k;
                for (k = 0; k < i; k++) { if (L[k] == j) break; }
                if (k == i)
                {
                    L[k] = j;
                    permutacje(i+1);
                }
            }
        }
    }
}
