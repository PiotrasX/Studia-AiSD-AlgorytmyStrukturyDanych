package P6;

// Jak odgadnąć liczbę pomyślaną przez rozmówcę z zakresu od 0 do 1000, zadając jak najmniejszą liczbę pytań rozmówcy?
// Przy czym, pytania zadawane rozmówcy muszą być jedynie typu: „Czy to jest liczba 546?”, na które rozmówca może
// odpowiadać na jeden z następujących sposobów: „TAK”, „ZA MAŁA” lub „ZA DUŻA”.

import java.util.Random;

public class LiczbaMonteCarlo
{
    static int duze;
    static int male;
    static Random random = new Random();

    public static void main(String[] args)
    {
        int prawidlowa = random.nextInt(1001);
        int jaka = 500;
        duze = 1001;
        male = 0;
        System.out.println("Wymyślona liczba: " + prawidlowa + "\n");
        jakaLiczba(prawidlowa, jaka,1);
    }

    public static void jakaLiczba(int prawidlowa, int jaka, int podejscia)
    {
        System.out.println("Czy jest to liczba " + jaka + "?");
        if (jaka > prawidlowa)
        {
            System.out.println("ZA DUŻA\n");
            duze = jaka;
            jaka = random.nextInt(duze - male) + male;
            jakaLiczba(prawidlowa, jaka, ++podejscia);
        }
        else if (jaka < prawidlowa)
        {
            System.out.println("ZA MAŁA\n");
            male = jaka + 1;
            jaka = random.nextInt(duze - male) + male;
            jakaLiczba(prawidlowa, jaka, ++podejscia);
        }
        else
        {
            System.out.println("TAK");
            System.out.println("\nGratulacje, zgadłem liczbę za " + podejscia + " razem!");
        }
    }
}
