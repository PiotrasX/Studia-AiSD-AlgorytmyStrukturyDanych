package Kolokwium2.StrukturyB;

import java.util.Iterator;
import java.util.HashSet;

// Implementacja zbioru za pomocą klasy HashSet – lista złożonych obiektów zdefiniowanych przez użytkownika,
// np.: tablica osób [imię nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].
//  Wykonać następujący eksperyment ze strukturą w której bierze udział 5 różnych elementów a, b, c, d, e.
// Przebieg eksperymentu: tworzymy zbiory A i B, wstawiamy do A elementy a, b, c, d oraz do B elementy c, d, e;
// wyliczamy i wypisujemy zbiory: iloczyn A i B, suma A i B, różnica A\B; usuwamy ze zbioru A element c
// i ze zbioru B element e; powtórnie wyliczamy i wypisujemy zbiory: iloczyn A i B, suma A i B, różnica A\B.

public class B9HashSetSet
{
    private HashSet<Integer> zbior;

    public B9HashSetSet() { zbior = new HashSet<Integer>(); }

    public HashSet<Integer> getZbior() { return zbior; }

    public int size() { return zbior.size(); }

    public void insert(int element) { if (!member(element)) zbior.add(element); }

    public boolean member(int element) { return zbior.contains(element); }

    public boolean delete(int elem)
    {
        if (member(elem))
        {
            zbior.remove(elem);
            return true;
        }
        else return false;
    }

    public B9HashSetSet union(B9HashSetSet drugiZbior) // Suma
    {
        B9HashSetSet unionSet = new B9HashSetSet();

        Iterator<Integer> iterator1 = zbior.iterator();
        while (iterator1.hasNext())
        {
            int lokalnyElement = iterator1.next();
            unionSet.insert(lokalnyElement);
        }

        Iterator<Integer> iterator2 = drugiZbior.getZbior().iterator();
        while (iterator2.hasNext())
        {
            int lokalnyElement = iterator2.next();;
            unionSet.insert(lokalnyElement);
        }

        return unionSet;
    }

    public B9HashSetSet intersection(B9HashSetSet drugiZbior) // Iloczyn
    {
        B9HashSetSet intersectionSet = new B9HashSetSet();

        Iterator<Integer> iterator = zbior.iterator();
        while (iterator.hasNext())
        {
            int lokalnyElement = iterator.next();
            if (drugiZbior.member(lokalnyElement))
                intersectionSet.insert(lokalnyElement);
        }

        return intersectionSet;
    }

    public B9HashSetSet difference(B9HashSetSet drugiZbior) // Różnica
    {
        B9HashSetSet differenceSet = new B9HashSetSet();

        Iterator<Integer> iterator = zbior.iterator();
        while (iterator.hasNext())
        {
            int lokalnyElement = iterator.next();
            if (!drugiZbior.member(lokalnyElement))
                differenceSet.insert(lokalnyElement);
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Integer> iterator = zbior.iterator();
        while (iterator.hasNext())
        {
            int lokalnyElement = iterator.next();
            System.out.print(lokalnyElement + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        B9HashSetSet zbiorA = new B9HashSetSet();
        zbiorA.insert(60);
        zbiorA.insert(20);
        zbiorA.insert(40);
        zbiorA.print();

        System.out.println("Wynik testu w zbiorze A dla 20: " + zbiorA.member(20));
        System.out.println("Wynik w zbiorze A pierwszego testu dla 30: " + zbiorA.member(30));
        System.out.println();

        zbiorA.insert(30);
        zbiorA.print();
        System.out.println("Wynik w zbiorze A pierwszego testu dla 30: " + zbiorA.member(30));
        System.out.println();

        zbiorA.delete(30);
        zbiorA.print();
        System.out.println("Wynik w zbiorze A pierwszego testu dla 30: " + zbiorA.member(30));
        System.out.println();

        zbiorA.insert(10);
        zbiorA.insert(90);
        zbiorA.print();
        System.out.println();

        System.out.println("--------------------------------------------");
        System.out.print("Zbior A: ");
        zbiorA.print();

        B9HashSetSet zbiorB = new B9HashSetSet();
        zbiorB.insert(40);
        zbiorB.insert(70);
        zbiorB.insert(60);
        zbiorB.insert(80);

        System.out.print("Zbior B: ");
        zbiorB.print();

        B9HashSetSet unionSet = zbiorA.union(zbiorB);
        System.out.print("Suma A i B: ");
        unionSet.print();

        B9HashSetSet intersectionSet = zbiorA.intersection(zbiorB);
        System.out.print("Iloczyn A i B: ");
        intersectionSet.print();

        B9HashSetSet differenceSet = zbiorA.difference(zbiorB);
        System.out.print("Roznica A-B: ");
        differenceSet.print();

        B9HashSetSet differenceSet2 = zbiorB.difference(zbiorA);
        System.out.print("Roznica B-A: ");
        differenceSet2.print();
    }
}
