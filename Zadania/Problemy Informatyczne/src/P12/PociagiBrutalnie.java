package P12;

// Z miejscowości wypoczynkowej można w końcu sezonu wysłać najwyżej 12 pociągów dziennie. Są to pociągi spalinowe
// (tzn. z lokomotywami o napędzie spalinowym) albo elektryczne (tzn. z lokomotywami o napędzie elektrycznym).
// Wszystkie miejsca w tych pociągach są numerowane (czyli są to tzw. „miejscówki”). W skład każdego pociągu
// spalinowego wchodzi 2 wagony 80-osobowe i 4 wagony 48-osobowe. Natomiast w skład każdego pociągu elektrycznego
// wchodzi 5 wagonów 80-osobowych i 2 wagony 48-osobowe. Stacja może wysłać dziennie najwyżej 42 wagony 80-osobowe
// i najwyżej 40 wagonów 48 osobowych. Ile i jakich pociągów należy wysłać dziennie, aby liczba przewiezionych
// pasażerów była możliwie największa? Przyjąć, że liczba lokomotyw każdego rodzaju nie jest ograniczona.
// Odp.: Liczba przewiezionych pasażerów będzie największa i wyniesie 5088 osób, jeżeli będziemy codziennie
//       wysyłać 6 pociągów spalinowych i 6 pociągów elektrycznych.

public class PociagiBrutalnie
{
    public static void main(String[] args)
    {
        int[][] pociagi = {{2, 4},      // Spalinowy
                           {5, 2}};     // Elektryczny
        StringBuilder jakiePociagi = new StringBuilder();
        int pasazerowieMax = 0;

        for (int pSpal = 0; pSpal <= 12; pSpal++)
        {
            for (int pEle = 0; pEle <= 12; pEle++)
            {
                if (pSpal + pEle > 12) break;
                int wag80 = pociagi[0][0] * pSpal + pociagi[1][0] * pEle;         // Aktualne wagonów 80-osobowych
                if (wag80 > 42) continue;
                int wag48 = pociagi[0][1] * pSpal + pociagi[1][1] * pEle;         // Aktualne wagonów 48-osobowych
                if (wag48 > 40) continue;
                int pasazerowie = wag80 * 80 + wag48 * 48;                        // Aktualny koszt
                if (pasazerowie>=pasazerowieMax)
                {
                    pasazerowieMax = pasazerowie;
                    jakiePociagi.delete(0, jakiePociagi.length());
                    jakiePociagi.append(pSpal).append(" pociągów spalinowych, ").append(pEle).append(" pociągów elektrycznych");
                }
            }
        }
        System.out.println("Użyte pociągi: " + jakiePociagi);
        System.out.println("Maksymalna liczba pasażerów: " + pasazerowieMax);
    }
}
