package Kolokwium2.StrukturyA;

public class A3A4ElementListy5
{
    public int wartosc;
    public A3A4ElementListy5 nastepny;
    public A3A4ElementListy5 poprzedni;

    public A3A4ElementListy5(int wartosc)
    {
        this.wartosc = wartosc;
        nastepny = null;
        poprzedni = null;
    }

    public String toString() { return Integer.toString(wartosc); }
}
