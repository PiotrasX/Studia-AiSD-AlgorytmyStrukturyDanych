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

import java.util.HashMap;
import java.util.Map;

public class LososieRekinyDynamicznie
{
    static Map<Integer, Double> wyniki = new HashMap<>(); // Mapa wyników ile jest populacji łososi
    static double AKTUALNIE_LOSOSI = 1_000_000; // Aktualna liczba łososi
    static final double POCZATKOWO_LOSOSI = 1_000_000; // Początkowa liczba łososi
    static final double WSP_ROZMNAZANIA = Math.pow(Math.E, 0.003); // Ile łososi będzie, kiedy się rozmnożą
    static final double WSP_UMIERALNOSCI = 0.996; // Ile łososi będzie, kiedy umrą lub zostaną zjedzone
    static int[] CELE = {500_000, 333_333, 100_000, 10_000, 100}; // Cele populacji
    static int CZAS = 0; // Czas wymarcia populacji

    public static void main(String[] args)
    {
        for (int cel : CELE)
        {
            wyniki.put(cel, AKTUALNIE_LOSOSI);
            CZAS = obliczLososie(cel);
            if (cel == CELE[CELE.length - 1]) { System.out.println("Populacja łososi wymrze po " + CZAS + " minutach"); return; }
            System.out.println("Populacja łososi osiągnie 1/" + ((int) POCZATKOWO_LOSOSI / cel) + " początkowej populacji po " + CZAS +" minutach");
        }
    }

    static int obliczLososie(int cel)
    {
        AKTUALNIE_LOSOSI = wyniki.get(cel);
        if (AKTUALNIE_LOSOSI > cel)
        {
            AKTUALNIE_LOSOSI = AKTUALNIE_LOSOSI * WSP_ROZMNAZANIA * WSP_UMIERALNOSCI * WSP_UMIERALNOSCI;
            CZAS++;
            wyniki.put(cel, AKTUALNIE_LOSOSI);
            return obliczLososie(cel);
        }
        return CZAS;
    }
}
