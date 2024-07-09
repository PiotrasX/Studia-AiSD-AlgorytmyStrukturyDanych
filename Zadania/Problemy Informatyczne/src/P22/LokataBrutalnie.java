package P22;

// Dysponujesz kwotą 'x' złotych. Zaoferowano Ci umieszczenie tej kwoty na lokacie terminowej oprocentowanej
// 'p' procent w skali roku z kapitalizacją odsetek co 6 miesięcy. Jakiej kwoty możesz się spodziewać na
// swoim koncie po trzech miesiącach, dziewięciu miesiącach, po roku, po dwóch latach oraz po trzech latach?
// Wskazówka:
// Jeśli 'x' oznacza wkład początkowy a 'p' oprocentowanie w skali roku na lokacie terminowej z kapitalizacją odsetek
// co 6 miesięcy, to po pół roku na koncie będzie kwota x1 = x + 0.5*p*x a po roku kwota x2 = x1 + 0.5*p*x1.

public class LokataBrutalnie
{
    public static void main(String[] args)
    {
        final int X = 100000;
        final double P = 0.05;
        System.out.println("Kwota po 3 miesiącach: " + (X + 0.25 * P * X));
        double x1 = X + 0.5 * P * X;
        System.out.println("Kwota po 6 miesiącach: " + x1);
        System.out.println("Kwota po 9 miesiącach: " + (x1 + 0.25 * P * x1));
        double x2 = x1 + 0.5 * P * x1;
        System.out.println("Kwota po 1 roku: " + x2);
        double x4 = (x2 + 0.5 * P * x2) + 0.5 * P * (x2 + 0.5 * P * x2);
        System.out.println("Kwota po 2 latach: " + ((double) Math.round(x4 * 100) / 100));
        double x6 = (x4 + 0.5 * P * x4) + 0.5 * P * (x4 + 0.5 * P * x4);
        System.out.println("Kwota po 3 latach: " + ((double) Math.round(x6 * 100) / 100));
    }
}
