package Kolokwium2.StrukturyA;

// Implementacja listy powiązanej liczb całkowitych – lista powiązana dwukierunkowa.

public class A3ListaPowiazanaDwukierunkowa5
{
    private A3A4ElementListy5 pierwszyElement;
    private A3A4ElementListy5 ostatniElement;

    public A3ListaPowiazanaDwukierunkowa5()
    {
        pierwszyElement = null;
        ostatniElement = null;
    }

    public boolean isEmpty() { return pierwszyElement == null; }

    public void insertFirst(int wartosc)
    {
        A3A4ElementListy5 nowyElement = new A3A4ElementListy5(wartosc);

        if (isEmpty()) ostatniElement = nowyElement;
        else pierwszyElement.poprzedni = nowyElement;

        nowyElement.nastepny = pierwszyElement;
        pierwszyElement = nowyElement;
    }

    public void insertLast(int wartosc)
    {
        A3A4ElementListy5 nowyElement = new A3A4ElementListy5(wartosc);

        if (isEmpty()) pierwszyElement = nowyElement;
        else ostatniElement.nastepny = nowyElement;

        nowyElement.poprzedni = ostatniElement;
        ostatniElement = nowyElement;
    }

    public A3A4ElementListy5 deleteFirst()
    {
        if (isEmpty()) return null;

        A3A4ElementListy5 zwroc = pierwszyElement;
        if (pierwszyElement.nastepny == null) ostatniElement = null;
        else pierwszyElement.nastepny.poprzedni = null;
        pierwszyElement = pierwszyElement.nastepny;
        return zwroc;
    }

    public A3A4ElementListy5 deleteLast()
    {
        if (isEmpty()) return null;

        A3A4ElementListy5 zwroc = ostatniElement;
        if (pierwszyElement.nastepny == null) pierwszyElement = null;
        else ostatniElement.poprzedni.nastepny = null;
        ostatniElement = ostatniElement.poprzedni;
        return zwroc;
    }

    public boolean find(int element)
    {
        if (isEmpty()) return false;

        A3A4ElementListy5 obecny = pierwszyElement;
        while (obecny.wartosc != element)
        {
            if (obecny.nastepny == null) return false;
            else obecny = obecny.nastepny;
        }
        return true;
    }

    public A3A4ElementListy5 delete(int element)
    {
        if (isEmpty()) return null;

        A3A4ElementListy5 obecny = pierwszyElement;
        A3A4ElementListy5 poprzedni = null;

        while (obecny.wartosc != element)
        {
            if (obecny.nastepny == null) return null;
            else
            {
                poprzedni = obecny;
                obecny = obecny.nastepny;
            }
        }

        if (poprzedni == null) pierwszyElement = pierwszyElement.nastepny;
        else poprzedni.nastepny = obecny.nastepny;

        return obecny;
    }

    public void print()
    {
        System.out.print("Lista: ");
        A3A4ElementListy5 obecny = pierwszyElement;
        while (obecny != null)
        {
            System.out.print(obecny + " ");
            obecny = obecny.nastepny;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        A3ListaPowiazanaDwukierunkowa5 lista = new A3ListaPowiazanaDwukierunkowa5();

        lista.insertFirst(2);
        lista.insertFirst(4);
        lista.insertFirst(6);
        lista.print();

        lista.insertLast(1);
        lista.insertLast(3);
        lista.insertLast(5);
        lista.print();

        lista.deleteFirst();
        lista.print();

        lista.deleteFirst();
        lista.print();

        lista.deleteLast();
        lista.print();
    }
}
