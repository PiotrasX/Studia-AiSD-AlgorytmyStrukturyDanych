package P6;

// Jak odgadnąć liczbę pomyślaną przez rozmówcę z zakresu od 0 do 1000, zadając jak najmniejszą liczbę pytań rozmówcy?
// Przy czym, pytania zadawane rozmówcy muszą być jedynie typu: „Czy to jest liczba 546?”, na które rozmówca może
// odpowiadać na jeden z następujących sposobów: „TAK”, „ZA MAŁA” lub „ZA DUŻA”.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class LiczbaBrutalnie
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int jaka = random.nextInt(1001);
        duze.add(1000);
        male.add(0);
        jakaLiczba(jaka, 1);
    }

    static List<Integer> duze = new ArrayList<>();
    static List<Integer> male = new ArrayList<>();

    public static void jakaLiczba(int jaka, int podejscia)
    {
        System.out.println("Czy jest to liczba " + jaka + "?");
        String odpowiedz = inputString();
        odpowiedz = odpowiedz.toUpperCase();
        switch (odpowiedz)
        {
            case "ZA DUŻA", "ZA DUZA" ->
            {
                duze.add(jaka);
                jaka = Collections.min(duze) - (Math.abs(Collections.min(duze) - Collections.max(male)) / 2);
                System.out.println();
                jakaLiczba(jaka, ++podejscia);
            }
            case "ZA MAŁA", "ZA MALA" ->
            {
                male.add(jaka);
                jaka = Collections.max(male) + (Math.abs(Collections.min(duze) - Collections.max(male)) / 2);
                System.out.println();
                jakaLiczba(jaka, ++podejscia);
            }
            case "TAK" -> System.out.println("\nGratulacje, zgadłem liczbę za " + podejscia + " razem!");
            default ->
            {
                System.out.println("\nWprowadzono nieprawidłową odpowiedź!");
                jakaLiczba(jaka, podejscia);
            }
        }
    }

    public static String inputString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
