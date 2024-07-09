package P1;

// Dany jest plecak o objętości v = 10 oraz 6 przedmiotów ponumerowanych od 0 do 5. Każdy przedmiot ma określoną
// wartość Wi i objętość Vi. Należy zapakować plecak spośród przedmiotów ponumerowanych od 0 do 5 w taki sposób,
// aby wartość przedmiotów w nim zgromadzonych była największa. Wartości i objętości przedmiotów określone są
// w poniższej tabeli:            |   i   |  0  |  1  |  2  |  3  |  4  |  5  |
//                                |   Vi  |  6  |  2  |  3  |  2  |  3  |  1  |
//                                |   Wi  |  6  |  4  |  5  |  7  |  10 |  2  |
//                                | Wi/Vi |  1  |  2  | 1.7 | 3.5 | 3.3 |  2  |
// Odp.: W plecaku o maksymalnej wartości znajdą się przedmioty 1,3,4,5 o wartości 23.

import java.io.IOException;
import java.util.Arrays;

// Zachłannie od największej Wi/Vi do najmniejszej
public class PlecakowyZachlannie3
{
    static final int[] VI = {6,2,3,2,3,1}; // Objętości przedmiotów
    static final int[] WI = {6,4,5,7,10,2}; // Wartości przedmiotów
    static final double[] WI_VI = new double[VI.length]; // WI/VI
    static final int[] UZYTE = {0,0,0,0,0,0}; // Użyte przedmioty
    static int VMAKS = 0; // Maksymalna objętość plecaka
    static int WMAKS = 0; // Maksymalna wartość plecaka

    public static void main(String[] args) throws IOException
    {
        for (int podziel = 0; podziel < VI.length; podziel++)
            { WI_VI[podziel] = (double) WI[podziel] /VI[podziel]; }

        for (int sprawdz = 0; sprawdz < VI.length; sprawdz++)
        {
            if (VMAKS >= 10) { break; }
            else
            {
                int wAktualne = 0; int vAktualne = Arrays.stream(VI).max().getAsInt(); int indeks = 0; double wvAktualne = 0;
                for (int przedmiot = 0; przedmiot < VI.length; przedmiot++)
                {
                    if (UZYTE[przedmiot]!=1) // Sprawdzenie, czy dany przedmiot nie został już użyty
                        if ((WI_VI[przedmiot] >= wvAktualne) && (VI[przedmiot]+VMAKS <= 10)) // Sprawdzenie jaki przedmiot ma aktualnie największy stosunek Wi/Vi i czy zmieści się w plecaku
                            if ((WI_VI[przedmiot] > wvAktualne) || ((WI_VI[przedmiot] == wvAktualne) && (VI[przedmiot] <= vAktualne))) // Sprawdzenie jaki przedmiot ma najmniejszą objętość, gdy co najmniej dwa przedmiotów mają taki sami stosunek Wi/Vi
                                { wAktualne = WI[przedmiot]; vAktualne = VI[przedmiot]; indeks = przedmiot; wvAktualne = WI_VI[przedmiot]; }
                }
                if ((VI[indeks]+VMAKS <= 10))
                    { WMAKS+=wAktualne; VMAKS+=vAktualne; UZYTE[indeks] = 1; VI[indeks] = 0; WI[indeks] = 0; } // Dodanie do plecaka przedmiotu, który ma aktualnie największy stosunek Wi/Vi i przy tym najmniejszą objętość
            }
        }
        wypisz(); // Wypisanie użytych przedmiotów, wartości i objętości plecaka
    }

    private static void wypisz()
    {
        System.out.print("Użyte przedmioty: ");
        for (int i = 0; i < UZYTE.length; i++) { if(UZYTE[i]==1) { System.out.print("p" + i + ", "); } }
        System.out.println("\nWartość plecaka: " + WMAKS);
        System.out.println("Objętość plecaka: " + VMAKS);
    }
}
