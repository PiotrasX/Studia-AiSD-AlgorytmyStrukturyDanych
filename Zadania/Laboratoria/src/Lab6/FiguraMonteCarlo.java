package Lab6;

import java.util.Random;

public class FiguraMonteCarlo
{
    final private static int ILE_PUNKTOW = 10000; // Ile losowań punktów
    private static int ILE_DOBRYCH_PUNKTOW = 0; // Ile punktów należy lub leży pod wykresem (należy do figury)

    public static void main(String[] args)
    {
        Random random = new Random();
        for (int i = 0; i < ILE_PUNKTOW; i++)
        {
            double x = (double) random.nextInt(100001) / 100000; // Losowanie wartości punktu dla współrzędnej x
            double y = (double) random.nextInt(100001) / 100000; // Losowanie wartości punktu dla współrzędnej y
            double Y = Math.sin(x); // Wyliczenie wartości maksymalnej, jaką może przyjąć wartość x
            if (y <= Y) ILE_DOBRYCH_PUNKTOW++; // Jeśli wartość się mieści, dodaj liczbę dobrych punktów
        }
        double pole = (double) ILE_DOBRYCH_PUNKTOW / ILE_PUNKTOW; // Obliczanie pola figury
        System.out.println("Pole figury: " + pole);
    }
}
