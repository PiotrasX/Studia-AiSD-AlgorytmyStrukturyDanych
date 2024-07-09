package P25;

// Pewna rodzina łososi rozwija się zgodnie z prawem Malthusa, co można wyrazić w ten sposób, że jeśli wielkość
// populacji w chwili t wynosi p(t), to w wyniku naturalnego rozrodu populacji w chwili t+1 jej wielkość wynosi:
//                                              p(t+1) = p(t) * e^0.003
// gdzie t jest czasem mierzonym w minutach. Rekiny, które zagnieździły się na wodach zasiedlonych przez łososie,
// zjadają 4 promile populacji łososi na minutę. Poza tym, ze względu na niekorzystne warunki 4 promile łososi z całej
// populacji na minutę odpływa z tych wód. Wiedząc, że w chwili początkowej było milion łososi, odpowiedzieć na pytanie,
// jak będzie zmieniać się liczebność populacji łososi tzn. jeśli liczebność będzie się zmniejszać, to kiedy osiągnie
// jakieś istotne progi (np.: 1/2, 1/3, 1/10, 1/100 początkowej liczebności) oraz czy i kiedy populacja łososi na
// omawianym obszarze wymrze. Za moment wymarcia populacji łososi uważamy sytuację, kiedy liczebność łososi spadnie
// poniżej 100 sztuk.

public class LososieRekinyDzielZwyciezaj
{
    static final int PROG_MINIMUM = 100; // Kiedy populacja umrze
    static final double WSP_ROZMNAZANIA = Math.pow(Math.E, 0.003); // Ile łososi będzie, kiedy się rozmnożą
    static final double WSP_UMIERALNOSCI = 0.996; // Ile łososi będzie, kiedy umrą lub zostaną zjedzone
    static final double POCZATKOWO_LOSOSI = 1_000_000; // Początkowa liczba łososi
    static int[] CELE = {500_000, 333_333, 100_000, 10_000}; // Cele populacji
    static int CEL = 0; // Cel populacji

    public static void main(String[] args) { obliczLososie(1_000_000, 0); }

    static void obliczLososie(double liczbaLososi, int minuta)
    {
        double nowaLiczbaLososi = liczbaLososi * WSP_ROZMNAZANIA * WSP_UMIERALNOSCI * WSP_UMIERALNOSCI;
        int czasSkoku = 1; // Można dostosować do większych skoków czasowych

        if (nowaLiczbaLososi < PROG_MINIMUM)
        {
            System.out.println("Populacja łososi wymrze po " + (minuta + czasSkoku) + " minutach");
            return;
        }

        if (CEL < CELE.length && nowaLiczbaLososi < CELE[CEL])
        {
            System.out.println("Populacja łososi osiągnie 1/" + ((int)POCZATKOWO_LOSOSI/CELE[CEL]) + " początkowej populacji po " + (minuta + czasSkoku) + " minutach");
            CEL++;
        }

        obliczLososie(nowaLiczbaLososi, minuta + czasSkoku); // Rekurencyjne wywołanie z nową liczbą łososi i zaktualizowanym czasem
    }
}
