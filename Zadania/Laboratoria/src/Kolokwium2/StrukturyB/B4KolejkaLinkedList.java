package Kolokwium2.StrukturyB;

import java.util.LinkedList;

// Implementacja kolejki za pomocą klasy LinkedList - stos złożonych obiektów zdefiniowanych przez użytkownika,
// np.: tablica osób [imię nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].
//  Wykonać następujący eksperyment ze strukturą w której bierze udział 5 różnych elementów A, B, C, D, E.
// Przebieg eksperymentu: tworzymy strukturę, wstawiamy do struktury A, B, C; usuwamy dwa elementy; wstawiamy D i E;
// usuwamy wszystkie elementy wypisując je na ekran.

public class B4KolejkaLinkedList
{
    private LinkedList<Integer> kolejka;

    public B4KolejkaLinkedList() { kolejka = new LinkedList<Integer>(); }

    public void enqueue(int element) { kolejka.add(element); }

    public int dequeue()
    {
        int pierwszyElement = kolejka.get(0);
        kolejka.remove(0);
        return pierwszyElement;
    }

    public int peek() { return kolejka.get(0); }

    public boolean isEmpty() { return kolejka.isEmpty(); }

    public int size() { return kolejka.size(); }

    public static void main(String[] args)
    {
        B4KolejkaLinkedList kolejka = new B4KolejkaLinkedList();

        System.out.println("Wstawiam: 10");
        kolejka.enqueue(10);
        System.out.println("Wstawiam: 20");
        kolejka.enqueue(20);
        System.out.println("Wstawiam: 30");
        kolejka.enqueue(30);
        System.out.println("Wstawiam: 40");
        kolejka.enqueue(40);

        System.out.println(" Usuwam: " + kolejka.dequeue());
        System.out.println(" Usuwam: " + kolejka.dequeue());
        System.out.println(" Usuwam: " + kolejka.dequeue());

        System.out.println("Wstawiam: 50");
        kolejka.enqueue(50);
        System.out.println("Wstawiam: 60");
        kolejka.enqueue(60);
        System.out.println("Wstawiam: 70");
        kolejka.enqueue(70);
        System.out.println("Wstawiam: 80");
        kolejka.enqueue(80);

        System.out.print("Kolejka: ");
        while (!kolejka.isEmpty())
            System.out.print(kolejka.dequeue() + " ");
    }
}
