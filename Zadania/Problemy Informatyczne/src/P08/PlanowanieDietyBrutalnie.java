package P8;

// Matka chce, aby jej dzieci otrzymały pewne ilości czynników odżywczych w porannej owsiance. Dzieci mogą wybrać
// płatki owsiane firmy A lub firmy B albo mieszaninę tych dwóch. Ich śniadanie powinno zawierać co najmniej
// 1 mg witaminy B1, 5 mg witaminy P P i 400 kalorii. Wiadomo, że 30 g płatków firmy A zawiera 0.1 mg witaminy B1,
// 1 mg witaminy P P i 110 kalorii. Natomiast 30 g płatków firmy B zawiera 0.25 mg witaminy B1, 0.25 mg witaminy P P
// i 120 kalorii. Cena 30 g płatków firmy A i płatków firmy B wynosi odpowiednio 16 i 18 groszy. W jaki sposób
// należy przyrządzić poranna owsiankę, aby spełnione były warunki zdrowotne, a cena produktów była możliwie najniższa.
// Odp.: Minimalny koszt 116 groszy uzyskamy, jeśli przyrządzimy śniadanie z 5 porcji płatków firmy A
//       i 2 porcji płatków firmy B.

public class PlanowanieDietyBrutalnie
{
    public static void main(String[] args)
    {
        double[][] platki = {{0.1, 1, 110, 16},        // Płatki firmy A
                             {0.25, 0.25, 120, 18}};   // Płatki firmy B
        StringBuilder jakiePlatki = new StringBuilder();
        int kosztMin = 999;      // Minimalny koszt

        for (int p1 = 0; p1 <= 100; p1++)
        {
            for (int p2 = 0; p2 <= 100; p2++)
            {
                double B1 = platki[0][0] * p1 + platki[1][0] * p2;                    // Aktualne witamina B1
                if (B1<1) continue;
                double PP = platki[0][1] * p1 + platki[1][1] * p2;                    // Aktualne witamina P P
                if (PP<5) continue;
                double kcal = platki[0][2] * p1 + platki[1][2] * p2;                  // Aktualne kalorie
                if (kcal<400) continue;
                int koszt = (int) (platki[0][3] * p1 + platki[1][3] * p2);            // Aktualny koszt
                if (koszt <= kosztMin)
                {
                    kosztMin = koszt;
                    jakiePlatki.delete(0, jakiePlatki.length());
                    jakiePlatki.append(p1).append(" porcji płatków A (").append(p1*30).append("g), ").append(p2).append(" porcji płatków B (").append(p2*30).append("g)");
                }
            }
        }
        System.out.println("Użyte płatki: " + jakiePlatki);
        System.out.println("Koszt: " + kosztMin + "gr");
    }
}
