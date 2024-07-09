package Kolokwium2.SortowanieC;

import java.util.Random;

public class MetodySortowania
{
    private static int[] table;
    private static final int N = 10;

    public static void main(String[] args)
    {
        wpiszNoweElementy();
        przedSort();
        bubbleSort();  // Sortowanie bąbelkowe
        poSort();

        wpiszNoweElementy();
        przedSort();
        selectionSort();  // Sortowanie przez wybór (najmniejszego elementu)
        poSort();

        wpiszNoweElementy();
        przedSort();
        insertionSort();  // Sortowanie przez wstawianie (w odpowiednie miejsce kolejnych elementów)
        poSort();

        wpiszNoweElementy();
        przedSort();
        quickSort(0, table.length - 1);  // Sortowanie metoda szybka
        poSort();

        wpiszNoweElementy();
        przedSort();
        mergeSort(0, table.length - 1);  // Sortowanie przez scalanie (mniejszych posortowanych już części)
        poSort();
    }

    public static void wpiszNoweElementy()
    {
        table = new int[N];
        Random random = new Random();
        for (int i = 0; i < table.length; i++)
            table[i] = random.nextInt(100);
    }

    public static void przedSort()
    {
        System.out.print("Przed sortowaniem: ");
        print();
    }

    public static void poSort()
    {
        System.out.print("Po sortowaniu: ");
        print();
        System.out.println();
    }

    //-----------------------------------------------------------------

    public static void bubbleSort() // Sortowanie bąbelkowe
    {        
        for (int i = table.length - 1; i > 0; i--)
        {               
            for (int j = 0; j < i; j++)
            {
                if (table[j] > table[j + 1]) swap(j, j + 1);
            }
        }
    }

    //-----------------------------------------------------------------

    public static void selectionSort() // Sortowanie przez wybor
    {        
        for (int i = 0; i < table.length - 1; i++)
        {
            System.out.print("i = " + i + "   Przed: ");
            for (int k : table) System.out.print(k + " ");
            
            int minPos = i;
            for (int j = i + 1; j < table.length; j++) // Wyszukanie elementu najmniejszego od pozycji i+1 do nElementów-1
            {
                if (table[j] < table[minPos]) minPos = j;
            }
            swap(i, minPos);
            
            System.out.print("   Po: ");
            for (int k : table) System.out.print(k + " ");
            System.out.println();            
        } 
    }

    //-----------------------------------------------------------------
    
    public static void insertionSort() // Sortowanie przez wstawianie
    {        
        for (int i = 1; i < table.length; i++)  // i to pozycja pierwszego nieposortowanego elementu
        {
            int e = table[i]; // Kopiowanie wyróżnionego elementu

            System.out.print("i = " + i + "   Przed: ");
            for (int k : table) System.out.print(k + " ");
            
            int j = i;                           // Zaczynanie przesuwania od i
            while (j > 0 && table[j - 1] >= e)   // Dopóki elementy są większe niż temp
            {
                table[j] = table[j - 1];         // Przesunięcie elementu w prawo w celu zrobienia miejsca na temp
                j--;                             // Przesuwanie się w lewo
            }
            table[j] = e;                        // Wstawianie wyróżnionego elementu w nowe miejsce

            System.out.print("   Po: ");
            for (int k : table) System.out.print(k + " ");
            System.out.println();
        }
    }

    //-----------------------------------------------------------------

    public static void quickSort(int lewo, int prawo) // Sortowanie metoda szybka
    {
        if (lewo < prawo)
        {
            int klucz = table[lewo]; // Ustalenie klucza osiowego
            int s = lewo;
            for (int i = lewo + 1; i <= prawo; i++) // Zbieranie elementów mniejszych od klucza osiowego po lewej stronie tablicy
            {
                if (table[i]<klucz)
                {
                    s = s + 1;
                    swap(s, i);
                }
            }
            swap(lewo, s); // Zamiana klucza osiowego z elementem najbardziej wysuniętym na prawo, mniejszym od klucza osiowego

            quickSort(lewo, s - 1); // Posortowanie elementów mniejszych od klucza osiowego
            quickSort(s + 1, prawo); // Posortowanie elementów większych od klucza osiowego
        }
    }
    
    //-------------------------------
    
    public static void merge(int lewo, int srodek, int prawo) //łącz fragment od l do mid z fragmentem od mid+1 do r
    {
        int[] tab = new int[prawo - lewo + 1]; // Tworzenie tablicy pomocniczej

        int k = 0;          // Indeks w scalanej tablicy
        int i = lewo;       // Indeks w pierwszym fragmencie do scalenia
        int j = srodek + 1;   // Indeks w drugim fragmencie do scalenia

        while ((i < srodek + 1) || (j < prawo + 1)) // Przeglądaj aż do końca scalenia obydwu fragmentów
        {
            if (i == srodek + 1) // Jeśli pierwszy fragment już jest scalony...
            {     
                tab[k] = table[j]; k++; j++; // ...kopiuj kolejną liczbę z drugiego fragmentu
            }
            else if (j == prawo + 1) // Jeśli drugi fragment już jest scalony...
            {             
                tab[k] = table[i]; k++; i++; // ...kopiuj kolejną liczbę z pierwszego fragmentu
            }
            else // Scalanie elementów z obydwu fragmentów
            {
                if (table[i] <= table[j]) // Element z pierwszego fragmentu jest mniejszy i ma byc scalony jako pierwszy
                {             
                    tab[k] = table[i]; i++; k++;
                }
                else // Element z drugiego fragmentu jest mniejszy i ma byc scalony jako pierwszy
                {                 
                    tab[k] = table[j]; j++; k++;
                }
            }
        }

        // Przepisanie zawartości tablicy pomocniczej do tablicy table
        int l = lewo;
        for (i = 0; i < tab.length; i++)
        {
            table[l] = tab[i]; l++;
        }        
    }
    
    public static void mergeSort(int lewa, int prawa) // Sortowanie przez scalanie
    {
        if (lewa < prawa)
        {
            int srodek = (lewa + prawa) / 2;     // Wyliczenie środka
            mergeSort(lewa, srodek);             // Sortowanie lewej części
            mergeSort(srodek + 1, prawa);   // Sortowanie prawej części
            merge(lewa, srodek, prawa);           // Scalanie posortowanych części
        }
    }

    //--------------------------------------------------------------

    public static void swap(int pierwszyElement, int drugiElement) // Zamiana elementów tablicy
    {
        int temp = table[pierwszyElement];
        table[pierwszyElement] = table[drugiElement];
        table[drugiElement] = temp;
    }

    //--------------------------------------------------------------

    public static void print()
    {
        for (int i : table) System.out.print(i + " ");
        System.out.println();
    }
}
