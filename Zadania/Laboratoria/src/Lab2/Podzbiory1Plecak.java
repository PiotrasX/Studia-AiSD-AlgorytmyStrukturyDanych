package Lab2;

public class Podzbiory1Plecak 
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
        
        int b0, b1, b2, b3, b4, b5;
        for (b0 = 0; b0 <= 1; b0++) 
        {
            for (b1 = 0; b1 <= 1; b1++) 
            {
                for (b2 = 0; b2 <= 1; b2++) 
                {
                    for (b3 = 0; b3 <= 1; b3++) 
                    {
                        for (b4 = 0; b4 <= 1; b4++) 
                        {
                            for (b5 = 0; b5 <= 1; b5++) 
                            {
                                if (b0 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][0];
                                    wAktual = wAktual + przedmioty[1][0];
                                    podzbior.append("0 ");
                                }
                                if (b1 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][1];
                                    wAktual = wAktual + przedmioty[1][1];
                                    podzbior.append("1 ");
                                }
                                if (b2 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][2];
                                    wAktual = wAktual + przedmioty[1][2];
                                    podzbior.append("2 ");
                                }
                                if (b3 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][3];
                                    wAktual = wAktual + przedmioty[1][3];
                                    podzbior.append("3 ");
                                }
                                if (b4 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][4];
                                    wAktual = wAktual + przedmioty[1][4];
                                    podzbior.append("4 ");
                                }
                                if (b5 == 1) 
                                {
                                    vAktual = vAktual + przedmioty[0][5];
                                    wAktual = wAktual + przedmioty[1][5];
                                    podzbior.append("5 ");
                                }
                                
                                if (vAktual <= vMax && wAktual >= wMax)
                                {
                                    wMax = wAktual;
                                    System.out.println(podzbior + "} v=" + vAktual + ", w=" + wAktual);
                                }
                                vAktual = 0;
                                wAktual = 0;
                                podzbior = new StringBuilder("{ ");
                            }
                        }
                    }
                }
            }
        }
    }
}
