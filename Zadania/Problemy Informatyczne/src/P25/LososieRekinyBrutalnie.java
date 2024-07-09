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

public class LososieRekinyBrutalnie
{
    public static void main(String[] args) { obliczLososie(1_000_000, 0); }

    static int zobaczPopulacje = 1;

    static void obliczLososie(double liczbaLososi, int minuta)
    {
        minuta++;
        liczbaLososi = liczbaLososi * (Math.pow(Math.E, 0.003));
        liczbaLososi = liczbaLososi * 0.996;
        liczbaLososi = liczbaLososi * 0.996;
        if (liczbaLososi <= 500000 && zobaczPopulacje == 1) { System.out.println("\t\tPopulacja łososi osiągnie 1/2 początkowej populacji po " + minuta + " minutach"); zobaczPopulacje++; }
        if (liczbaLososi <= ((double) 1 / 3) * 1000000 && zobaczPopulacje == 2) { System.out.println("\t\tPopulacja łososi osiągnie 1/3 początkowej populacji po " + minuta + " minutach"); zobaczPopulacje++; }
        if (liczbaLososi <= 100000 && zobaczPopulacje == 3) { System.out.println("\t\tPopulacja łososi osiągnie 1/10 początkowej populacji po " + minuta + " minutach"); zobaczPopulacje++; }
        if (liczbaLososi <= 10000 && zobaczPopulacje == 4) { System.out.println("\t\tPopulacja łososi osiągnie 1/100 początkowej populacji po " + minuta + " minutach"); zobaczPopulacje++; }
        if (liczbaLososi >= 100) { obliczLososie(liczbaLososi, minuta); }
        else { System.out.println("Populacja łososi wymrze po " + minuta + " minutach"); }
    }
}
