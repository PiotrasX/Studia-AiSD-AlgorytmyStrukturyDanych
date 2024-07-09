package P6;

// Jak odgadnąć liczbę pomyślaną przez rozmówcę z zakresu od 0 do 1000, zadając jak najmniejszą liczbę pytań rozmówcy?
// Przy czym, pytania zadawane rozmówcy muszą być jedynie typu: „Czy to jest liczba 546?”, na które rozmówca może
// odpowiadać na jeden z następujących sposobów: „TAK”, „ZA MAŁA” lub „ZA DUŻA”.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class LiczbaBrutalnieV2
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int prawidlowa = random.nextInt(1001);
        int jaka = 500;
        duze.add(1000);
        male.add(0);
        System.out.println("Wymyślona liczba: " + prawidlowa + "\n");
        jakaLiczba(prawidlowa, jaka,1);
    }

    static List<Integer> duze = new ArrayList<>();
    static List<Integer> male = new ArrayList<>();

    public static void jakaLiczba(int prawidlowa, int jaka, int podejscia)
    {
        System.out.println("Czy jest to liczba " + jaka + "?");
        if (jaka > prawidlowa)
        {
            System.out.println("ZA DUŻA");
            duze.add(jaka - 1);
            jaka = Collections.min(duze) - (Math.abs(Collections.min(duze) - Collections.max(male)) / 2);
            System.out.println();
            jakaLiczba(prawidlowa, jaka, ++podejscia);
        }
        else if (jaka < prawidlowa)
        {
            System.out.println("ZA MAŁA");
            male.add(jaka + 1);
            jaka = Collections.max(male) + (Math.abs(Collections.min(duze) - Collections.max(male)) / 2);
            System.out.println();
            jakaLiczba(prawidlowa, jaka, ++podejscia);
        }
        else
        {
            System.out.println("TAK");
            System.out.println("\nGratulacje, zgadłem liczbę za " + podejscia + " razem!");
        }
    }
}
