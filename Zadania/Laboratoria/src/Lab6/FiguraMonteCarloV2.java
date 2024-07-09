package Lab6;

import java.util.Random;

public class FiguraMonteCarloV2
{
    final private static int ILE_PUNKTOW = 10000; // Ile losowań punktów
    private static int ILE_DOBRYCH_PUNKTOW = 0; // Ile punktów należy lub leży pod wykresem (należy do figury)

    public static void main(String[] args)
    {
        Random random = new Random();
        for (int i = 0; i < ILE_PUNKTOW; i++)
        {
            double x = (double) (random.nextInt(80001) + 20000) / 100000; // Losowanie wartości punktu dla współrzędnej x od (od 0,2 do 1)
            double y = (double) (random.nextInt(80001)) / 100000; // Losowanie wartości punktu dla współrzędnej y (od 0 do 0,8)
            double Y = Math.sin(x); // Wyliczenie wartości maksymalnej, jaką może przyjąć wartość x
            if (y <= Y) ILE_DOBRYCH_PUNKTOW++; // Jeśli wartość się mieści, dodaj liczbę dobrych punktów
        }
        double pole = (double) ILE_DOBRYCH_PUNKTOW / ILE_PUNKTOW; // Obliczanie pola figury
        System.out.println("Pole figury: " + pole);
        System.out.println("Przedziały x=<0.2;1> y=<0;0.8>");
    }
}
