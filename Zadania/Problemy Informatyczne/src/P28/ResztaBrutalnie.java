package P28;

// Jak wydawać resztę za pomocą możliwie najmniejszej liczby monet o nominałach 1gr, 2gr, 5gr, 10gr, 20gr, 50gr, 1zł,
// 2zł i 5zł. Skonstruuj algorytm, do którego na wejście podajemy pewną sumę pieniędzy, czyli resztę, jaką trzeba
// wydawać; natomiast na wyjściu wypisywane są monety za pomocą których należy tę sumę wydać.

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ResztaBrutalnie
{
    public static void main(String[] args)
    {
        System.out.print("Podaj resztę do wydania (format: zł.gr): ");
        wydawanieReszty(inputBigDecimal());
    }

    public static void wydawanieReszty(BigDecimal reszta)
    {
        String resztaString = String.valueOf(reszta);
        int zlotowki = 0, grosze = 0, gr1 = 0, gr2 = 0, gr5 = 0, gr10 = 0, gr20 = 0, gr50 = 0;
        int zl1 = 0, zl2 = 0, zl5 = 0;
        for (int i = 0; i < resztaString.length(); i++)
        {
            if (resztaString.charAt(i) == '.')
            {
                zlotowki = Integer.parseInt(resztaString.substring(0, i));
                grosze = Integer.parseInt(resztaString.substring(i + 1));
            }
        }
        while (true) { if (zlotowki >= 5) { zl5++; zlotowki -= 5; } else { break; } }
        while (true) { if (zlotowki >= 2) { zl2++; zlotowki -= 2; } else { break; } }
        while (true) { if (zlotowki >= 1) { zl1++; zlotowki -= 1; } else { break; } }
        while (true) { if (grosze >= 50) { gr50++; grosze -= 50; } else { break; } }
        while (true) { if (grosze >= 20) { gr20++; grosze -= 20; } else { break; } }
        while (true) { if (grosze >= 10) { gr10++; grosze -= 10; } else { break; } }
        while (true) { if (grosze >= 5) { gr5++; grosze -= 5; } else { break; } }
        while (true) { if (grosze >= 2) { gr2++; grosze -= 2; } else { break; } }
        while (true) { if (grosze >= 1) { gr1++; grosze -= 1; } else { break; } }
        System.out.println("\nReszta do wydania: " + resztaString);
        System.out.println("Wydane nominały: ");
        System.out.println("5zł -> " + zl5);
        System.out.println("2zł -> " + zl2);
        System.out.println("1zł -> " + zl1);
        System.out.println("50gr -> " + gr50);
        System.out.println("20gr -> " + gr20);
        System.out.println("10gr -> " + gr10);
        System.out.println("5gr -> " + gr5);
        System.out.println("2gr -> " + gr2);
        System.out.println("1gr -> " + gr1);
    }

    public static BigDecimal inputBigDecimal()
    {
        String reszta;
        try
        {
            Scanner scanner = new Scanner(System.in);
            reszta = scanner.nextLine();
            boolean czyZmienna = false;
            int indeks = 0;
            for (int i = 0; i < reszta.length(); i++)
            {
                if (reszta.charAt(i) == ',' || reszta.charAt(i) == '.')
                {
                    reszta = reszta.substring(0, i) + "." + reszta.substring(i + 1);
                    czyZmienna = true; indeks = i;
                }
            }
            if (!czyZmienna) reszta = reszta + ".00";
            if (czyZmienna && reszta.substring(indeks + 1).isEmpty()) reszta = reszta + "00";
            if (czyZmienna && reszta.substring(indeks + 1).length() > 2) reszta = reszta.substring(0, indeks + 3);
            if (czyZmienna && reszta.substring(indeks + 1).length() == 1) reszta = reszta.substring(0, indeks + 2) + "0";
            return new BigDecimal(reszta);
        }
        catch (InputMismatchException | NumberFormatException e) { return new BigDecimal(0); }
    }
}
