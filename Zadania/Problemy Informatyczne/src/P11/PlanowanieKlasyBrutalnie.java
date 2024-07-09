package P11;

// Zaplanować liczbę uczniów w klasach Ia, Ib, Ic, Id przy założeniu, że do szkoły przyjęto 68 dziewcząt i 54 chłopców.
// Maksymalna liczba uczniów w poszczególnych klasach może wynosić:
//                                                  | Ia | 32 |
//                                                  | Ib | 28 |
//                                                  | Ic | 34 |
//                                                  | Id | 36 |
// Dodatkowo wymaga się, aby w poszczególnych klasach liczba dziewcząt była większa lub równa liczbie chłopców.
// Odp.: W poniższej tabeli podany jest przykładowy rozkład uczniów w klasach:
//                                                       | dz | ch |
//                                                  | Ia | 19 |  5 |
//                                                  | Ib | 14 | 14 |
//                                                  | Ic | 17 | 17 |
//                                                  | Id | 18 | 18 |

public class PlanowanieKlasyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] klasy = {{0, 0},             // Ia
                         {0, 0},             // Ib
                         {0, 0},             // Ic
                         {0, 0}};            // Id

        int i = 0;
        int dz = 68;
        int ch = 54;
        while (i < 130)
        {
            if (dz <= 0 && ch <= 0) break;
            if (klasy[3][0] + klasy[3][1] < 36)          // Klasa Id
            {
                if (dz > 0 && klasy[3][0] == klasy[3][1]) { klasy[3][0] += 1; dz--; }  // Klasa Id dziewczyny
                else if (ch > 0) { klasy[3][1] += 1; ch--; }                           // Klasa Id chłopcy
                else { klasy[3][0] += 1; dz--; }                                       // Klasa Id dziewczyny uzupełnienie
            }
            else if (klasy[2][0] + klasy[2][1] < 34)     // Klasa Ic
            {
                if (dz > 0 && klasy[2][0] == klasy[2][1]) { klasy[2][0] += 1; dz--; }  // Klasa Ic dziewczyny
                else if (ch > 0) { klasy[2][1] += 1; ch--; }                           // Klasa Ic chłopcy
                else { klasy[2][0] += 1; dz--; }                                       // Klasa Ic dziewczyny uzupełnienie
            }
            else if (klasy[1][0] + klasy[1][1] < 28)     // Klasa Ib
            {
                if (dz > 0 && klasy[1][0] == klasy[1][1]) { klasy[1][0] += 1; dz--; }  // Klasa Ib dziewczyny
                else if (ch > 0) { klasy[1][1] += 1; ch--; }                           // Klasa Ib chłopcy
                else { klasy[1][0] += 1; dz--; }                                       // Klasa Ib dziewczyny uzupełnienie
            }
            else if (klasy[0][0] + klasy[0][1] < 32)     // Klasa Ia
            {
                if (dz > 0 && klasy[0][0] == klasy[0][1]) { klasy[0][0] += 1; dz--; }  // Klasa Ia dziewczyny
                else if (ch > 0) { klasy[0][1] += 1; ch--; }                           // Klasa Ia chłopcy
                else { klasy[0][0] += 1; dz--; }                                       // Klasa Ia dziewczyny uzupełnienie
            }
            i++;
        }
        System.out.println("Podział klas:");
        System.out.println("Klasa Ia: dziewczyny -> " + klasy[0][0] + ", chłopcy -> " + klasy[0][1]);
        System.out.println("Klasa Ib: dziewczyny -> " + klasy[1][0] + ", chłopcy -> " + klasy[1][1]);
        System.out.println("Klasa Ic: dziewczyny -> " + klasy[2][0] + ", chłopcy -> " + klasy[2][1]);
        System.out.println("Klasa Id: dziewczyny -> " + klasy[3][0] + ", chłopcy -> " + klasy[3][1]);
    }
}
