package P27;

// Dane są dwa naczynia, które mogą pomieścić odpowiednio 3 litry i 4 litry wody. Naczynia nie mają miarki. Można je
// napełniać przy użyciu pompy lub przelewając wodę z jednego w drugie. W jaki sposób można otrzymać dokładnie 2 litry
// wody w naczyniu czterolitrowym?
// Odp.: Niech para (a,b), gdzie: a – ilość wody w naczyniu 3 litrowym, b – ilość wody w naczyniu 4 litrowym,
// reprezentuje stan ze środowiska problemu. Oto przykładowa i najkrótsza droga od stanu początkowego do stanu
// końcowego: (0,0) (3,0) (0,3) (3,3) (2,4) (2,0) (0,2).

import java.util.HashSet;
import java.util.Set;

public class WodaBrutalnie
{
    private static final int MAX_3L = 3;
    private static final int MAX_4L = 4;
    private static final Set<String> odwiedzone = new HashSet<>();

    public static void main(String[] args) { rozwiaz(0, 0, ""); }

    public static void rozwiaz(int dzban3L, int dzban4L, String historia)
    {
        if (dzban3L < 0 || dzban3L > MAX_3L || dzban4L < 0 || dzban4L > MAX_4L || odwiedzone.contains(dzban3L + "," + dzban4L))
        {
            return;
        }

        // Aktualizacja historii
        historia += "(" + dzban3L + "," + dzban4L + ") -> ";

        if (dzban4L == 2)
        {
            System.out.println("Rozwiązanie: " + historia);
            System.exit(0); // Znaleziono rozwiązanie
        }

        odwiedzone.add(dzban3L + "," + dzban4L);

        // Próba wszystkich możliwych akcji
        rozwiaz(MAX_3L, dzban4L, historia); // Napełnij dzban 3L
        rozwiaz(dzban3L, MAX_4L, historia); // Napełnij dzban 4L
        rozwiaz(0, dzban4L, historia); // Opróżnij dzban 3L
        rozwiaz(dzban3L, 0, historia); // Opróżnij dzban 4L
        rozwiaz(dzban3L - Math.min(dzban3L, MAX_4L - dzban4L), dzban4L + Math.min(dzban3L, MAX_4L - dzban4L), historia); // Przelej z dzbanu 3L do 4L
        rozwiaz(dzban3L + Math.min(dzban4L, MAX_3L - dzban3L), dzban4L - Math.min(dzban4L, MAX_3L - dzban3L), historia); // Przelej z dzbanu 4L do 3L
    }
}
