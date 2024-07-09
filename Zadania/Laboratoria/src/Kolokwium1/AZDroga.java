package Kolokwium1;

public class AZDroga
{
    private static final int[][] polaczenia = {
            {0, 300, 402, 356, -1, -1, -1, -1, -1},
            {300, 0, -1, -1, 440, 474, -1, -1, -1},
            {402, -1, 0, -1, -1, 330, -1, -1, -1},
            {356, -1, -1, 0, -1, -1, 823, -1, -1},
            {-1, 440, -1, -1, 0, -1, -1, 430, -1},
            {-1, 474, 330, -1, -1, 0, 813, 365, 774},
            {-1, -1, -1, 823, -1, 813, 0, -1, 403},
            {-1, -1, -1, -1, 430, 365, -1, 0, 768},
            {-1, -1, -1, -1, -1, 774, 403, 768, 0} };
    private static final String[] miasta = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt", "Bukareszt", "Zagrzeb", "Sofia"};
    private static final StringBuilder odwiedzoneMiasta = new StringBuilder();
    private static final int[] odwiedzoneMiastaTab = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int dlugoscCalkowita = 0;

    public static void main(String[] args)
    {
        wyszukajPolaczenie();
        wypisz();
    }

    private static void wyszukajPolaczenie()
    {
        int miastoStart = 0; // Warszawa
        odwiedzoneMiasta.append(miasta[miastoStart]);
        odwiedzoneMiastaTab[miastoStart] = 1;

        // Obliczanie najkrótszej drogi
        for (int i = 0; i < miasta.length - 1; i++)
        {
            int nastepneMiasto = getMiastoKolejne(miastoStart);
            if (nastepneMiasto == -1 || nastepneMiasto == 8) break;
            miastoStart = nastepneMiasto;
        }
    }

    private static int getMiastoKolejne(int miastoStart)
    {
        int miastoKolejne = -1;
        int dlugoscNajlepiej = Integer.MAX_VALUE;

        for (int i = 0; i < polaczenia.length; i++)
        {
            if (polaczenia[miastoStart][i] > 0 && odwiedzoneMiastaTab[i] == 0)
            {
                int dlugosc = polaczenia[miastoStart][i];
                if (dlugosc < dlugoscNajlepiej || i == 8)
                {
                    dlugoscNajlepiej = dlugosc;
                    miastoKolejne = i;
                    if (i == 8) break;
                }
            }
        }

        if (miastoKolejne != -1)
        {
            dlugoscCalkowita += dlugoscNajlepiej;
            odwiedzoneMiasta.append(" -> ").append(miasta[miastoKolejne]);
            odwiedzoneMiastaTab[miastoKolejne] = 1;
        }

        return miastoKolejne;
    }

    private static void wypisz()
    {
        System.out.println("Kolejność odwiedzanych miast: " + odwiedzoneMiasta);
        System.out.println("Długość trasy: " + dlugoscCalkowita);
    }
}
