package Lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResztaZachlanny
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader str = new InputStreamReader(System.in);
        BufferedReader wejscie = new BufferedReader(str);
        String tekst;
        final int[] MONETY = {500,200,100,50,20,10,5,2,1};
        final int[] UZYTE = {0,0,0,0,0,0,0,0,0};
        int zl, gr, r, i = 0;
        System.out.println("Podaj resztę do wydania:");
        System.out.print("Złotych: ");
        tekst = wejscie.readLine();
        zl = Integer.parseInt(tekst);
        System.out.print("Groszy: ");
        tekst = wejscie.readLine();
        gr = Integer.parseInt(tekst);
        System.out.print("\nReszta:\n");
        r = zl*100 + gr;
        while (r >= 0 && i < 9)
        {
            if (r >= MONETY[i])
            {
                UZYTE[i] += 1;
                r = r - MONETY[i];
            }
            else
            {
                if (i <= 2) System.out.println((int)(MONETY[i]/100.0) + "zł x " + UZYTE[i]);
                else System.out.println(MONETY[i] + "gr x " + UZYTE[i]);
                i++;
            }
        }
    }
}
