package P1;

// Dany jest plecak o objętości v = 10 oraz 6 przedmiotów ponumerowanych od 0 do 5. Każdy przedmiot ma określoną
// wartość Wi i objętość Vi. Należy zapakować plecak spośród przedmiotów ponumerowanych od 0 do 5 w taki sposób,
// aby wartość przedmiotów w nim zgromadzonych była największa. Wartości i objętości przedmiotów określone są
// w poniższej tabeli:               |  i |  0 |  1 |  2 |  3 |  4 |  5 |
//                                   | Vi |  6 |  2 |  3 |  2 |  3 |  1 |
//                                   | Wi |  6 |  4 |  5 |  7 | 10 |  2 |
// Odp.: W plecaku o maksymalnej wartości znajdą się przedmioty 1,2,3,4 o wartości 26.

public class PlecakowyDynamicznie
{
    final static int N = 6;                 // Liczba przedmiotów
    final static int MAX_V = 10;            // Objętość plecaka
    final static int[] VI = {6, 2, 3, 2, 3, 1};  // Objętości przedmiotów
    final static int[] WI = {6, 4, 5, 7, 10, 2}; // Wartości przedmiotów

    public static void main(String[] args)
    {
        int wartoscPlecaka = plecak();
        System.out.println("Wartość plecaka: " + wartoscPlecaka);
    }

    public static int plecak()
    {
        int[][] tab = new int[N][MAX_V + 1]; // Dla objętości: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 (kolumny)
        // oraz dla przedmiotów: 0, 1, 2, 3, 4, 5 (wiersze)

        for (int v = 0; v <= MAX_V; v++) // Wypełnianie pierwszego wiersza
        {
            if (v < VI[0]) { tab[0][v] = 0; }
            else { tab[0][v] = WI[0]; }
        }

        for (int w = 1; w < N; w++) // Wypełnianie pozostałych wierszy
        {
            for (int v = 0; v <= MAX_V; v++) // Wypełnianie pozostałych kolumn
            {
                if (v < VI[w]) { tab[w][v] = tab[w - 1][v]; }
                else
                {
                    int p1 = tab[w - 1][v];
                    int p2 = WI[w] + tab[w - 1][v - VI[w]];
                    tab[w][v] = Math.max(p1, p2);
                }
            }
        }

        return tab[N - 1][MAX_V];
    }
}
