package Kolokwium2.StrukturyA;

// Klasa definiuje węzeł drzewa poszukiwań binarnych

public class A5WezelDrzewa5
{
    public int wartosc;                        // Element danych
    public A5WezelDrzewa5 rodzic;              // Rodzic węzła
    public A5WezelDrzewa5 dzieckoLewe;         // Lewy potomek węzła
    public A5WezelDrzewa5 dzieckoPrawe;        // Prawy potomek węzła

    public A5WezelDrzewa5()
    {
        wartosc = 0;
        rodzic = null;
        dzieckoLewe = null;
        dzieckoPrawe = null;
    }

    public String toString() { return "{" + wartosc + "}"; }
}
