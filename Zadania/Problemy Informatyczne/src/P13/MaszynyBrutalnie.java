package P13;

// Fabryka produkuje dwa modele: A i B. Każdy model musi kolejno przejść przez dwie maszyny I i II. Dla wykonania
// każdego egzemplarza A maszyna I musi pracować jedną godzinę, a maszyna II - 2.5 godziny. Dla wykonania modelu B
// maszyny I i II muszą pracować odpowiednio 4 godziny i 2 godziny. Maszyna I może być w ruchu najwyżej 8 godzin
// dziennie, a maszyna II - 12 godzin. Każdy model A przynosi 120 złotych zysku, natomiast każdy model B przynosi
// 160 złotych zysku. Ilu sztuk każdego modelu powinna produkować dziennie fabryka, aby zysk ze sprzedaży był
// możliwie największy?
// Odp.: Zysk ze sprzedaży będzie największy i wyniesie 640 złotych, jeżeli fabryka wyprodukuje dziennie 4 sztuki
//       modelu A i 1 sztukę modelu B.

public class MaszynyBrutalnie
{
    public static void main(String[] args)
    {
        double[][] modele = {{1, 2.5, 120},        // Model A
                             {4, 2, 160}};         // Model B
        StringBuilder jakieModele = new StringBuilder();
        double zyskMax = 0;

        for (int mA = 0; mA <= 100; mA++)
        {
            for (int mB = 0; mB <= 100; mB++)
            {
                double mI = modele[0][0] * mA + modele[1][0] * mB;                   // Aktualny czas I maszyna
                if(mI > 8) continue;
                double mII = modele[0][1] * mA + modele[1][1] * mB;                  // Aktualny czas II maszyna
                if(mII > 12) continue;
                double zysk = mA * modele[0][2] + mB * modele[1][2];                 // Aktualny koszt
                if (zysk >= zyskMax)
                {
                    zyskMax = zysk;
                    jakieModele.delete(0, jakieModele.length());
                    jakieModele.append(mA).append(" sztuk modeli A, ").append(mB).append(" sztuk modeli B");
                }
            }
        }
        System.out.println("Wyprodukowane modele: " + jakieModele);
        System.out.println("Maksymalny zysk: " + zyskMax + "zł");
    }
}
