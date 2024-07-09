package P10;

// Jak umieścić 4 hetmanów na szachownicy 4x4 tak, aby nie biły się wzajemnie, tzn. żadnych dwóch hetmanów nie było
// umieszczonych w tym samym wierszu, kolumnie lub na przekątnej szachownicy.
// Odp.: Oto przykładowy rozkład hetmanów na szachownicy:
//                                               |   | 0 |   |   |
//                                               |   |   |   | 0 |
//                                               | 0 |   |   |   |
//                                               |   |   | 0 |   |

import java.util.Arrays;

public class HetmaniBrutalnie
{
    public static void main(String[] args)
    {
        System.out.println("Przykładowe rozkłady hetmanów na szachownicy:");
        for (int ktore = 0; ktore <= 3; ktore++)
        {
            int[][] pole = {{0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0},
                            {0, 0, 0, 0}};       // Pole gry
            int[][] hetmani = szukaj(0, 0, pole, ktore);

            int ileHetmanow = 0;
            for (int[] w : pole)
            {
                for(int k : w)
                {
                    if (k == 1) ileHetmanow++;
                }
            }
            if (ileHetmanow == 4)
            {
                System.out.println(Arrays.toString(hetmani[0]));
                System.out.println(Arrays.toString(hetmani[1]));
                System.out.println(Arrays.toString(hetmani[2]));
                System.out.println(Arrays.toString(hetmani[3]));
                System.out.println();
            }
        }
    }

    public static int[][] szukaj(int wiersz, int kolumna, int[][]pole, int ktore)
    {
        pole[0][ktore] = 1;
        for (int w = wiersz; w <= 3; w++)
        {
            for (int k = kolumna; k <= 3; k++)
            {
                if (pole[w][0] == 0 && pole[w][1] == 0 && pole[w][2] == 0 && pole[w][3] == 0 &&
                        pole[0][k] == 0 && pole[1][k] == 0 && pole[2][k] == 0 && pole[3][k] == 0)
                {
                    int wspr = w + 1;
                    int kspr = k + 1;
                    int poprawne = 1;
                    while (wspr <= 3 && kspr <= 3)           // Sprawdzanie skosu pierwszego czy nie ma hetmana
                    {
                        if (pole[wspr][kspr] == 1)
                        {
                            poprawne = 0;
                            break;
                        }
                        wspr++;
                        kspr++;
                    }
                    if (poprawne == 0) continue;

                    wspr = w - 1;
                    kspr = k - 1;
                    while (wspr >= 0 && kspr >= 0)           // Sprawdzanie skosu drugiego czy nie ma hetmana
                    {
                        if (pole[wspr][kspr] == 1)
                        {
                            poprawne = 0;
                            break;
                        }
                        wspr--;
                        kspr--;
                    }
                    if (poprawne == 0) continue;

                    wspr = w - 1;
                    kspr = k + 1;
                    while (wspr >= 0 && kspr <= 3)           // Sprawdzanie skosu trzeciego czy nie ma hetmana
                    {
                        if (pole[wspr][kspr] == 1)
                        {
                            poprawne = 0;
                            break;
                        }
                        wspr--;
                        kspr++;
                    }
                    if (poprawne == 0) continue;

                    wspr = w + 1;
                    kspr = k - 1;
                    while (wspr <= 3 && kspr >= 0)           // Sprawdzanie skosu czwartego czy nie ma hetmana
                    {
                        if (pole[wspr][kspr] == 1)
                        {
                            poprawne = 0;
                            break;
                        }
                        wspr++;
                        kspr--;
                    }
                    if (poprawne == 0) continue;

                    pole[w][k] = 1;
                }
            }
        }
        return pole;
    }
}
