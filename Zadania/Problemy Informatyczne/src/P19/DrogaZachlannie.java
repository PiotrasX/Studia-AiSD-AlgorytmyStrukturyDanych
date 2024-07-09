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

public class DrogaZachlannie
{
    final static int N = 9; // Liczba miast
    static int[][] polaczenia = {{0, 300, 402, 356, -1, -1, -1, -1, -1},
                                 {300, 0, -1, -1, 440, 474, -1, -1, -1},
                                 {402, -1, 0, -1, -1, 330, -1, -1, -1},
                                 {356, -1, -1, 0, -1, -1, 823, -1, -1},
                                 {-1, 440, -1, -1, 0, -1, -1, 430, -1},
                                 {-1, 474, 330, -1, -1, 0, 813, 365, 774},
                                 {-1, -1, -1, 823, -1, 813, 0, -1, 403},
                                 {-1, -1, -1, -1, 430, 365, -1, 0, 768},
                                 {-1, -1, -1, -1, -1, 774, 403, 768, 0}};
    static String[] miasta = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt", "Bukareszt", "Zagrzeb", "Sofia"};

    public static void main(String[] args)
    {
        int aktualneMiasto = 0; // Warszawa
        int cel = 8; // Sofia
        int dlugoscTrasy = 0;
        StringBuilder trasa = new StringBuilder(miasta[aktualneMiasto]);

        while (aktualneMiasto != cel)
        {
            int nastepneMiasto = -1;
            int najkrotszaOdleglosc = Integer.MAX_VALUE;

            for (int i = aktualneMiasto; i < N; i++)
            {
                if (polaczenia[aktualneMiasto][i] > 0 && polaczenia[aktualneMiasto][i] < najkrotszaOdleglosc)
                {
                    najkrotszaOdleglosc = polaczenia[aktualneMiasto][i];
                    nastepneMiasto = i;
                }
            }

            if (nastepneMiasto == -1)
            {
                System.out.println("Nie znaleziono trasy.");
                return;
            }

            dlugoscTrasy += najkrotszaOdleglosc;
            trasa.append(" -> ").append(miasta[nastepneMiasto]);
            aktualneMiasto = nastepneMiasto;
        }

        System.out.println("Najkrótsza trasa ma długość: " + dlugoscTrasy + " km.");
        System.out.println("Trasa prowadzi przez: " + trasa);
    }
}
