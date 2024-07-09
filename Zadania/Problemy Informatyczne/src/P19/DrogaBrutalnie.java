package P19;

// Wyznaczyć najkrótszą drogę z Warszawy do Sofii, korzystając z sieci połączeń przedstawionej w poniższej tabeli,
// gdzie w przypadku istniejącego połączenia pomiędzy miastami, podane są odległości (w kilometrach). Natomiast
// jeśli pomiędzy dwoma miastami nie ma bezpośredniego połączenia — zamiast odległości umieszczono słowo: brak.
// |   Miasta  | Warszawa | Katowice | Zakopane |   Lwów   |  Wiedeń  | Budapeszt | Bukareszt |  Zagrzeb  |   Sofia   |
// --------------------------------------------------------------------------------------------------------------------
// |  Warszawa |     0    |    300   |    402   |    356   |   brak   |    brak   |    brak   |    brak   |    brak   |
// |  Katowice |    300   |     0    |   brak   |   brak   |    440   |    474    |    brak   |    brak   |    brak   |
// |  Zakopane |    402   |   brak   |     0    |   brak   |   brak   |    330    |    brak   |    brak   |    brak   |
// |    Lwów   |    356   |   brak   |   brak   |     0    |   brak   |    brak   |    823    |    brak   |    brak   |
// |   Wiedeń  |   brak   |    440   |   brak   |   brak   |     0    |    brak   |    brak   |    430    |    brak   |
// | Budapeszt |   brak   |    474   |    330   |   brak   |   brak   |     0     |    813    |    365    |    774    |
// | Bukareszt |   brak   |   brak   |   brak   |    823   |   brak   |    813    |     0     |    brak   |    403    |
// |  Zagrzeb  |   brak   |   brak   |   brak   |   brak   |    430   |    365    |    brak   |     0     |    768    |
// |   Sofia   |   brak   |   brak   |   brak   |   brak   |   brak   |    774    |    403    |    768    |     0     |
// Odp.: Najkrótsza droga z Warszawy do Sofii ma długość 1506 km i prowadzi przez Zakopane oraz Budapeszt.

public class DrogaBrutalnie
{
    public static void main(String[] args)
    {
        int[][] polaczenia = {{0, 300, 402, 356, -1, -1, -1, -1, -1},
                              {300, 0, -1, -1, 440, 474, -1, -1, -1},
                              {402, -1, 0, -1, -1, 330, -1, -1, -1},
                              {356, -1, -1, 0, -1, -1, 823, -1, -1},
                              {-1, 440, -1, -1, 0, -1, -1, 430, -1},
                              {-1, 474, 330, -1, -1, 0, 813, 365, 774},
                              {-1, -1, -1, 823, -1, 813, 0, -1, 403},
                              {-1, -1, -1, -1, 430, 365, -1, 0, 768},
                              {-1, -1, -1, -1, -1, 774, 403, 768, 0}}; // Spis połączeń między miastami
        wyznaczDroge(0, polaczenia);
        System.out.println("Najszybsza trasa ma " + najszybszaTrasa + "km");
        System.out.println("Trasa prowadzi przez: " + najszybszaTrasaSlownie);
    }

    static int najszybszaTrasa = Integer.MAX_VALUE; // Najszybsza trasa w kilometrach
    static int trasa = 0; // Aktualna trasa w kilometrach
    static StringBuilder najszybszaTrasaSlownie = new StringBuilder("Warszawa"); // Najszybsza trasa słownie
    static int[] najszybszaTrasaTablica = new int[9]; // Tablica trasy z najszybszymi miastami
    static String[] najszybszaTrasaTablicaSlownie = {"Warszawa","Katowice","Zakopane","Lwów","Wiedeń","Budapeszt","Bukareszt","Zagrzeb","Sofia"};

    static void wyznaczDroge(int i, int [][]polaczenia)
    {
        for (int j = i; j <= 8; j++)
        {
            int droga=polaczenia[i][j];
            if (droga > 0)
            {
                trasa += droga;
                najszybszaTrasaTablica[j] = 1;
                wyznaczDroge(j, polaczenia);
                trasa -= droga;
                najszybszaTrasaTablica[j] = 0;
            }
        }
        if (trasa <= najszybszaTrasa && i == 8)
        {
            najszybszaTrasaSlownie = new StringBuilder("Warszawa");
            najszybszaTrasa=trasa;
            for (int k = 0; k <= 8; k++)
            {
                if (najszybszaTrasaTablica[k] != 0) { najszybszaTrasaSlownie.append(" - ").append(najszybszaTrasaTablicaSlownie[k]); }
            }
        }
    }
}
