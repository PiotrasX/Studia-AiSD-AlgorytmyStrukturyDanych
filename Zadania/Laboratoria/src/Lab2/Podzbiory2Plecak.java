package Lab2;

public class Podzbiory2Plecak
{
    public static void main(String[] args)
    {
        int[][] przedmioty = {{6,2,3,2,3,1},   // Vi
                              {6,4,5,7,10,2}}; // Wi

        int vMax = 10;   // Maksymalna dopuszczalna objętość
        int wMax = 0;    // Początkowy stan maksymalnej wartości przedmiotów
        int vAktual = 0; // Objętość obliczana na bieżąco dla danego podzbioru przedmiotów
        int wAktual = 0; // Wartość przedmiotów obliczana na bieżąco dla danego podzbioru

        StringBuilder podzbior = new StringBuilder("{ ");

        final int N = przedmioty[0].length; // Moc zbioru
        int[] tab = new int[N + 1];
        int s = (int) Math.pow(2, N);

        for (int l = 0; l < s; l++)
        {
            for (int i = 0; i < N; i++)
            {
                if (tab[i] == 1)
                {
                    vAktual = vAktual + przedmioty[0][i];
                    wAktual = wAktual + przedmioty[1][i];
                    podzbior.append(" ").append(i);
                }
            }

            if (vAktual <= vMax && wAktual >= wMax)
            {
                wMax = wAktual;
                System.out.println(podzbior + " } v=" + vAktual + ", w=" + wAktual);
            }
            vAktual = 0;
            wAktual = 0;
            podzbior = new StringBuilder("{");

            int i = 0;
            do {
                if (tab[i] == 1)
                {
                    tab[i] = 0;
                    i++;
                }
                else
                {
                    tab[i] = 1;
                    break;
                }
            } while (true);
        }
    }
}
