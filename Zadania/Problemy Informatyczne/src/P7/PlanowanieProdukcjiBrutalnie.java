package P7;

// Wytwórca mebli produkuje stoły, krzesła, biurka i szafy biblioteczne. Do produkcji wykorzystuje dwa typy desek.
// W magazynie wytwórca posiada 1500 m pierwszego typu desek i 1000 m drugiego. Dysponuje kapitałem 860 godzin
// roboczych na wykonanie całej pracy. Przewidywane zapotrzebowanie plus potwierdzone zamówienia wymagają wykonania
// co najmniej 40 stołów, 130 krzeseł, 30 biurek i nie więcej niż 10 szaf bibliotecznych. Każdy stół, krzesło, biurko
// i szafa biblioteczna wymaga odpowiednio 5, 1, 9 i 12 m desek pierwszego typu i 2, 3, 4 i 1 m desek drugiego typu.
// Na wykonanie stołu potrzebne są 3 godziny pracy, krzesła 2 godziny, biurka 5 godzin i szafy bibliotecznej 10 godzin.
// Przy sprzedaży jednego stołu, krzesła, biurka i szafy bibliotecznej wytwórca osiąga zysk odpowiednio 48 złotych,
// 20 złotych, 60 złotych i 40 złotych. Zaplanować produkcję mebli w ten sposób, aby wytwórca wywiązał się
// z przyjętych zamówień i osiągnął maksymalny zysk.
// Odp.: Wytwórca otrzyma maksymalny zysk 11600 złotych, jeżeli wyprodukuje 150 stołów, 130 krzeseł i 30 biurek.

public class PlanowanieProdukcjiBrutalnie
{
    public static void main(String[] args)
    {
        int[][] produkcja = {{5, 1, 9, 12},        // Deski pierwszego typu
                             {2, 3, 4, 1},         // Deski drugiego typu
                             {3, 2, 5, 10},        // Czas produkcji
                             {48, 20, 60, 40}};    // Zysk
        StringBuilder rzeczy = new StringBuilder();
        int zyskMax = 0;                           // Maksymalny zysk

        for (int s = 40; s <= 500; s++)
        {
            for (int k = 130; k <= 500; k++)
            {
                for (int b = 30; b <= 500; b++)
                {
                    for (int sb = 0; sb <= 10; sb++)
                    {
                        int dPier = produkcja[0][0] * s + produkcja[0][1] * k + produkcja[0][2] * b + produkcja[0][3] * sb;      // Aktualne użyte deski pierwszego rodzaju
                        if (dPier > 1500) continue;
                        int dDru = produkcja[1][0 ]* s + produkcja[1][1] * k + produkcja[1][2] * b + produkcja[1][3] * sb;       // Aktualne użyte deski drugiego rodzaju
                        if (dDru > 1000) continue;
                        int h = produkcja[2][0] * s + produkcja[2][1] * k + produkcja[2][2] * b + produkcja[2][3] * sb;          // Aktualny czas produkcji
                        if (h > 860) continue;
                        int zysk = produkcja[3][0] * s + produkcja[3][1] * k + produkcja[3][2] * b + produkcja[3][3] * sb;       // Aktualny zysk
                        if (zysk >= zyskMax)
                        {
                            zyskMax = zysk;
                            rzeczy.delete(0, rzeczy.length());
                            rzeczy.append(s).append(" stołów, ").append(k).append(" krzeseł, ").append(b).append(" biurek, ").append(sb).append(" szaf bibliotecznych");
                        }
                    }
                }
            }
        }
        System.out.println("Użyte przedmioty: " + rzeczy);
        System.out.println("Zysk: " + zyskMax + "zł");
    }
}
