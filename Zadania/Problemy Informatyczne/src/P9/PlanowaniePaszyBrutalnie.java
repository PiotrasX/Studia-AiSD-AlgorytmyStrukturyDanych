package P9;

// W zestaw paszowy bydła w okresie zimowym wchodzą trzy składniki: siano, kiszonka i pasza treściwa, które zawierają
// trzy rodzaje podstawowych składników odżywczych, takich jak: białko, wapno i witaminy. Ich zawartość w kilogramie
// paszy, ceny (w złotówkach za kilogram) oraz minimalne normy dzienne (w kilogramach) niezbędne do prawidłowego
// odżywiania bydła podaje poniższa tabelka.
//                      | Rodzaje paszy           |       Składniki odżywcze       | Ceny  |
//                      |                         |  białko  |   wapno  | witaminy |       |
//                      --------------------------------------------------------------------
//                      | Siano                   |    50    |     6    |     2    |   3   |
//                      | Kiszonka                |    20    |     4    |     1    |   2   |
//                      | Pasza treściwa          |    180   |     3    |     1    |   5   |
//                      --------------------------------------------------------------------
//                      | Mineralne normy dzienne |   2000   |    120   |    40    |   -   |
// Ustalić dzienny zestaw paszowy o minimalnych kosztach przy dodatkowym założeniu, że w normie dziennej ilość siana
// nie przekroczy 10 kilogramów.
// Odp.: Minimalny koszt 91 złotych uzyskamy dla zestawu paszowego: 10 kg siana, 13 kg kiszonki, 7 kg paszy treściwej.

public class PlanowaniePaszyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] produkcja = {{50, 6, 2, 3},        // Siano
                             {20, 4, 1, 2},        // Kiszonka
                             {180, 3, 1, 5}};      // Pasza treściowa
        StringBuilder rzeczy = new StringBuilder();
        int kosztMin = 999;      // Minimalny koszt

        for (int s = 0; s <= 10; s++)
        {
            for (int k = 0; k <= 500; k++)
            {
                for (int pt = 0; pt <= 500; pt++)
                {
                    int dzienneBia = produkcja[0][0] * s + produkcja[1][0] * k + produkcja[2][0] * pt;        // Aktualne dzienne białko
                    if (dzienneBia < 2000) continue;
                    int dzienneWap = produkcja[0][1] * s + produkcja[1][1] * k + produkcja[2][1] * pt;        // Aktualne dzienne wapno
                    if (dzienneWap < 120) continue;
                    int dzienneWit = produkcja[0][2] * s + produkcja[1][2] * k + produkcja[2][2] * pt;        // Aktualne dzienne witaminy
                    if (dzienneWit < 40) continue;
                    int koszt = produkcja[0][3] * s + produkcja[1][3] * k + produkcja[2][3] * pt;             // Aktualny koszt
                    if (koszt <= kosztMin)
                    {
                        kosztMin = koszt;
                        rzeczy.delete(0, rzeczy.length());
                        rzeczy.append(s).append("kg siana, ").append(k).append("kg kiszonki, ").append(pt).append("kg paszy treściwej");
                    }
                }
            }
        }
        System.out.println("Użyte paszy: " + rzeczy);
        System.out.println("Koszt: " + kosztMin + "zł");
    }
}
