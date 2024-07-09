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

import java.util.Random;

public class LodyMonteCarlo
{
    final static int N = 6;
    static int[][] czas = {{0, 7, 20, 21, 12, 23},
                           {27, 0, 13, 16, 46, 5},
                           {53, 15, 0, 25, 27, 6},
                           {16, 2, 35, 0, 47, 10},
                           {31, 29, 5, 18, 0, 4},
                           {28, 24, 1, 17, 5, 0}};
    private static int[] uzyteLody = {0, 0, 0, 0, 0, 0}; // Ile aktualnie użyliśmy lodów
    private static int[] listaLodow = new int[N]; // Aktualny schemat produkcji lodów
    private static int[] listaLodowNajlepsza = new int[N]; // Najlepszy Schemat produkcji lodów
    static int minCzas; // Aktualny czas produkcji lodów
    static int minCzasNajlepszy = Integer.MAX_VALUE; // Najlepszy czas produkcji lodów
    static StringBuilder lody = new StringBuilder(); // Aktualna sekwencja produkcji lodów
    static StringBuilder lodyNajlepsze = new StringBuilder(); // Najlepsza sekwencja produkcji lodów

    public static void main(String[] args)
    {
        for (int losuj = 0; losuj < 100; losuj++) // Liczba losowań
        {
            produkcja();
            sprawdz();
            resetowanie();
        }
        wypisz();
    }

    private static void produkcja()
    {
        Random random = new Random();
        int ileLodow = 0;
        while (ileLodow != 6)
        {
            int maszyna = random.nextInt(6);
            if (uzyteLody[maszyna] == 0)
            {
                lody.append("p").append(maszyna).append(", ");
                uzyteLody[maszyna] = 1;
                listaLodow[ileLodow] = maszyna;
            }
            ileLodow = 0;
            for (int i : uzyteLody) { ileLodow += i; }
        }

        for (int i = 0; i < listaLodow.length - 1; i++) { minCzas += czas[listaLodow[i]][listaLodow[i + 1]]; }
        minCzas += czas[listaLodow[5]][listaLodow[0]];
    }

    private static void sprawdz()
    {
        if (minCzas <= minCzasNajlepszy)
        {
            minCzasNajlepszy = minCzas;
            lodyNajlepsze = lody;
            listaLodowNajlepsza = listaLodow;
        }
    }

    private static void resetowanie()
    {
        lody = new StringBuilder();
        minCzas = 0;
        listaLodow = new int[N];
        uzyteLody = new int[]{0, 0, 0, 0, 0, 0};
    }

    private static void wypisz()
    {
        System.out.println("Minimalny czas produkcji: " + minCzasNajlepszy);
        System.out.print("Użyte lody: ");
        for (int i : listaLodowNajlepsza) { System.out.print((i + 1) + ", "); }
        System.out.println(listaLodowNajlepsza[0] + 1);
    }
}
