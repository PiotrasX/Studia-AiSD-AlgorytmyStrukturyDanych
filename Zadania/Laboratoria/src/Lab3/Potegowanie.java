package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Potegowanie
{
    public static void main(String[] args)
    {
        int podstawa, wykladnik, wynik;

        try { System.out.print("Wprowadź podstawę potęgi (liczba całkowita): "); podstawa = inputInt(); }
        catch (InputMismatchException e) { podstawa = 0; }

        try
        {
            System.out.print("Wprowadź wykładnik potęgi (liczba całkowita nieujemna): ");
            wykladnik = inputInt();
            if (wykladnik < 0) { throw new InputMismatchException(); }
        }
        catch (InputMismatchException e) { wykladnik = 0; }

        wynik = potegowanie(podstawa, wykladnik);
        System.out.println(podstawa + "^" + wykladnik + "=" + wynik);
    }

    public static int potegowanie(int p, int w)
    {
        if (w == 0) return 1;
        else if (w == 1) return p;
        else
        {
            return p*potegowanie(p,w-1);
        }
    }

    public static int inputInt()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
