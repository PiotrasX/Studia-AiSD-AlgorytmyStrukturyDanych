package P5;

// Fabryka lodów każdego dnia produkuje na tej samej maszynie lody o sześciu różnych smakach. Zmiana produkcji
// ze smaku 'i' na smak 'j' wymaga przestrojenia maszyny, czyli przygotowania (w tym umycia) do nowej produkcji,
// które trwa określony czas. Podana niżej tablica zawiera informację o czasach przestrojenia maszyny.
//                                       |i\j |  1 |  2 |  3 |  4 |  5 |  6 |
//                                       |  1 |  0 |  7 | 20 | 21 | 12 | 23 |
//                                       |  2 | 27 |  0 | 13 | 16 | 46 |  5 |
//                                       |  3 | 53 | 15 |  0 | 25 | 27 |  6 |
//                                       |  4 | 16 |  2 | 35 |  0 | 47 | 10 |
//                                       |  5 | 31 | 29 |  5 | 18 |  0 |  4 |
//                                       |  6 | 28 | 24 |  1 | 17 |  5 |  0 |
// Znaleźć kolejność produkcji, przy której całkowity czas przestrojenia maszyny jest minimalny.
// Przyjąć, że na koniec dnia maszyna ma być przygotowana do produkcji w następnym dniu.
// Odp.: Minimalny całkowity czas przestrojenia maszyny wynosi 63. Oto przykładowa kolejność produkcji lodów,
//       dla której całkowity czas przestrojenia maszyny jest minimalny: 1,2,6,5,3,4,1.

public class LodyZachlannie
{
    final static int N = 6;
    static int[][] czas = {{0, 7, 20, 21, 12, 23},
                           {27, 0, 13, 16, 46, 5},
                           {53, 15, 0, 25, 27, 6},
                           {16, 2, 35, 0, 47, 10},
                           {31, 29, 5, 18, 0, 4},
                           {28, 24, 1, 17, 5, 0}};
    private static final int[] uzyteLody = {0, 0, 0, 0, 0, 0}; // Ile aktualnie użyliśmy lodów
    static int minCzas = Integer.MAX_VALUE; // Najlepszy czas produkcji lodów
    static StringBuilder lodyNajlepsze = new StringBuilder(); // Najlepsza sekwencja produkcji lodów

    public static void main(String[] args)
    {
        generuj();
        wypisz();
    }

    private static void generuj()
    {
        for (int start = 0; start < N; start++)
        {
            int obecnyCzas = 0;
            int[] uzyteLody = new int[N]; // Ile aktualnie użyliśmy lodów
            StringBuilder lody = new StringBuilder(); // Aktualna sekwencja produkcji lodów

            int obecnaMaszyna = start;
            uzyteLody[obecnaMaszyna] = 1;
            lody.append(obecnaMaszyna + 1).append(", ");

            for (int i = 1; i < N; i++)
            {
                int najlepszyCzas = Integer.MAX_VALUE;
                int najlepszaMaszyna = -1;
                for (int j = 0; j < N; j++)
                {
                    if (uzyteLody[j] == 0 && czas[obecnaMaszyna][j] < najlepszyCzas)
                    {
                        najlepszyCzas = czas[obecnaMaszyna][j];
                        najlepszaMaszyna = j;
                    }
                }
                obecnyCzas += najlepszyCzas;
                obecnaMaszyna = najlepszaMaszyna;
                uzyteLody[najlepszaMaszyna] = 1;
                lody.append(najlepszaMaszyna + 1).append(", ");
            }
            obecnyCzas += czas[obecnaMaszyna][start]; // Dodanie czas powrotu do startowej maszyny

            if (obecnyCzas < minCzas)
            {
                minCzas = obecnyCzas;
                lodyNajlepsze = new StringBuilder(lody);
            }
        }
    }

    private static void wypisz()
    {
        System.out.println("Minimalny czas produkcji: " + minCzas);
        System.out.print("Użyte lody: " + lodyNajlepsze.toString());
    }
}
