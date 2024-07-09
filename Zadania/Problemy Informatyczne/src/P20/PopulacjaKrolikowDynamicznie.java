package P20;

// W roku 1202 Leonardo Fibonacci sformułował następujący, obecnie bardzo popularny w informatyce problem, dotyczący
// rozmnażania się królików. Na początku mamy parę nowo narodzonych królików i o każdej parze królików zakładamy, że:
//  • nowa para staje się płodna po miesiącu życia,
//  • każda płodna para rodzi jedną parę nowych królików w miesiącu,
//  • króliki nigdy nie umierają.
// W oparciu o powyższe warunki, Fibonacci sformułował następujące pytanie: ile będzie par królików po upływie roku,
// które można uogólnić pytając o to: ile będzie par królików po upływie 'n' miesięcy? Liczbę tę zwykle oznacza się
// przez Fn, jest ona nazywana liczbą Fibonacciego. Przeprowadzić symulację mająca na celu stwierdzenie:
// po ilu miesiącach populacja królików osiągnie: 100, 1000, 10000, 100000 oraz 1 milion par.

public class PopulacjaKrolikowDynamicznie
{
    public static void main(String[] args)
    {
        final int N = 35; // N-ty wyraz ciągu
        kroliki(N);
    }

    public static void kroliki(int n)
    {
        int[] populacja = new int[n+1];
        populacja[1] = 1;
        populacja[2] = 1;
        int zobacz = 1;
        for (int i = 3; i < populacja.length; i++)
        {
            populacja[i] = populacja[i - 1] + populacja[i - 2];
            if (populacja[i] >= 100 && zobacz == 1) { System.out.println("\nPo " + i + " miesiącach populacja królików przekroczyła liczbę 100 par"); zobacz++; }
            if (populacja[i] >= 1_000 && zobacz == 2) { System.out.println("\nPo " + i + " miesiącach populacja królików przekroczyła liczbę 1_000 par"); zobacz++; }
            if (populacja[i] >= 10_000 && zobacz == 3) { System.out.println("\nPo " + i + " miesiącach populacja królików przekroczyła liczbę 10_000 par"); zobacz++; }
            if (populacja[i] >= 100_000 && zobacz == 4) { System.out.println("\nPo " + i + " miesiącach populacja królików przekroczyła liczbę 100_000 par"); zobacz++; }
            if (populacja[i] >= 1_000_000 && zobacz == 5) { System.out.println("\nPo " + i + " miesiącach populacja królików przekroczyła liczbę 1_000_000 par"); zobacz++; }
        }
    }
}
