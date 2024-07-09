package Kolokwium2.StrukturyA;

// Klasa definiuje drzewo poszukiwań binarnych

import java.util.ArrayList;

public class A5Drzewo5
{
    private A5WezelDrzewa5 korzen;    // Pierwszy węzeł drzewa

    public A5Drzewo5() { korzen = null; }

    public A5WezelDrzewa5 getKorzen() { return korzen; }

    public void insert(int element)
    {
        A5WezelDrzewa5 nowyWezel = new A5WezelDrzewa5();    // Nowy węzeł drzewa
        nowyWezel.wartosc = element;                        // Wartość w nowym węźle drzewa

        if (korzen == null) korzen = nowyWezel;             // Jeśli drzewo jest puste
        else // Drzewo ma korzeń
        {
            A5WezelDrzewa5 obecnyWezel = korzen;            // Poszukiwania zaczynają się od korzenia
            while (true)                                    // Pętla zakończy się za pomocą return
            {
                A5WezelDrzewa5 rodzic = obecnyWezel;
                if (element < obecnyWezel.wartosc)          // Wartości po lewej stronie
                {
                    obecnyWezel = obecnyWezel.dzieckoLewe;
                    if (obecnyWezel == null)                // Jeśli nie ma lewego elementu
                    {
                        rodzic.dzieckoLewe = nowyWezel;     // Wartości wstawiane po lewej stronie
                        nowyWezel.rodzic = rodzic;
                        return;
                    }
                }
                else                                        // Wartości po prawej stronie
                {
                    obecnyWezel = obecnyWezel.dzieckoPrawe;
                    if (obecnyWezel == null)                // Jeśli nie ma prawego elementu
                    {
                        rodzic.dzieckoPrawe = nowyWezel;    // Wartości wstawiane po prawej stronie
                        nowyWezel.rodzic = rodzic;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(int element)                        // Sprawdzenie, czy w drzewie jest element
    {
        if (korzen == null) return false;                   // Drzewo jest puste
        A5WezelDrzewa5 obecnyWezel = korzen;                // Poszukiwania zaczynają się od korzenia
        while (obecnyWezel.wartosc != element)              // Dopóki nie odnaleziono elementu
        {
            if (element < obecnyWezel.wartosc)              // Przechodzenie na lewą stronę
                obecnyWezel = obecnyWezel.dzieckoLewe;
            else                                            // Przechodzenie na prawą stronę
                obecnyWezel = obecnyWezel.dzieckoPrawe;
            if (obecnyWezel == null)                        // Jeśli brak potomka
                return false;                               // Nie odnaleziono elementu
        }
        return true;                                        // Odnaleziono element
    }

    private A5WezelDrzewa5 czySukces(A5WezelDrzewa5 wezel)  // Wyliczenie następnika węzła
    {
        A5WezelDrzewa5 obecnyWezel = wezel.dzieckoPrawe;
        while (obecnyWezel.dzieckoLewe != null)             // Idziemy w lewy dolny liść poddrzewa
            obecnyWezel = obecnyWezel.dzieckoLewe;
        return obecnyWezel;
    }

    private void usuniecieDzieciPuste(A5WezelDrzewa5 obecnyWezel) // Usunięcie węzła bez potomków
    {
        if (obecnyWezel == korzen) korzen = null;                 // Jeśli to korzeń, opróżniamy drzewo
        else
        {
            if (obecnyWezel.rodzic.dzieckoLewe == obecnyWezel)    // Usuwany element był lewym synem ojca
                obecnyWezel.rodzic.dzieckoLewe = null;            // Odłączenie usuwanego węzła
            else                                                  // Usuwany element był prawym synem ojca
                obecnyWezel.rodzic.dzieckoPrawe = null;           // Odłączenie usuwanego węzła
            obecnyWezel.rodzic = null;
        }
    }

    private void usuniecieDzieciLewe(A5WezelDrzewa5 oecnyWezel)   // Usunięcie węzła z jednym lewym potomkiem
    {
        if (oecnyWezel == korzen) korzen = oecnyWezel.dzieckoLewe;
        else
        {
            if (oecnyWezel.rodzic.dzieckoLewe == oecnyWezel)      // Usuwany element był lewym synem ojca
                oecnyWezel.rodzic.dzieckoLewe = oecnyWezel.dzieckoLewe;
            else                                                  // Usuwany element był prawym synem ojca
                oecnyWezel.rodzic.dzieckoPrawe = oecnyWezel.dzieckoLewe;
            oecnyWezel.dzieckoLewe.rodzic = oecnyWezel.rodzic;
        }
    }

    private void usuniecieDzieciPrawe(A5WezelDrzewa5 obecnyWezel) // Usunięcie węzła z jednym prawym potomkiem
    {
        if (obecnyWezel == korzen) korzen = obecnyWezel.dzieckoPrawe;
        else
        {
            if (obecnyWezel.rodzic.dzieckoLewe == obecnyWezel)    // Usuwany element był lewym synem ojca
                obecnyWezel.rodzic.dzieckoLewe = obecnyWezel.dzieckoPrawe;
            else                                                  // Usuwany element był prawym synem ojca
                obecnyWezel.rodzic.dzieckoPrawe = obecnyWezel.dzieckoPrawe;
            obecnyWezel.dzieckoPrawe.rodzic = obecnyWezel.rodzic;
        }
    }

    private void usuniecieDzieciOba(A5WezelDrzewa5 obecnyWezel) // Usunięcie węzła z dwoma potomkami
    {
        A5WezelDrzewa5 sukces = czySukces(obecnyWezel); // Wyszukanie następnika usuwanego węzła

        if (sukces.dzieckoLewe == null && sukces.dzieckoPrawe == null) // Następnik nie ma potomków
            usuniecieDzieciPuste(sukces);
        else // Następnik ma jednego prawego potomka
            usuniecieDzieciPrawe(sukces);
        
        A5WezelDrzewa5 rodzicObecny = obecnyWezel.rodzic; // Jeśli current==root, to jego rodzicem jest null
        
        // Wymiana usuwanego węzła na jego następnik
        if (obecnyWezel != korzen)
        {
            if (rodzicObecny.dzieckoLewe ==obecnyWezel) rodzicObecny.dzieckoLewe = sukces;
            else rodzicObecny.dzieckoPrawe = sukces;
        }

        sukces.dzieckoLewe = obecnyWezel.dzieckoLewe;
        sukces.dzieckoPrawe = obecnyWezel.dzieckoPrawe;
        
        sukces.rodzic = rodzicObecny;
        if (sukces.dzieckoLewe != null) sukces.dzieckoLewe.rodzic = sukces;
        if (sukces.dzieckoPrawe != null) sukces.dzieckoPrawe.rodzic = sukces;
        
        if (obecnyWezel == korzen) korzen = sukces;
    }

    public boolean delete(int element) // Usunięcie węzła o podanej wartości elementu
    {
        if (korzen == null) return false;       // Drzewo jest puste
        A5WezelDrzewa5 obecnyWezel = korzen;

        while (obecnyWezel.wartosc != element)        // szukamy węzła
        {            
            if (element < obecnyWezel.wartosc) obecnyWezel = obecnyWezel.dzieckoLewe;
            else obecnyWezel = obecnyWezel.dzieckoPrawe;
            if (obecnyWezel == null) return false;
        }

        // Znaleziono węzeł do usunięcia
        if (obecnyWezel.dzieckoLewe == null && obecnyWezel.dzieckoPrawe == null) // Usuniecie w przypadku braku potomków
            usuniecieDzieciPuste(obecnyWezel);
        else
        {
            if (obecnyWezel.dzieckoPrawe == null) // Jeśli brak prawego potomka, zastępujemy węzeł lewym poddrzewem
                usuniecieDzieciLewe(obecnyWezel);
            else
            {
                if (obecnyWezel.dzieckoLewe == null) // Jeśli brak lewego potomka, zastępujemy węzeł prawym poddrzewem
                    usuniecieDzieciPrawe(obecnyWezel);
                else  // Węzeł ma dwa potomki, zastępujemy go zatem jego następnikiem
                    usuniecieDzieciOba(obecnyWezel);
            }
        }
        return true;       
    }

    public void view(A5WezelDrzewa5 wezel, int poziom) // Wizualizacja tekstowa drzewa
    {
        if (wezel == null) return;
        for (int i = 0; i < poziom; i++) System.out.print("- ");
        System.out.println(wezel.wartosc);
        view(wezel.dzieckoLewe,poziom + 1);
        view(wezel.dzieckoPrawe,poziom + 1);
    }

    private void kopiowanieDoTablicy(A5WezelDrzewa5 wezel, ArrayList<A5WezelDrzewa5> listaWezlow) // Kopiowanie drzewa Do tablicy dynamicznej
    {        
        if (wezel.dzieckoLewe != null) kopiowanieDoTablicy(wezel.dzieckoLewe,listaWezlow);
        listaWezlow.add(wezel);
        if (wezel.dzieckoPrawe != null) kopiowanieDoTablicy(wezel.dzieckoPrawe,listaWezlow);
    }

    public A5DrzewoIterator5 iterator() // Pobranie iteratora drzewa
    {
        ArrayList<A5WezelDrzewa5> listaWezlow = new ArrayList<>();
        if (korzen != null) kopiowanieDoTablicy(korzen, listaWezlow);
        return new A5DrzewoIterator5(listaWezlow);
    }

    public void print() // Przeglądanie drzewa wraz z wypisywaniem elementów
    {
        System.out.print("Drzewo: ");
        A5DrzewoIterator5 iterator = this.iterator();

        while (iterator.jakiNastepny())      // Dopóki nie koniec elementów
        {
            A5WezelDrzewa5 wezel = iterator.nastepny();
            System.out.print(wezel.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        A5Drzewo5 drzewo = new A5Drzewo5();

        // Wstawianie elementów
        drzewo.insert(50);
        drzewo.insert(25);
        drzewo.insert(75);
        drzewo.insert(12);
        drzewo.insert(37);
        drzewo.insert(43);
        drzewo.insert(30);
        drzewo.insert(33);
        drzewo.insert(87);
        drzewo.insert(63);
        drzewo.insert(97);
        drzewo.view(drzewo.getKorzen(),0);
        
        System.out.println("\n\t<< delete(50) >>");
        drzewo.delete(50);
        drzewo.view(drzewo.getKorzen(),0);
        drzewo.print();

        boolean wynik1 = drzewo.find(33);
        System.out.println("Wynik wyszukania 33: " + wynik1);

        boolean wynik2 = drzewo.find(40);
        System.out.println("Wynik wyszukania 40: " + wynik2);

        System.out.println("\n\t<< delete(37) >>");
        drzewo.delete(37);
        drzewo.view(drzewo.getKorzen(),0);
        
        System.out.println("\n\t<< delete(43) >>");
        drzewo.delete(43);
        drzewo.view(drzewo.getKorzen(),0);
        
        System.out.println("\n\t<< delete(25) >>");
        drzewo.delete(25);
        drzewo.view(drzewo.getKorzen(),0);
        
        drzewo.print();
    }
}
