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

public class KosmonauciGenerowaniaTestowania
{
    final static int N = 5; // Kombinacje kosmonautów n-elementowych // Liczba kosmonautów
    final static int[][] SPECJALNOSCI = {{1, 0, 0, 1},   // Specjalności k1
                                         {0, 1, 0, 1},   // Specjalności k2
                                         {0, 1, 1, 0},   // Specjalności k3
                                         {1, 1, 0, 0},   // Specjalności k4
                                         {0, 0, 1, 1}};  // Specjalności k5 // Specjalności kosmonautów
    private static int[] UZYTESPECJALNOSCI = new int[4]; // Tablica z zabranymi specjalnościami na lot
    static int MAXKOSMONAUCI = 5; // Maksymalna ilość kosmonautów
    static StringBuilder KOSMONAUCI = new StringBuilder(); // String z dobrymi kosmonautami
    private static final int[] ZABRANIKOSMONAUCI = new int[N + 1]; // Tablica zabranych kosmonautów na lot

    public static void main(String[] args)
    {
        kosmonauci();
        System.out.print("Przykładowe zestawy dobrych kosmonautów: \n" + KOSMONAUCI); // Wypisanie najlepszych zestawów kosmonautów
        System.out.println("Minimalna liczba kosmonautów: " + MAXKOSMONAUCI); // Wypisanie najmniejszej ilości potrzebnych kosmonautów
    }

    static void kosmonauci()
    {
        int kombinacje = (int) Math.pow(2, N); // Liczba możliwych kombinacji kosmonautów
        for (int kombinacja = 0; kombinacja < kombinacje; kombinacja++)
        {
            for (int sprawdz = 0; sprawdz < N; sprawdz++) { if (ZABRANIKOSMONAUCI[sprawdz] ==1 ) { for (int specjalnosc = 0; specjalnosc < 4; specjalnosc++) { if(SPECJALNOSCI[sprawdz][specjalnosc] == 1) { UZYTESPECJALNOSCI[specjalnosc] = SPECJALNOSCI[sprawdz][specjalnosc]; } } } }
            boolean czySaWszystkieSpecjalnosci = true;
            for (int specjalnosc : UZYTESPECJALNOSCI) { if (specjalnosc == 0) { czySaWszystkieSpecjalnosci = false; break; } }
            if (czySaWszystkieSpecjalnosci)
            {
                int kosmonauciAktualnie = 0;
                StringBuilder zabraniKosmonauci = new StringBuilder(" ->");
                for (int kosmonaut = 0; kosmonaut < N; kosmonaut++) { if(ZABRANIKOSMONAUCI[kosmonaut] == 1) { kosmonauciAktualnie++; zabraniKosmonauci.append(" k").append(kosmonaut + 1); } }
                zabraniKosmonauci.append("\n");
                if (kosmonauciAktualnie == MAXKOSMONAUCI) { KOSMONAUCI.append(zabraniKosmonauci); }
                if (kosmonauciAktualnie < MAXKOSMONAUCI) { KOSMONAUCI.delete(0, KOSMONAUCI.length()); KOSMONAUCI.append(zabraniKosmonauci); MAXKOSMONAUCI = kosmonauciAktualnie; }
            }
            UZYTESPECJALNOSCI = new int[] {0, 0, 0, 0};
            int zamien = 0;
            do
            {
                if (ZABRANIKOSMONAUCI[zamien] == 1) { ZABRANIKOSMONAUCI[zamien] = 0; zamien++; }
                else { ZABRANIKOSMONAUCI[zamien] = 1; break; }
            } while (true);
        }
    }
}
