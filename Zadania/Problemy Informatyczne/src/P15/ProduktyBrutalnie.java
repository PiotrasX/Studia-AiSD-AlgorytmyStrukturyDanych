package P15;

// Pewne przedsiębiorstwo ma centrale zbytu swojego produktu w miastach Warszawa, Gdańsk i Wrocław. Centrale te
// posiadają odpowiednio 40, 20 i 40 jednostek produktu. Punkty sprzedaży zamówiły następujące ilości jednostek:
// Szczecin 25, Poznań 10, Olsztyn 20, Katowice 30, Rzeszów 15. Koszt transportu (w dziesiątkach złotych) między każdą
// centralą i punktem sprzedaży podaje następująca tablica:
//                   |    z\do    |  Szczecin  |   Poznań   |   Olsztyn  |  Katowice  |   Rzeszów  |
//                   |  Warszawa  |     52     |     30     |     23     |     31     |     33     |
//                   |   Wrocław  |     37     |     17     |     45     |     18     |     42     |
//                   |   Gdańsk   |     38     |     31     |     18     |     53     |     65     |
// Jak rozesłać zamówione produkty z central do punktów sprzedaży, aby koszty transportu były możliwie najmniejsze?
// Odp.: Aby uzyskać minimalny koszt transportu produktów wynoszący 2675 dziesiątek złotych, należy z central Warszawa,
//       Wrocław i Gdańsk rozesłać do punktów sprzedaży Szczecin, Poznań, Olsztyn, Katowice i Rzeszów produkty
//       w następujących proporcjach:
//                   |    z\do    |  Szczecin  |   Poznań   |   Olsztyn  |  Katowice  |   Rzeszów  |
//                   |  Warszawa  |      0     |     0-5    |     20     |     5-0    |     15     |
//                   |   Wrocław  |      5     |    10-5    |      0     |    25-30   |      0     |
//                   |   Gdańsk   |     20     |      0     |      0     |      0     |      0     |

public class ProduktyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] koszty = {{52, 30, 23, 31, 33},
                          {37, 17, 45, 18, 42},
                          {38, 31, 18, 53, 65}};              // Koszty transportu
        StringBuilder jakieMiasta = new StringBuilder();
        double kosztMin = 9999;

        System.out.println("Postęp liczenia:");
        for (int warSz = 0; warSz <= 25; warSz += 1)
        {
            for (int warPoz = 0; warPoz <= 10; warPoz += 1)
            {
                for (int warOl = 0; warOl <= 20; warOl += 1)
                {
                    if (warSz + warPoz + warOl > 40) break;                                // Sprawdzenie czy Warszawa nie przekracza pojemności
                    for (int warKat = 0; warKat <= 30; warKat += 1)
                    {
                        if (warSz + warPoz + warOl + warKat > 40) break;                   // Sprawdzenie czy Warszawa nie przekracza pojemności
                        for (int warRze = 0; warRze <= 15; warRze += 1)
                        {
                            if (warSz + warPoz + warOl + warKat + warRze > 40) break;      // Sprawdzenie czy Warszawa nie przekracza pojemności
                            for (int wroSz = 0; wroSz <= 25 - warSz; wroSz += 1)
                            {
                                for (int wroPoz = 0; wroPoz <= 10 - warPoz; wroPoz += 1)
                                {
                                    for (int wroOl = 0; wroOl <= 20 - warOl; wroOl += 1)
                                    {
                                        if (wroSz + wroPoz + wroOl > 40) break;                                // Sprawdzenie czy Wrocław nie przekracza pojemności
                                        for (int wroKat = 0; wroKat <= 30 - warKat; wroKat += 1)
                                        {
                                            if (wroSz + wroPoz + wroOl + wroKat > 40) break;                   // Sprawdzenie czy Wrocław nie przekracza pojemności
                                            for (int wroRze = 0; wroRze <= 15 - warRze; wroRze += 1)
                                            {
                                                if (wroSz + wroPoz + wroOl + wroKat + wroRze > 40) break;      // Sprawdzenie czy Wrocław nie przekracza pojemności
                                                int gdaSz = 25 - warSz - wroSz;
                                                int gdaPoz = 10 - warPoz - wroPoz;
                                                int gdaOl = 20 - warOl - wroOl;
                                                int gdaKat = 30 - warKat - wroKat;
                                                int gdaRze = 15 - warRze - wroRze;
                                                if (gdaSz + gdaPoz + gdaOl + gdaKat + gdaRze > 20) break;                           // Sprawdzenie czy Gdańsk nie przekracza pojemności
                                                int koszt = koszty[0][0] * warSz + koszty[0][1] * warPoz + koszty[0][2] * warOl + koszty[0][3] * warKat + koszty[0][4] * warRze +
                                                            koszty[1][0] * wroSz + koszty[1][1] * wroPoz + koszty[1][2] * wroOl + koszty[1][3] * wroKat + koszty[1][4] * wroRze +
                                                            koszty[2][0] * gdaSz + koszty[2][1] * gdaPoz + koszty[2][2] * gdaOl + koszty[2][3] * gdaKat + koszty[2][4] * gdaRze;      // Aktualny minimalny koszt;
                                                if (koszt <= kosztMin)
                                                {
                                                    kosztMin = koszt;
                                                    jakieMiasta.delete(0, jakieMiasta.length());
                                                    jakieMiasta.append("Szczecin (Warszawa -> ").append(warSz).append(", Wrocław -> ").append(wroSz).append(", Gdańsk -> ").append(gdaSz).append(")\n\t\t\t\t\t   ").
                                                            append("Poznań \t(Warszawa -> ").append(warPoz).append(", Wrocław -> ").append(wroPoz).append(", Gdańsk -> ").append(gdaPoz).append(")\n\t\t\t\t\t   ").
                                                            append("Olsztyn \t(Warszawa -> ").append(warOl).append(", Wrocław -> ").append(wroOl).append(", Gdańsk -> ").append(gdaOl).append(")\n\t\t\t\t\t   ").
                                                            append("Katowice (Warszawa -> ").append(warKat).append(", Wrocław -> ").append(wroKat).append(", Gdańsk -> ").append(gdaKat).append(")\n\t\t\t\t\t   ").
                                                            append("Rzeszów \t(Warszawa -> ").append(warRze).append(", Wrocław -> ").append(wroRze).append(", Gdańsk -> ").append(gdaRze).append(")");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(warSz * 4 + "%");
        }
        System.out.println("\nTransport przedmiotów: " + jakieMiasta);
        System.out.println("Minimalny koszt: " + kosztMin + "zł");
    }
}
