package P26;

// Zakład utylizacji odpadów posiada pewną liczbę jednolitrowych butelek, które oryginalnie zawierały roztwór
// toksycznego związku chemicznego X o stężeniu 0.5 (50 procent związku X + 50 procent wody). Butelki są zgodnie
// z normą puste, ale w każdej z pozostaje 1 mililitr roztworu. Każda butelka przechodzi następujący proces płukania:
// dodaj V mililitrów wody, wymieszaj i wylej roztwór do cysterny. Przyjmujemy, że po wylaniu roztworu w butelce
// pozostaje go 1 mililitr. Proces jest powtarzany tak długo, aż stężenie X w pozostającym roztworze będzie niższe
// od 0.00000001. Z każdym krokiem płukania wiąże się koszt wykonanej pracy równy 0.25 grosza, podobnie pewien koszt
// jest związany z wylaniem roztworu do cysterny (1.5 grosza na litr wylanego roztworu). Zadanie polega na znalezieniu
// optymalnej zawartości V ze względu na koszty przy uwzględnieniu stężenia początkowego i wymaganego.

public class OdpadyBrutalnie
{
    public static double CENA = Double.MAX_VALUE; // Ostateczna cena płukania
    public static double ROZTWORCYSTERNA = 0; // Ostateczna ilość wylanego roztworu do cysterny
    public static int PLUKANIAILOSC = 0; // Ostateczna ilość płukań
    public static int WLEWANAWODA = 0; // Ostateczna ilość wlewanej wody

    public static void main(String[] args)
    {
        double stezenieX = 0.5; // Początkowe stężenie substancji X w roztworze w pustej butelce (ml)
        double stezenieW = 0.5; // Początkowe stężenie wody w roztworze w pustej butelce (ml)
        for (int dodanaW = 1; dodanaW <= 999; dodanaW++)
        {
            int plukania = 0; // Ilość płukań roztworu
            double cysternaR = 0; // Ilość wylanego roztworu (ml)
            plukanie(plukania, cysternaR, dodanaW, stezenieX, stezenieW);
        }
        System.out.println("Najbardziej optymalny proces:");
        System.out.println("Cena całego procesu: " + CENA + "gr");
        System.out.println("Ilość wylanego roztworu do cysterny: " + ROZTWORCYSTERNA + "ml");
        System.out.println("Ilość płukań: " + PLUKANIAILOSC);
        System.out.println("Ilość wlewanej wody podczas płukania: " + WLEWANAWODA + "ml");
    }

    private static void plukanie(int plukania, double cysternaR, int dodanaW, double stezenieX, double stezenieW)
    {
        if (stezenieX < 0.00000001)
        {
            double cenaObecna = plukania * 0.25 + 1.5 * (cysternaR / 1000);
            if (cenaObecna <= CENA)
            {
                CENA = cenaObecna;
                ROZTWORCYSTERNA = cysternaR;
                PLUKANIAILOSC = plukania;
                WLEWANAWODA = dodanaW;
            }
        }
        else
        {
            stezenieW += dodanaW; // Stężenie wody przy płukaniu (ml)
            double caloscRoztworu = stezenieX + stezenieW; // Ilość całego roztworu (ml)
            stezenieX /= caloscRoztworu;// Stężenie substancji X po płukaniu (ml)
            stezenieW /= caloscRoztworu; // Stężenie wody po płukaniu (ml)
            plukania += 1; // Ilość płukań roztworu
            cysternaR += (caloscRoztworu - 1); // Ilość wylanego roztworu (ml)

            //System.out.println("Stężenie X: " + stezenieX + ", Stężenie wody: " + stezenieW + ", Ilość wylanej wody: " + cysternaW + ", Ilość płukań butelki: " + plukania);
            plukanie(plukania, cysternaR, dodanaW, stezenieX, stezenieW);
        }
    }
}
