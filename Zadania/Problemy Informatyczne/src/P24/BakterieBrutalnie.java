package P24;

// Rozważmy proces rozmnażania bakterii. Zakładamy, że bakterie znajdują się w środowisku o stałych parametrach,
// w związku z czym szybkość i sposób ich rozmnażania jest stały. Wiadomo, że bakterie rozmnażają się przez podział,
// w którego wyniku z jednej bakterii powstaje 2 nowe. Podział ten następuje co 2 minuty. Przyjąć, że wszystkie
// bakterie dzielą się w tych samych chwilach. Po jakim czasie liczba bakterii zwiększy się 1000 razy, 10000 razy,
// 100000 razy oraz 1 mln razy.

public class BakterieBrutalnie
{
    public static void main(String[] args) { cykl(1, 1, 0); }

    public static void cykl(int bakterie, int kolej, int minuty)
    {
        if (bakterie >= 1000 && kolej == 1) { System.out.println("Populacja zwiększyła się 1000 razy po " + minuty + " minutach"); kolej++; }
        if (bakterie >= 10000 && kolej == 2) { System.out.println("Populacja zwiększyła się 10_000 razy po " + minuty + " minutach"); kolej++; }
        if (bakterie >= 100000 && kolej == 3) { System.out.println("Populacja zwiększyła się 100_000 razy po " + minuty + " minutach"); kolej++; }
        if (bakterie >= 1000000 && kolej == 4) { System.out.println("Populacja zwiększyła się 1_000_000 razy po " + minuty + " minutach"); kolej++; }
        bakterie = bakterie * 2;
        minuty += 2;
        if (bakterie <= Integer.MAX_VALUE / 2) { cykl(bakterie, kolej, minuty); }
    }
}
