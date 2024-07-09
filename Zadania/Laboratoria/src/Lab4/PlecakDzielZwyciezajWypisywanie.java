package Lab4;

public class PlecakDzielZwyciezajWypisywanie
{
    final static int N = 6;                // Liczba przedmiotów
    final static int MAX_V = 10;           // Objętość plecaka
    final static int[] V = {6,2,3,2,3,1};  // Objętości przedmiotów
    final static int[] W = {6,4,5,7,10,2}; // Wartości przedmiotów

    static class Plecak
    {
        int wartosc;
        int[] zawartosc = new int[N];
    }

    public static void main(String[] args)
    {
        Plecak p = P(N - 1, MAX_V);
        System.out.println("Wartość plecaka: " + p.wartosc);
        System.out.print("Przedmioty w plecaku: ");
        for (int i = 0; i < N; i++)
        {
            if (p.zawartosc[i] == 1) System.out.print(i + " ");
        }
        System.out.println();
    }

    static Plecak P(int i, int v)
    {
        Plecak p1 = new Plecak(); // Plecak, gdy nie bierzemy i-tego przedmiotu
        Plecak p2 = new Plecak(); // Plecak, gdy bierzemy i-ty przedmiot
        if (i == 0 && v < V[0])
        {
            p1.zawartosc[0] = 0;
            p1.wartosc = 0;
            return p1;
        }
        if (i == 0 && v >= V[0])
        {
            p2.zawartosc[0] = 1;
            p2.wartosc = W[0];
            return p2;
        }
        Plecak p = P(i - 1, v);
        p1.zawartosc = p.zawartosc;
        p1.zawartosc[i] = 0;
        p1.wartosc = p.wartosc;
        if (i > 0 && v < V[i]) return p1;
        p = P(i - 1, v - V[i]);
        p2.zawartosc = p.zawartosc;
        p2.zawartosc[i] = 1;
        p2.wartosc = W[i] + p.wartosc;
        if (p2.wartosc > p1.wartosc) return p2;
        else return p1;
    }
}
