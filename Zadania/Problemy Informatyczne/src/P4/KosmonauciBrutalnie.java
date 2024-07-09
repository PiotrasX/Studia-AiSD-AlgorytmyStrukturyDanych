package P4;

// Organizowana jest załogowa ekspedycja kosmiczna na Marsa. W ramach kompletowania załogi statku kosmicznego
// główny organizator ekspedycji ma rozwiązać następujący problem. Do jego dyspozycji jest pięciu kosmonautów
// (k1, k2, k3, k4, k5), którzy przeszli pozytywnie kwalifikację wstępną do udziału w ekspedycji. Na pokładzie
// specjalnego statku kosmicznego spośród nich będzie potrzebny przynajmniej jeden specjalista w każdej
// z dziedzin: A, B, C i D. Wiadomo jest, że w dziedzinie A specjalizują się kosmonauci k1 i k4, w dziedzinie B
// specjalizują się kosmonauci k2, k3 i k4, w dziedzinie C specjalizują się kosmonauci k3 i k5 oraz w dziedzinie D
// specjalizują się kosmonauci k1, k2 i k5. Ze względu na szczupłość miejsca na pokładzie statku kosmicznego,
// z powyższej piątki trzeba wybrać jak najmniejszą grupkę kosmonautów, tak aby znajdował się w niej przynajmniej
// jeden specjalista w każdej z dziedzin A, B, C, D.
// Odp.: Na Marsa mogą polecieć kosmonauci k4 i k5 oraz k1 i k3.

public class KosmonauciBrutalnie
{
    public static void main(String[] args)
    {
        int[][] special = {{1, 0, 0, 1},   // Specjalności k1
                           {0, 1, 0, 1},   // Specjalności k2
                           {0, 1, 1, 0},   // Specjalności k3
                           {1, 1, 0, 0},   // Specjalności k4
                           {0, 0, 1, 1}};  // Specjalności k5
        int ileKosmoMax = 5;              // Ile kosmonautów poleci
        StringBuilder kosmoMax = new StringBuilder();

        for (int k1 = 0; k1 <= 1; k1++)
        {
            for (int k2 = 0; k2 <= 1; k2++)
            {
                for (int k3 = 0; k3 <= 1; k3++)
                {
                    for (int k4 = 0; k4 <= 1; k4++)
                    {
                        for (int k5 = 0; k5 <= 1; k5++)
                        {
                            StringBuilder kosmo = new StringBuilder();
                            int ileKosmo = 0;             // Aktualni użyci kosmonauci
                            int[] zajete = {0, 0, 0, 0};   // Aktualne użyte specjalności
                            if (k1 == 1) { for (int i = 0; i < special[0].length; i++) { if(special[0][i] != 0) { zajete[i] = 1; } } kosmo.append("k1 "); ileKosmo++; }
                            if (k2 == 1) { for (int i = 0; i < special[1].length; i++) { if(special[1][i] != 0) { zajete[i] = 1; } } kosmo.append("k2 "); ileKosmo++; }
                            if (k3 == 1) { for (int i = 0; i < special[2].length; i++) { if(special[2][i] != 0) { zajete[i] = 1; } } kosmo.append("k3 "); ileKosmo++; }
                            if (k4 == 1) { for (int i = 0; i < special[3].length; i++) { if(special[3][i] != 0) { zajete[i] = 1; } } kosmo.append("k4 "); ileKosmo++; }
                            if (k5 == 1) { for (int i = 0; i < special[4].length; i++) { if(special[4][i] != 0) { zajete[i] = 1; } } kosmo.append("k5 "); ileKosmo++; }

                            int ile = 0;
                            for (int i : zajete)
                            {
                                if (i != 0) { ile++; }
                                else { break; }
                            }
                            if (ile == 4)
                            {
                                if (ileKosmo == ileKosmoMax)
                                {
                                    kosmoMax.append(kosmo).append("\n");
                                }
                                if (ileKosmo < ileKosmoMax)
                                {
                                    ileKosmoMax = ileKosmo;
                                    kosmoMax.delete(0, kosmoMax.length());
                                    kosmoMax.append(kosmo).append("\n");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Wybrani kosmonauci: ");
        System.out.print(kosmoMax);
    }
}
