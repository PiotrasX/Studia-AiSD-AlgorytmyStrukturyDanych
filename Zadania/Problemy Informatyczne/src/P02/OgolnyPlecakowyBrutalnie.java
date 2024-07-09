package P2;

// Dany jest plecak o objętości v = 23 oraz nieograniczona liczba egzemplarzy 6 różnych przedmiotów ponumerowanych
// od 0 do 5. Każdy przedmiot ma określoną wartość Wi i objętość Vi. Należy zapakować plecak spośród przedmiotów
// ponumerowanych od 0 do 5 w taki sposób, aby wartość przedmiotów w nim zgromadzonych była największa.
// Wartości i objętości przedmiotów określone są w poniższej tabeli:
//                                   |  i |  0 |  1 |  2 |  3 |  4 |  5 |
//                                   | Vi |  6 |  2 |  3 |  2 |  3 |  1 |
//                                   | Wi |  6 |  4 |  5 |  7 | 10 |  2 |
// Odp.: W plecaku o maksymalnej wartości znajdzie się dziesięć przedmiotów z numerem 3 i jeden przedmiot z numerem 4.
//       Łączna wartość przedmiotów w plecaku wyniesie 80.

public class OgolnyPlecakowyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] plecak = {{6, 2, 3, 2, 3, 1},    // Vi
                          {6, 4, 5, 7, 10, 2}};  // Wi
        int vMax = 0;     // Maksymalna objętość
        int wMax = 0;     // Maksymalna wartość
        int vAktu = 0;    // Aktualna objętość
        int wAktu = 0;    // Aktualna wartość
        int[] uzyte;
        int[] uMax = {0, 0, 0, 0, 0, 0};

        for (int p0 = 0; p0 <= 15; p0++)
        {
            for (int p1 = 0; p1 <= 15; p1++)
            {
                for (int p2 = 0; p2 <= 15; p2++)
                {
                    for (int p3 = 0; p3 <= 15; p3++)
                    {
                        for (int p4 = 0; p4 <= 15; p4++)
                        {
                            for (int p5 = 0; p5 <= 15; p5++)
                            {
                                vAktu = 0;
                                wAktu = 0;
                                vAktu += plecak[0][0] * p0; wAktu += plecak[1][0] * p0;
                                vAktu += plecak[0][1] * p1; wAktu += plecak[1][1] * p1;
                                vAktu += plecak[0][2] * p2; wAktu += plecak[1][2] * p2;
                                vAktu += plecak[0][3] * p3; wAktu += plecak[1][3] * p3;
                                vAktu += plecak[0][4] * p4; wAktu += plecak[1][4] * p4;
                                vAktu += plecak[0][5] * p5; wAktu += plecak[1][5] * p5;
                                uzyte= new int[] {p0, p1, p2, p3, p4, p5};

                                if (wAktu >= wMax && vAktu <= 23)
                                {
                                    wMax = wAktu; vMax = vAktu; uMax = uzyte;
                                }
                            }
                        }
                    }
                }
            }
        }

        StringBuilder u = new StringBuilder();
        for (int i = 0; i < uMax.length; i++)
        {
            if (uMax[i] != 0)
            {
                u.append("p").append(i).append("x").append(uMax[i]).append(" ");
            }
        }
        System.out.println("Użyte przedmioty: " + u + "\nWartość plecaka: " + wMax + "\nObjętość plecaka: " + vMax);
    }
}
