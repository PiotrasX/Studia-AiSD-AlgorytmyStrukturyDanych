package Kolokwium2.StrukturyB;

import java.util.ArrayList;

// Implementacja stosu za pomocą klasy ArrayList - stos złożonych obiektów zdefiniowanych przez użytkownika,
// np.: tablica osób [imię nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].
//  Wykonać następujący eksperyment ze strukturą w której bierze udział 5 różnych elementów A, B, C, D, E.
// Przebieg eksperymentu: tworzymy strukturę, wstawiamy do struktury A, B, C; usuwamy dwa elementy; wstawiamy D i E;
// usuwamy wszystkie elementy wypisując je na ekran.

public class B1StosArrayList
{
    private ArrayList<Integer> stos;

    public B1StosArrayList() { stos = new ArrayList<Integer>(); }

    public void push(int element) { stos.add(element); }

    public int pop()
    {
        int gornyElement = stos.get(stos.size() - 1);
        stos.remove(stos.size() - 1);
        return gornyElement;
    }

    public int peek() { return stos.get(stos.size() - 1); }

    public boolean isEmpty() { return stos.isEmpty(); }

    public static void main(String[] args)
    {
        B1StosArrayList stos = new B1StosArrayList();
        stos.push(20);
        stos.push(40);
        stos.push(60);
        stos.push(80);
        stos.push(100);

        while (!stos.isEmpty())
        {
            int wartosc = stos.pop();
            System.out.print(wartosc + " ");
        }
        System.out.println();
    }
}
