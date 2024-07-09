package P24;

// Rozważmy proces rozmnażania bakterii. Zakładamy, że bakterie znajdują się w środowisku o stałych parametrach,
// w związku z czym szybkość i sposób ich rozmnażania jest stały. Wiadomo, że bakterie rozmnażają się przez podział,
// w którego wyniku z jednej bakterii powstaje 2 nowe. Podział ten następuje co 2 minuty. Przyjąć, że wszystkie
// bakterie dzielą się w tych samych chwilach. Po jakim czasie liczba bakterii zwiększy się 1000 razy, 10000 razy,
// 100000 razy oraz 1 mln razy.

public class BakterieDzielZwyciezaj
{
    public static void main(String[] args)
    {
        int[] cele = {1000, 10000, 100000, 1000000}; // Cele rozmnażania bakterii
        for (int cel : cele)
        {
            int czas = obliczCzas(1, cel, 0);
            System.out.println("Populacja zwiększyła się " + cel + " razy po " + czas + " minutach");
        }
    }

    public static int obliczCzas(int aktualnaLiczbaBakterii, int cel, int aktualnyCzas)
    {
        if (aktualnaLiczbaBakterii >= cel) return aktualnyCzas;
        else return obliczCzas(aktualnaLiczbaBakterii * 2, cel, aktualnyCzas + 2); // Obliczanie ilości bakterii
    }
}
