package Kolokwium2.StrukturyA;

import java.util.LinkedList;

// Implementacja tablicy mieszającej metodą łańcuchową – trzy funkcjonalności.

public class A6TablicaHaszujaca5
{
    private LinkedList[] tablicaHaszujaca;
    private int rozmiar;

    public A6TablicaHaszujaca5(int rozmiar)
    {
        this.rozmiar = rozmiar;
        tablicaHaszujaca = new LinkedList[rozmiar];

        for (int i = 0; i < rozmiar; i++)
            tablicaHaszujaca[i] = new LinkedList();
    }

    public LinkedList getLinkedList(int index) { return tablicaHaszujaca[index]; }

    public int size() { return rozmiar; }

    private int hashFunc(int element) { return element % rozmiar; }

    public void insert(int wartosc)
    {
        int wartoscHasz = hashFunc(wartosc);
        if (!tablicaHaszujaca[wartoscHasz].contains(wartosc))
            tablicaHaszujaca[wartoscHasz].addFirst(wartosc);
    }

    public void delete(int element)
    {
        int wartoscHasz = hashFunc(element);
        tablicaHaszujaca[wartoscHasz].remove((Object) element);
    }

    public boolean find(int element)
    {
        int wartoscHasz = hashFunc(element);
        return tablicaHaszujaca[wartoscHasz].contains(element);
    }

    public void print()
    {
        System.out.print("Tablica: ");
        for (int i = 0; i < size(); i++)
            for (Object wartosc : getLinkedList(i))
                System.out.print(wartosc.toString() + " ");
        System.out.println();
    }


    public static void main(String[] args)
    {
        A6TablicaHaszujaca5 tablica = new A6TablicaHaszujaca5(10);

        tablica.insert(1);
        tablica.insert(11);
        tablica.insert(2);
        tablica.insert(12);
        tablica.insert(42);
        tablica.insert(3);
        tablica.insert(33);
        tablica.insert(4);
        tablica.insert(3);
        tablica.print();

        System.out.println("Wynik wyszukiwania 3: " + tablica.find(3));
        tablica.delete(3);
        tablica.print();
        System.out.println("Wynik wyszukiwania 3: " + tablica.find(3));
    }
}
