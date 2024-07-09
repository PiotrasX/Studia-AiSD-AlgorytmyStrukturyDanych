package Lab4;

public class PlecakDzielZwyciezajWypisz
{
    final static int N = 6;                // Liczba przedmiotów
    final static int MAX_V = 10;           // Objętość plecaka
    final static int[] V = {6,2,3,2,3,1};  // Objętości przedmiotów
    final static int[] W = {6,4,5,7,10,2}; // Wartości przedmiotów
    
    static int[] p = new int[N]; // Stan plecaka, gdzie nr indeksu odpowiada nr przedmiotu,
                                 // Oraz: wartosc 0 - przedmiot nie został zabrany,
                                 //       wartosc 1 - przedmiot został zapakowany,

    static int plecak(int i, int v)
    {
        int w1; // Wartość, gdy nie bierzemy i-tego przedmiotu
        int w2; // Wartość, gdy bierzemy i-ty przedmiot
        
        // Jeżeli do zapakowania mamy tylko przedmiot z numerem 0 i ...
        
        // ... nie mieści się on do plecaka, to maksymalna wartosc plecaka o objętości v jest równa 0
        if (i == 0 && v < V[0])
        {
            p[i]=0;
            return 0;
        }
        // ... mieści się on do plecaka, to maksymalna wartosc plecaka o objętości v jest równa wartosci tego przedmiotu
        if (i == 0 && v >= V[0])
        {
            p[i]=1;
            return W[0];
        }
        
        // Jeśli mamy więcej niż jeden przedmiot (czyli nie tylko przedmiot z numerem 0) ...
        w1 = plecak(i - 1, v);

        // Jeżeli i-ty przedmiot nie mieści się do plecaka, to maksymalna wartość plecaka
        // o objętości v, zapakowanego sposród przedmiotów ponumerowanych od 0 do i
        // jest równa maksymalnej wartosci plecaka o objętości v, zapakowanego
        // sposród przedmiotów ponumerowanych od 0 do i-1.
        if (i > 0 && v < V[i])
        {
            return w1;
        }
        w2 = W[i] + plecak(i - 1, v - V[i]);

        // Jeżeli i-ty przedmiot mieści się do plecaka, to maksymalna wartosc plecaka
        // o objętości v, zapakowanego sposród przedmiotów ponumerowanych od 0 do i
        // jest równa większej z dwu wartosci:
            // maksymalnej wartości plecaka o objętości v - Vi, zapakowanego sposród przedmiotów
            // ponumerowanych od 0 do i - 1 plus wartosc i-tego przedmiotu,
        // lub
            // maksymalnej wartości plecaka o objętości v, zapakowanego sposród przedmiotów
            // ponumerowanych od 0 do i - 1
        if (w2 > w1)
        {
            p[i] = 1;
            return w2;
        }
        else
        {
            p[i] = 0;
            return w1;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Wartość plecaka: " + plecak(N - 1, MAX_V));
        System.out.print("Przedmioty w plecaku: ");
        for (int i = 0; i < p.length; i++)
        {
            if(p[i]==1) System.out.print((i)+" ");
        }
        System.out.println();
    }
}
