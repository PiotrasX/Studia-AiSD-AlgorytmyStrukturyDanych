package Kolokwium2.StrukturyB;

import java.util.ArrayList;

// Implementacja listy z bezpośrednim dostępem do każdego elementu poprzez podanie jego numeru za pomocą klasy
// ArrayList – lista złożonych obiektów zdefiniowanych przez użytkownika, np.: tablica osób [imię nazwisko, wiek];
// książek [tytuł, wydawnictwo, rok wydania].
// Wykonać następujący eksperyment ze strukturą w której bierze udział 6 różnych elementów A, B, C, D, E, F.
// Przebieg eksperymentu: tworzymy strukturę, wstawiamy do listy A, B, C, D; wypisujemy elementy listy;
// usuwamy element drugi i trzeci; wypisujemy elementy listy; wstawiamy E i F; wypisujemy elementy listy.

public class B5ListaArrayList
{
    private ArrayList<Object> lista;
    
    public B5ListaArrayList() { lista = new ArrayList<Object>(); }
    
    public boolean addLast(Object element) { return lista.add(element); }

    public Object removeLast() { return lista.remove(lista.size() - 1); }

    public Object get(int index) { return lista.get(index); }
    
    public int find(Object element) { return lista.indexOf(element); }
    
    public int size() { return lista.size(); }
    
    public void print()
    {
        for (Object o : lista)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) 
    {
        B5ListaArrayList lista = new B5ListaArrayList();
        
        lista.addLast("elem0");
        lista.addLast("elem1");
        lista.addLast("elem2");
        lista.addLast("elem3");
        lista.addLast("elem4");
        lista.print();
        
        System.out.println(lista.get(3));
        System.out.println(lista.removeLast());
        System.out.println(lista.find("elem4"));
        lista.print();
    }
}
