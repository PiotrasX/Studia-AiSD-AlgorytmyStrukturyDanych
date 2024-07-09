package P18;

// Producent materiałów tekstylnych dostarcza swoje wyroby klientom cięte w belach, przy czym posiada on dwie maszyny
// tnące A i B. Maszyna A może ciąć standardową belę o szerokości 250 cm, a maszyna B może ciąć standardową belę
// o szerokości 200 cm. Bele są sprzedawane w kilku szerokościach proponowanych przez klientów. Zamówienia określają
// więc żądane szerokości oraz wymieniają ilość bel, jaka ma być dostarczona z każdej szerokości. Przy dopasowaniu
// listy zamówień do dostępnych bel standardowych i maszyn tnących, zwykle zdarza się, że na skutek obcinania
// zbywających kawałków końcowych straty są nieuniknione. Problem polega więc na dopasowaniu zamówień do bel i maszyn
// w taki sposób, aby obniżyć straty do absolutnego minimum. Zgodnie z ostatnimi zamówieniami, należy pociąć
// standardowe bele w taki sposób, aby otrzymać: 862 bele o szerokości 112 cm, 341 bel o szerokości 90 cm, 87 bel
// o szerokości 77 cm i 216 bel o szerokości 35 cm. Zakładamy, że jest dostępne tyle standardowych bel, ile jest
// konieczne i że wszystkie cięcia wykonywane są celem uzyskania tylko bel o zamówionych szerokościach.

public class CiecieBrutalnie
{
    public static int WSZYSTKIE_ODPADKI_B250 = 0; // Wszystkie odpadki belki 250 cm
    public static int WSZYSTKIE_ODPADKI_B200 = 0; // Wszystkie odpadki belki 200 cm
    public static int ODPADKI_B250 = 0; // Bieżące odpadki belki 250 cm
    public static int ODPADKI_B200 = 0; // Bieżące odpadki belki 200 cm
    public static int UZYTE_B250 = 0; // Użyte belki 250 cm
    public static int UZYTE_B200 = 0; // Użyte belki 200 cm
    public static int b112 = 862, b90 = 341, b77 = 87, b35 = 216; // Ilość konkretnych belek
    public static final int N = 4; // Ilość belek do cięcia
    public static int[] tablicaPermutacji = new int[N + 1]; // Tablica permutacji
    public static int[] tablicaOdpadkowB250 = new int[N + 1]; // Tablica z bieżącymi użytymi belkami w cięciu belki 250 cm
    public static int[] tablicaOdpadkowB200 = new int[N + 1]; // Tablica z bieżącymi użytymi belkami w cięciu belki 200 cm

    public static void main(String[] args)
    {
        while (b112 + b90 + b77 + b35 != 0)
        {
            podzbiory();
            System.out.println("Przeanalizowano " + (1506 - b112 - b90 - b77 - b35) + " z 1506 belek do wycięcia");
        }
        System.out.println("\nOdpadki z bel 200cm: " + WSZYSTKIE_ODPADKI_B200 + "cm");
        System.out.println("Odpadki z bel 250cm: " + WSZYSTKIE_ODPADKI_B250 + "cm");
        System.out.println("Odpadki razem: " + (WSZYSTKIE_ODPADKI_B200 + WSZYSTKIE_ODPADKI_B250) + "cm");
        System.out.println("Użyte belki 200cm: " + UZYTE_B200);
        System.out.println("Użyte belki 250cm: " + UZYTE_B250);
    }

    private static void podzbiory()
    {
        ODPADKI_B250 = 250;
        ODPADKI_B200 = 200;
        System.arraycopy(tablicaPermutacji, 0,tablicaOdpadkowB200, 0, 5);
        System.arraycopy(tablicaPermutacji, 0,tablicaOdpadkowB250, 0, 5);
        int iloscPermutacji = (int) Math.pow(2, N);
        for (int permutacja = 0; permutacja < iloscPermutacji; permutacja++)
        {
            int odpadkiB200 = 200, odpadkiB250 = 250;
            boolean czyWazne = true;
            if (tablicaPermutacji[0] == 1 && b112 > 0)
                { odpadkiB200 -= 112; odpadkiB250 -= 112; }
            if (tablicaPermutacji[0] == 1 && b112 <= 0)
                { czyWazne = false; }
            if (tablicaPermutacji[1] == 1 && b90 > 0)
                { odpadkiB200 -= 90; odpadkiB250 -= 90; }
            if (tablicaPermutacji[1] == 1 && b90 <= 0)
                { czyWazne = false; }
            if (tablicaPermutacji[2] == 1 && b77 > 0)
                { odpadkiB200 -= 77; odpadkiB250 -= 77; }
            if (tablicaPermutacji[2] == 1 && b77 <= 0)
                { czyWazne = false; }
            if (tablicaPermutacji[3] == 1 && b35 > 0)
                { odpadkiB200 -= 35; odpadkiB250 -= 35; }
            if (tablicaPermutacji[3] == 1 && b35 <= 0)
                { czyWazne = false; }

            if (czyWazne)
            {
                if (odpadkiB200 > 0 && odpadkiB250 > 0)
                {
                    if (odpadkiB200 <= odpadkiB250)
                    {
                        if (odpadkiB200 <= ODPADKI_B200)
                        { ODPADKI_B200=odpadkiB200; System.arraycopy(tablicaPermutacji,0,tablicaOdpadkowB200,0,5); }
                    }
                    else
                    {
                        if (odpadkiB250 <= ODPADKI_B250)
                        { ODPADKI_B250 = odpadkiB250; System.arraycopy(tablicaPermutacji,0,tablicaOdpadkowB250,0,5); }
                    }
                }
                else if (odpadkiB200 > 0)
                {
                    if (odpadkiB200 <= ODPADKI_B200)
                    { ODPADKI_B200 = odpadkiB200; System.arraycopy(tablicaPermutacji,0,tablicaOdpadkowB200,0,5); }
                }
                else if (odpadkiB250 > 0)
                {
                    if (odpadkiB250 <= ODPADKI_B250)
                    { ODPADKI_B250 = odpadkiB250; System.arraycopy(tablicaPermutacji,0,tablicaOdpadkowB250,0,5); }
                }
            }

            int sprawdzenieLubPodmiana = 0;
            do
            {
                if (tablicaPermutacji[sprawdzenieLubPodmiana] == 1 && sprawdzenieLubPodmiana < 4)
                    { tablicaPermutacji[sprawdzenieLubPodmiana] = 0; sprawdzenieLubPodmiana++; }
                else
                    { tablicaPermutacji[sprawdzenieLubPodmiana] = 1; break; }
            } while(true);
        }

        if (ODPADKI_B200 <= ODPADKI_B250)
        {
            WSZYSTKIE_ODPADKI_B200 += ODPADKI_B200;
            UZYTE_B200++;
            if (tablicaOdpadkowB200[0] == 1) { b112--; }
            if (tablicaOdpadkowB200[1] == 1) { b90--; }
            if (tablicaOdpadkowB200[2] == 1) { b77--; }
            if (tablicaOdpadkowB200[3] == 1) { b35--; }
        }
        else
        {
            WSZYSTKIE_ODPADKI_B250 += ODPADKI_B250;
            UZYTE_B250++;
            if (tablicaOdpadkowB250[0] == 1) { b112--; }
            if (tablicaOdpadkowB250[1] == 1) { b90--; }
            if (tablicaOdpadkowB250[2] == 1) { b77--; }
            if (tablicaOdpadkowB250[3] == 1) { b35--; }
        }
    }
}
