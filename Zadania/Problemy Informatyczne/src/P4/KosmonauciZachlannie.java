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

public class KosmonauciZachlannie
{
    private final static int SPECJALIZACJE = 4; // Liczba specjalizacji
    private final static int KOSMONAUCI = 5; // Liczba kosmonautów
    private final static int[][] kosmonauci = {{1, 0, 0, 1, 0}, // A
                                               {0, 1, 1, 1, 0}, // B
                                               {0, 0, 1, 0, 1}, // C
                                               {1, 1, 0, 0, 1}}; // D
    private static int liczbaKosmonautow = 0; // Najlepszy schemat liczby kosmonautów
    private static final StringBuilder kosmonauciSlownie = new StringBuilder(); // Najlepsza sekwencja kosmonautów

    public static void main(String[] args)
    {
        generuj();
        wypisz();
    }

    private static void generuj()
    {
        int[] uzyteSpecjalizacje = new int[SPECJALIZACJE];
        int[] uzyciKosmonauci = new int[KOSMONAUCI];

        int ileUzytych = 0;
        while (ileUzytych != SPECJALIZACJE)
        {
            int najlepszyKosmonauta = getNajlepszyKosmonauta(uzyciKosmonauci, uzyteSpecjalizacje);
            if (najlepszyKosmonauta != -1)
            {
                uzyciKosmonauci[najlepszyKosmonauta] = 1;
                for (int i = 0; i < SPECJALIZACJE; i++)
                {
                    if (kosmonauci[i][najlepszyKosmonauta] != 0)
                    {
                        uzyteSpecjalizacje[i] = 1;
                    }
                }
                liczbaKosmonautow++;
                kosmonauciSlownie.append("k").append(najlepszyKosmonauta).append(", ");
            }

            ileUzytych = 0;
            for (int i : uzyteSpecjalizacje) { if (i != 0) ileUzytych++; }
        }
    }

    private static int getNajlepszyKosmonauta(int[] uzyciKosmonauci, int[] uzyteSpecjalizacje)
    {
        int najlepszyKosmonauta = -1;
        int maxSpec = -1;
        for (int kosmonauta = 0; kosmonauta < KOSMONAUCI; kosmonauta++)
        {
            if (uzyciKosmonauci[kosmonauta] == 0)
            {
                int spec = liczSpecjalizacje(kosmonauta, uzyteSpecjalizacje);
                if (spec > maxSpec)
                {
                    najlepszyKosmonauta = kosmonauta;
                    maxSpec = spec;
                }
            }
        }
        return najlepszyKosmonauta;
    }

    private static int liczSpecjalizacje(int kosmonauta, int[] uzyteSpecjalizacje)
    {
        int liczba = 0;
        for (int i = 0; i < SPECJALIZACJE; i++)
        {
            if (kosmonauci[i][kosmonauta] == 1 && uzyteSpecjalizacje[i] == 0)
            {
                liczba++;
            }
        }
        return liczba;
    }

    private static void wypisz()
    {
        System.out.println("Liczba kosmonautów: " + liczbaKosmonautow);
        System.out.println("Użyci kosmonauci: " + kosmonauciSlownie);
    }
}
