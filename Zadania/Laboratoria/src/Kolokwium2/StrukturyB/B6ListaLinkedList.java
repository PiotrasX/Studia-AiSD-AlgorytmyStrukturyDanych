package Kolokwium2.StrukturyB;

import java.util.LinkedList;

// Implementacja listy dwustronnej za pomocą klasy LinkedList – lista złożonych obiektów zdefiniowanych przez
// użytkownika, np.: tablica osób [imię nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].
//  Wykonać następujący eksperyment ze strukturą w której bierze udział 5 różnych elementów A, B, C, D, E.
// Przebieg eksperymentu: tworzymy listę L, wstawiamy do listy L elementy A, B i C od lewej strony;
// wypisujemy elementy listy; wstawiamy do listy L elementy D i E od prawej strony; wypisujemy elementy listy;
// usuwamy element z lewej strony i element z prawej strony; wypisujemy elementy listy; sprawdzamy, czy na liście
// jest element B i wypisujemy wynik testu; sprawdzamy, czy na liście jest element E i wypisujemy wynik testu.

public class B6ListaLinkedList
{
    private LinkedList<Object> list;
    
    public B6ListaLinkedList() { list = new LinkedList<Object>(); }
    
    public boolean isEmpty() { return list.isEmpty(); }
    
    public void insertFirst(Object element) { list.addFirst(element); }
    
    public void insertLast(Object element) { list.addLast(element); }
    
    public Object deleteFirst() { return list.removeFirst(); }
    
    public Object deleteLast() { return list.removeLast(); }
    
    public Object getFirst() { return list.getFirst(); }
    
    public Object getLast() { return list.getLast(); }
    
    public int size() { return list.size(); }
    
    public void print()
    {
        for (Object o : list)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) 
    {
        B6ListaLinkedList lista = new B6ListaLinkedList();
        lista.insertFirst(22);
        lista.insertFirst(44);
        lista.insertFirst(66);
        lista.insertLast(11);
        lista.insertLast(33);
        lista.insertLast(55);
        lista.print();

        lista.deleteFirst();
        lista.deleteFirst();
        lista.print();

        lista.deleteLast();
        lista.print();
    }
}
