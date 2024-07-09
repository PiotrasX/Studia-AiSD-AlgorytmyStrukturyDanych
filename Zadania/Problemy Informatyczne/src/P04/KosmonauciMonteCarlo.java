package P4;

// Organizowana jest załogowa ekspedycja kosmiczna na Marsa. W ramach kompletowania załogi statku kosmicznego
// główny organizator ekspedycji ma rozwiązać następujący problem. Do jego dyspozycji jest pięciu kosmonautów
// (k1, k2, k3, k4, k5), którzy przeszli pozytywnie kwalifikację wstępną do udziału w ekspedycji. Na pokładzie
// specjalnego statku kosmicznego spośród nich będzie potrzebny przynajmniej jeden specjalista w każdej
// z dziedzin: A, B, C i D. Wiadomo jest, że w dziedzinie A specjalizują się kosmonauci k1 i k4, w dziedzinie B
// specjalizują się kosmonauci k2, k3 i k4, w dziedzinie C specjalizują się kosmonauci k3 i k5 oraz w dziedzinie D
// specjalizują się kosmonauci k1, k2 i k5. Ze względu na szczupłość miejsca na pokładzie statku kosmicznego,
// z powyższej piątki trzeba wybrać jak najmniejszą grupkę kosmonautów, tak aby znajdował się w niej przynajmniej
// jeden specjalista w każdej z dziedzin A, B, C, D.
// Odp.: Na Marsa mogą polecieć kosmonauci k4 i k5 oraz k1 i k3.

import java.util.Random;

public class KosmonauciMonteCarlo
{
    private final static int SPECJALIZACJE = 4; // Liczba specjalizacji
    private final static int KOSMONAUCI = 5; // Liczba kosmonautów
    private final static int[][] kosmonauci = {{1, 0, 0, 1, 0}, // A
                                               {0, 1, 1, 1, 0}, // B
                                               {0, 0, 1, 0, 1}, // C
                                               {1, 1, 0, 0, 1}}; // D
    private static int[] uzyteSpecjalizacje = {0, 0, 0, 0}; // Ile aktualnie użyliśmy specjalizacji
    private static int[] uzyciKosmonauci = {0, 0, 0, 0, 0}; // Ile aktualnie użyliśmy kosmonautów
    private static int liczbaKosmonautow = 0; // Aktualny schemat liczby kosmonautów
    private static int liczbaKosmonautowNajlepsza = Integer.MAX_VALUE; // Najlepszy schemat liczby kosmonautów
    private static StringBuilder kosmonauciSlownie = new StringBuilder(); // Aktualna sekwencja kosmonautów
    private static StringBuilder kosmonauciSlownieNajlepsze = new StringBuilder(); // Najlepsza sekwencja kosmonautów

    public static void main(String[] args)
    {
        for (int losuj = 0; losuj <= 100; losuj++) // Liczba losowań kosmonautów
        {
            losowanie();
            sprawdz();
            resetowanie();
        }
        wypisz();
    }

    private static void losowanie()
    {
        Random random = new Random();
        int ileUzytych = 0;
        while (ileUzytych != SPECJALIZACJE)
        {
            int kosmonaut = random.nextInt(KOSMONAUCI);
            if (uzyciKosmonauci[kosmonaut] == 0)
            {
                uzyciKosmonauci[kosmonaut] = 1;
                for (int i = 0; i < SPECJALIZACJE; i++)
                    { if(kosmonauci[i][kosmonaut] != 0) { uzyteSpecjalizacje[i] = 1; } }
                liczbaKosmonautow += 1;
                kosmonauciSlownie.append("k").append(kosmonaut).append(", ");
            }
            ileUzytych = 0;
            for (int i : uzyteSpecjalizacje) { if (i != 0) ileUzytych++; }
        }
    }

    private static void sprawdz()
    {
        if (liczbaKosmonautow <= liczbaKosmonautowNajlepsza)
        {
            liczbaKosmonautowNajlepsza = liczbaKosmonautow;
            kosmonauciSlownieNajlepsze = kosmonauciSlownie;
        }
    }
    private static void resetowanie()
    {
        uzyteSpecjalizacje = new int[] {0, 0, 0, 0};
        uzyciKosmonauci = new int[] {0, 0, 0, 0, 0};
        liczbaKosmonautow = 0;
        kosmonauciSlownie = new StringBuilder();
    }
    private static void wypisz()
    {
        System.out.println("Liczba kosmonautów: " + liczbaKosmonautowNajlepsza);
        System.out.println("Użyci kosmonauci: " + kosmonauciSlownieNajlepsze);
    }
}
