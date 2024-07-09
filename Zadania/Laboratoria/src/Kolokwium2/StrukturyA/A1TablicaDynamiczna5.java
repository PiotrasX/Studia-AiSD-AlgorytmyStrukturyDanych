package Kolokwium2.StrukturyA;

// Implementacja tablicy dynamicznej złożonej z obiektów zdefiniowanych przez użytkownika,
// np.: tablica osób [imię, nazwisko, wiek]; książek [tytuł, wydawnictwo, rok wydania].

public class A1TablicaDynamiczna5
{
    private Osoba[] tablica;
    private int liczbaOsob;

    public A1TablicaDynamiczna5(int maxRozmiar)
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

        tablica[liczbaOsob] = osoba;
        liczbaOsob++;
    }

    public void set(Osoba osoba, int index) { if (index >= 0 && index < liczbaOsob) tablica[index] = osoba; }

    public Osoba get(int index)
    {
        if (index < 0 || index >= liczbaOsob) return null;
        else return tablica[index];
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
        int maxRozmiar = 1;
        A1TablicaDynamiczna5 tab = new A1TablicaDynamiczna5(maxRozmiar);
        
        Osoba osoba1 = new Osoba("Jan", "Kowalski", 13);
        tab.add(osoba1);
        
        Osoba osoba2 = new Osoba("Janusz", "Mrożek", 47);
        tab.add(osoba2);
        
        Osoba osoba3 = new Osoba();
        osoba3.setImie("Alicja");
        osoba3.setNazwisko("Nowak");
        osoba3.setWiek(15);
        tab.add(osoba3);

        Osoba osoba4 = new Osoba();
        osoba4.setImie("Monika");
        osoba4.setNazwisko("Nowak");
        osoba4.setWiek(17);
        tab.add(osoba4);

        tab.add(new Osoba("Janina", "Kowalska", 47));
        tab.add(new Osoba("Michalina", "Kowalczyk", 45));

        tab.print();
        System.out.println("Czy znaleziono osobę3: index -> " + tab.find(osoba3));
        System.out.println();

        tab.set(new Osoba("Krystyna", "Kowalska", 32), 2);
        tab.print();
        System.out.println("Czy znaleziono osobę3: index -> " + tab.find(osoba3));
        System.out.println();

        System.out.println("Czy znaleziono osobę2: index -> " + tab.find(osoba2));
        System.out.println("Czy znaleziono nową osobę: index -> " + tab.find(new Osoba("Krystyna", "Kowalska", 32)));
        Osoba osoba5 = osoba2;
        System.out.println("Czy znaleziono osobę5: index -> " + tab.find(osoba5));
    }

    private static class Osoba
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
        public String toString() { return "Osoba -> Imię: " + imie + ", Nazwisko: " + nazwisko + ", Wiek: " + wiek; }

        public boolean equals(Osoba osoba)
        {
            return this.imie.equals(osoba.imie) && this.nazwisko.equals(osoba.nazwisko) && this.wiek == osoba.wiek;
        }
    }
}
