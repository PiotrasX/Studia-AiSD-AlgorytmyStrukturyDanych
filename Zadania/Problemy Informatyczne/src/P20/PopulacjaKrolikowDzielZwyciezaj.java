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

public class PopulacjaKrolikowDzielZwyciezaj
{
    public static void main(String[] args) { kroliki(1, 0, 1, 1); }

    public static void kroliki(int mlode, int stare, int miesiac, int zobacz)
    {
        int populacja = mlode + stare;
        if (populacja >= 100 && zobacz == 1) { System.out.println("\nPo " + miesiac + " miesiącach populacja królików przekroczyła liczbę 100 par"); zobacz++; }
        if (populacja >= 1_000 && zobacz == 2) { System.out.println("\nPo " + miesiac + " miesiącach populacja królików przekroczyła liczbę 1_000 par"); zobacz++; }
        if (populacja >= 10_000 && zobacz == 3) { System.out.println("\nPo " + miesiac + " miesiącach populacja królików przekroczyła liczbę 10_000 par"); zobacz++; }
        if (populacja >= 100_000 && zobacz == 4) { System.out.println("\nPo " + miesiac + " miesiącach populacja królików przekroczyła liczbę 100_000 par"); zobacz++; }
        if (populacja >= 1_000_000 && zobacz == 5) { System.out.println("\nPo " + miesiac + " miesiącach populacja królików przekroczyła liczbę 1_000_000 par"); zobacz++; }
        int noweMlode = stare;
        stare += mlode;
        if (stare + mlode <= Integer.MAX_VALUE / 2) { kroliki(noweMlode, stare, miesiac + 1, zobacz); }
    }
}
