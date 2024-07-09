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

import java.util.Arrays;

public class LodyGenerowaniaTestowania
{
    final static int N = 6; // Permutacje lodów n-elementowych // 6 smaków lodów
    final static int[][] PRZESTAWIANIE = {{0, 7, 20, 21, 12, 23},
                                          {27, 0, 13, 16, 46, 5},
                                          {53, 15, 0, 25, 27, 6},
                                          {16, 2, 35, 0, 47, 10},
                                          {31, 29, 5, 18, 0, 4},
                                          {28, 24, 1, 17, 5, 0}}; // Tabela przestrajania maszyny do lodów
    static int MINCZAS = Integer.MAX_VALUE; // Minimalny czas na przestawianie maszyn
    static StringBuilder SMAKI = new StringBuilder(); // String z kolejnością produkcji lodów
    private static final int[] LODY = new int[N + 1]; // 6 smaków lodów plus przestawienie maszyny na początkowy smak

    public static void main(String[] args)
    {
        lody(0);
        System.out.print("Przykładowe kolejności produkcji lodów: \n" + SMAKI); // Wypisanie najlepszych rezultatów produkcji lodów
        System.out.println("Minimalny czas przestroju maszyn: " + MINCZAS); // Wypisanie najlepszego czasu produkcji lodów
    }

    static void lody(int miejsce)
    {
        if (miejsce == N)
        {
            LODY[6] = LODY[0]; // Dodanie do ostatniego miejsca w produkcji pierwszego smaku, aby był przygotowany na kolejny dzień
            int minCzasAktualny = 0;
            for (int j = 0; j < N; j++) { minCzasAktualny += PRZESTAWIANIE[LODY[j] - 1][LODY[j + 1] - 1]; } // Liczenie aktualnego czasu produkcji lodów
            if (minCzasAktualny == MINCZAS) { SMAKI.append(" -> ").append(Arrays.toString(LODY)).append("\n"); } // Sprawdzanie, czy aktualny czas produkcji jest taki sam jak obecny najlepszy czas produkcji
            if (minCzasAktualny < MINCZAS) { MINCZAS = minCzasAktualny; SMAKI.delete(0, SMAKI.length()); SMAKI.append(" -> ").append(Arrays.toString(LODY)).append("\n"); } // Sprawdzanie, czy aktualny czas produkcji jest szybszy niż obecny najlepszy czas produkcji
        }
        else
        {
            for (int kolej = 1; kolej <= N; kolej++) // Permutacje smaków lodów
            {
                int zamien;
                for (zamien = 0; zamien < miejsce; zamien++) { if (LODY[zamien] == kolej) break; }
                if (zamien == miejsce)
                {
                    LODY[zamien] = kolej;
                    lody(miejsce + 1);
                }
            }
        }
    }
}
