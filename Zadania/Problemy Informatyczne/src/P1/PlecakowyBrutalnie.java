package P1;

// Dany jest plecak o objętości v = 10 oraz 6 przedmiotów ponumerowanych od 0 do 5. Każdy przedmiot ma określoną
// wartość Wi i objętość Vi. Należy zapakować plecak spośród przedmiotów ponumerowanych od 0 do 5 w taki sposób,
// aby wartość przedmiotów w nim zgromadzonych była największa. Wartości i objętości przedmiotów określone są
// w poniższej tabeli:               |  i |  0 |  1 |  2 |  3 |  4 |  5 |
//                                   | Vi |  6 |  2 |  3 |  2 |  3 |  1 |
//                                   | Wi |  6 |  4 |  5 |  7 | 10 |  2 |
// Odp.: W plecaku o maksymalnej wartości znajdą się przedmioty 1,2,3,4 o wartości 26.

public class PlecakowyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] plecak = {{6, 2, 3, 2, 3, 1},    // Vi
                          {6, 4, 5, 7, 10, 2}};  // Wi
        int vMax = 0;     // Maksymalna objętość
        int wMax = 0;     // Maksymalna wartość
        int vAktu = 0;    // Aktualna objętość
        int wAktu = 0;    // Aktualna wartość
        StringBuilder uzyte;
        StringBuilder uMax = new StringBuilder();

        for (int p0 = 0; p0 <= 1; p0++)
        {
            for (int p1 = 0; p1 <= 1; p1++)
            {
                for (int p2 = 0; p2 <= 1; p2++)
                {
                    for (int p3 = 0; p3 <= 1; p3++)
                    {
                        for (int p4 = 0; p4 <= 1; p4++)
                        {
                            for (int p5 = 0; p5 <= 1; p5++)
                            {
                                vAktu = 0;
                                wAktu = 0;
                                uzyte = new StringBuilder();
                                if (p0 == 1) { vAktu += plecak[0][0]; wAktu += plecak[1][0]; uzyte.append("0 "); }
                                if (p1 == 1) { vAktu += plecak[0][1]; wAktu += plecak[1][1]; uzyte.append("1 "); }
                                if (p2 == 1) { vAktu += plecak[0][2]; wAktu += plecak[1][2]; uzyte.append("2 "); }
                                if (p3 == 1) { vAktu += plecak[0][3]; wAktu += plecak[1][3]; uzyte.append("3 "); }
                                if (p4 == 1) { vAktu += plecak[0][4]; wAktu += plecak[1][4]; uzyte.append("4 "); }
                                if (p5 == 1) { vAktu += plecak[0][5]; wAktu += plecak[1][5]; uzyte.append("5 "); }

                                if (wAktu >= wMax && vAktu <= 10)
                                {
                                    wMax = wAktu; vMax = vAktu; uMax = uzyte;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Użyte przedmioty: " + uMax + "\nWartość plecaka: " + wMax + "\nObjętość plecaka: " + vMax);
    }
}
