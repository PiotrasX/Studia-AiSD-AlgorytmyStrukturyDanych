package Kolokwium2.StrukturyA;

import java.util.Random;

// Implementacja listy powiązanej, uporządkowanej liczb całkowitych – lista powiązana dwukierunkowa.

public class A4UporzadkowanaListaPowiazanaDwukierunkowa5
{
    private A3A4ElementListy5 pierwszyElement;
    private A3A4ElementListy5 ostatniElement;

    public A4UporzadkowanaListaPowiazanaDwukierunkowa5()
    {
        pierwszyElement = null;
        ostatniElement = null;
    }

    public boolean isEmpty() { return pierwszyElement == null; }

    private void insertFirst(int wartosc)
    {
        A3A4ElementListy5 nowyElement = new A3A4ElementListy5(wartosc);

        if (isEmpty()) ostatniElement = nowyElement;
        else pierwszyElement.poprzedni = nowyElement;

        nowyElement.nastepny = pierwszyElement;
        pierwszyElement = nowyElement;
    }

    private void insertLast(int wartosc)
    {
        A3A4ElementListy5 nowyElement = new A3A4ElementListy5(wartosc);

        if (isEmpty()) pierwszyElement = nowyElement;
        else ostatniElement.nastepny = nowyElement;

        nowyElement.poprzedni = ostatniElement;
        ostatniElement = nowyElement;
    }

    public void insert(int wartosc)
    {
        A3A4ElementListy5 nowyElement = new A3A4ElementListy5(wartosc);
        A3A4ElementListy5 poprzedni = null;
        A3A4ElementListy5 obecny = pierwszyElement;

        while (obecny != null && nowyElement.wartosc > obecny.wartosc)
        {
            poprzedni = obecny;
            obecny = obecny.nastepny;
        }

        if (poprzedni == null) insertFirst(wartosc);
        else if (obecny == null) insertLast(wartosc);
        else
        {
            poprzedni.nastepny = nowyElement;
            nowyElement.poprzedni = poprzedni;
            nowyElement.nastepny = obecny;
            obecny.poprzedni = nowyElement;
        }
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
        A4UporzadkowanaListaPowiazanaDwukierunkowa5 lista = new A4UporzadkowanaListaPowiazanaDwukierunkowa5();

        Random random = new Random();
        for (int j = 0; j < 10; j++)
        {
            int number = random.nextInt(100);
            lista.insert(number);
            lista.print();
        }
    }
}
