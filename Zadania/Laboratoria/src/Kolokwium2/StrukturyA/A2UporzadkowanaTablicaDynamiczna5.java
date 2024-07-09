package Kolokwium2.StrukturyA;

// Implementacja uporządkowanej tablicy dynamicznej złożonej z obiektów zdefiniowanych przez użytkownika,
// np.: tablica osób [imię, nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].

public class A2UporzadkowanaTablicaDynamiczna5
{
    private Osoba[] tablica;
    private int liczbaOsob;

    public A2UporzadkowanaTablicaDynamiczna5(int maxRozmiar)
    {
        if (maxRozmiar < 1) maxRozmiar = 1;
        tablica = new Osoba[maxRozmiar];
        liczbaOsob = 0;
    }

    public void add(Osoba osoba)
    {
        if (liczbaOsob >= tablica.length)
        {
            Osoba[] nowaTablica = new Osoba[tablica.length * 2];
            System.arraycopy(tablica, 0, nowaTablica, 0, tablica.length);
            tablica = nowaTablica;
        }

        int i;
        for (i = 0; i < liczbaOsob; i++)
            if (tablica[i].compareTo(osoba) > 0) break;

        for (int j = liczbaOsob; j > i; j--)
            tablica[j] = tablica[j - 1];

        tablica[i] = osoba;
        liczbaOsob++;
    }

    public Osoba get(int index)
    {
        if (index < 0 || index >= liczbaOsob) return null;
        return tablica[index];
    }

    public int size() { return liczbaOsob; }

    public boolean remove(int index)
    {
        if (index < 0 || index >= liczbaOsob) return false;
        for (int i = index; i < liczbaOsob - 1; i++)
            tablica[i] = tablica[i + 1];
        liczbaOsob--;
        return true;
    }

    public int find(Osoba szukanaOsoba)
    {
        for (int i = 0; i < liczbaOsob; i++)
            if (szukanaOsoba.equals(tablica[i])) return i;
        return -1;
    }

    public void print()
    {
        for (int i = 0; i < liczbaOsob; i++)
            System.out.println(tablica[i].toString());
    }

    public static void main(String[] args)
    {
        int maxRozmiar = 3;
        A2UporzadkowanaTablicaDynamiczna5 tab = new A2UporzadkowanaTablicaDynamiczna5(maxRozmiar);
        
        tab.add(new Osoba("Jan", "Kowalski", 49));
        tab.add(new Osoba("Jan", "Kowalski", 49));
        tab.add(new Osoba("Janusz", "Kowalski", 49));
        tab.add(new Osoba("Jan", "Kowalski", 20));
        tab.add(new Osoba("Jan", "Nowak", 10));
        tab.add(new Osoba("Janusz", "Nowak", 20));
        tab.add(new Osoba("Janusz", "Nowak", 19));
        tab.add(new Osoba("Janina", "Nowak", 19));
        tab.add(new Osoba("Piotr", "Mądry", 34));
        tab.add(new Osoba("Monika", "Mądra", 19));
        tab.add(new Osoba("Monika", "Mądra", 15));
        tab.add(new Osoba("Jan", "Zgredek", 30));
        tab.add(new Osoba("Janina", "Zgredek", 20));
        tab.add(new Osoba("Janina", "Rak", 10));
        tab.add(new Osoba("Monika", "Pleśniowa", 5));
        tab.print();
        System.out.println();

        tab.remove(1);
        tab.print();
        System.out.println();

        Osoba osoba1 = new Osoba("Monika", "Pleśniowa", 7);
        tab.add(osoba1);
        Osoba osoba2 = new Osoba("Damian", "Kapusta", 13);
        tab.add(osoba2);
        tab.print();
        System.out.println();

        System.out.println("Czy znaleziono osobę1: index -> " + tab.find(osoba1));
        System.out.println("Czy znaleziono osobę3: index -> " + tab.find(osoba2));
        System.out.println("Czy znaleziono nową osobę: index -> " + tab.find(new Osoba("Krystyna", "Kowalska", 32)));
        System.out.println("Czy znaleziono nową osobę: index -> " + tab.find(new Osoba("Damian", "Kapusta", 13)));
    }

    private static class Osoba implements Comparable<Osoba>
    {
        private String imie;
        private String nazwisko;
        private int wiek;

        public Osoba()
        {
            imie = "";
            nazwisko = "";
            wiek = 0;
        }
        public Osoba(String imie, String nazwisko, int wiek)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.wiek = wiek;
        }

        public String getImie() { return imie; }
        public void setImie(String imie) { this.imie = imie; }
        public String getNazwisko() { return nazwisko; }
        public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }
        public int getWiek() { return wiek; }
        public void setWiek(int wiek) { this.wiek = wiek; }

        @Override
        public String toString() {return "Osoba -> Imię: " + imie + ", Nazwisko: " + nazwisko + ", Wiek: " + wiek; }

        public boolean equals(Osoba osoba)
        {
            return this.imie.equals(osoba.imie) && this.nazwisko.equals(osoba.nazwisko) && this.wiek == osoba.wiek;
        }

        @Override
        public int compareTo(Osoba osoba)
        {
            // Kolejność: wiek -> nazwisko -> imie
            if (this.wiek < osoba.wiek) return -1;
            else if (this.wiek > osoba.wiek) return 1;
            else if (this.nazwisko.compareTo(osoba.nazwisko) != 0)
                return this.nazwisko.compareTo(osoba.nazwisko);
            else if (this.imie.compareTo(osoba.imie) != 0)
                return this.imie.compareTo(osoba.imie);
            return 0;
        }
    }
}
