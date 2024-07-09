package Lab4;

public class PermutacjeLody
{
    final static int N = 6;
    private static final int[] L = new int[N];
    static int[][] czas = {{0, 7, 20, 21, 12, 23}, 
                          {27, 0, 13, 16, 46, 5}, 
                          {53, 15, 0, 25, 27, 6}, 
                          {16, 2, 35, 0, 47, 10}, 
                          {31, 29, 5, 18, 0, 4}, 
                          {28, 24, 1, 17, 5, 0}};
    static int minCzas = Integer.MAX_VALUE;
    static String lody = "";

    static void permutacje(int i)
    {
        if (i == N)
        {
            StringBuilder aktLody = new StringBuilder();
            int aktCzas = 0;
            for (int j = 0; j < N; j++) // Przejście przez całą zbudowaną sekwencję smaków (permutacje)
            {
                aktLody.append((L[j] + 1)).append(", "); // Dopisywanie numerów smaków do rozwiązania
                if (j < N-1) // Przejście między smakami będzie o 1 mniej niż wszystkich smaków (z ostatniego smaku w permutacji nie ma już przejścia)
                    aktCzas += czas[L[j]][L[j + 1]]; // Doliczanie czasu przejścia ze smaku j na smak j+1
            }

            // Powrót na smak startowy
            aktCzas += czas[L[N - 1]][L[0]]; // Doliczenie czasu powrotu na smak rozpoczynający sekwencje
            aktLody.append(L[0] + 1); // Dołączenie numeru smaku rozpoczynającego sekwencję na koniec
            // Wypisanie aktualnego rozwiązania
            System.out.println("LODY: " + aktLody + " CZAS: " + aktCzas);

            // Wybor najlepszego rozwiązania (podmiana na bieżąco)
            if (aktCzas < minCzas)
            {
                minCzas = aktCzas;
                lody = aktLody.toString();
            }
        }
        else
        {
            for (int j = 0; j < N; j++)
            {
                int k;
                for (k = 0; k < i; k++)
                {
                    if (L[k] == j) break;
                }
                if (k == i)
                {
                    L[k] = j;
                    permutacje(i + 1);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        permutacje(0);
        System.out.println("\n>>> NAJLEPSZE ROZWIĄZANIE:\n\tCzas: " + minCzas + "\n\tSekwencja: " + lody);
    }
}
