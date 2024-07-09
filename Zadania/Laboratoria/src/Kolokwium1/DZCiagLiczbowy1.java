package Kolokwium1;

public class DZCiagLiczbowy1
{
    private static final int N = 5;

    public static void main(String[] args)
    {
        int liczba = obliczCiag(N);
        System.out.println("Obliczona liczba dla N = " + N + " wynosi: " + liczba);
    }

    static int obliczCiag(int i)
    {
        if (i == 1) return 1;
        else if (i == 2) return 3;
        return obliczCiag(i - 1) + obliczCiag(i - 2);
    }
}
