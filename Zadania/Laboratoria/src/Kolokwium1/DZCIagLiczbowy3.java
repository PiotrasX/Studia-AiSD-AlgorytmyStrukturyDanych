package Kolokwium1;

public class DZCIagLiczbowy3
{
    private static final int N = 8;

    public static void main(String[] args)
    {
        int liczba = obliczCiag(N);
        System.out.println("Obliczona liczba dla N = " + N + " wynosi: " + liczba);
    }

    private static int obliczCiag(int n)
    {
        if (n == 1) return 2;
        else if (n == 2) return 4;
        return ((obliczCiag(n - 1) * obliczCiag(n - 2)) / 2);
    }
}
