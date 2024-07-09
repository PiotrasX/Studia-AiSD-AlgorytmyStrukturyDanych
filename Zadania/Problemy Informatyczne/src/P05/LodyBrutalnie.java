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

public class LodyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] lody = {{0, 7, 20, 21, 12, 23},
                        {27, 0, 13, 16, 46, 5},
                        {53, 15, 0, 25, 27, 6},
                        {16, 2, 35, 0, 47, 10},
                        {31, 29, 5, 18, 0, 4},
                        {28, 24, 1, 17, 5, 0}};      // Tabela przestrajania maszyny do lodów

        int czasMin = 999;    // Maksymalny czas na przestawienie maszyn
        StringBuilder jakieLody = new StringBuilder();
        for (int l1 = 1; l1 <= 6; l1++)
        {
            for (int l2 = 1; l2 <= 6; l2++)
            {
                for (int l3 = 1; l3 <= 6; l3++)
                {
                    for (int l4 = 1; l4 <= 6; l4++)
                    {
                        for (int l5 = 1; l5 <= 6; l5++)
                        {
                            for (int l6 = 1; l6 <= 6; l6++)
                            {
                                 if (l1 == l2 || l1 == l3 || l1 == l4 || l1 == l5 || l1 == l6 ||
                                         l2 == l3 || l2 == l4 || l2 == l5 || l2 == l6 || l3 == l4 ||
                                         l3 == l5 || l3 == l6 || l4 == l5 || l4 == l6 || l5 == l6) { continue; }
                                int czas = lody[l1 - 1][l2 - 1] + lody[l2 - 1][l3 - 1] + lody[l3 - 1][l4 - 1] +
                                        lody[l4 - 1][l5 - 1] + lody[l5 - 1][l6 - 1] + lody[l6 - 1][l1 - 1]; // Aktualny czas przestrojenia maszyn
                                if (czas == czasMin)
                                {
                                    jakieLody.append(" -> ").append(l1).append(" ").append(l2).append(" ").append(l3).append(" ").append(l4).append(" ").append(l5).append(" ").append(l6).append(" ").append(l1).append("\n");
                                }
                                if (czas < czasMin)
                                {
                                    czasMin = czas;
                                    jakieLody.delete(0, jakieLody.length());
                                    jakieLody.append(" -> ").append(l1).append(" ").append(l2).append(" ").append(l3).append(" ").append(l4).append(" ").append(l5).append(" ").append(l6).append(" ").append(l1).append("\n");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Przykładowe kolejności produkcji lodów: ");
        System.out.print(jakieLody);
        System.out.println("Minimalny czas przestroju maszyn: " + czasMin);
    }
}
