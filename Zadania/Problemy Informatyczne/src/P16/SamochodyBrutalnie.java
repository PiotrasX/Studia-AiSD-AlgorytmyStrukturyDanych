package P16;

// Fabryka samochodów produkuje samochody osobowe i ciężarowe. Fabryka składa się z czterech oddziałów:
// 1-budowa nadwozi, 2-budowa silników, 3-montaż samochodów osobowych, 4-montaż samochodów ciężarowych.
// Miesięcznie zdolności produkcyjne tych oddziałów są następujące. Pierwszy oddział może wyprodukować maksymalnie
// 1000 nadwozi do samochodów osobowych oraz 2000 nadwozi do samochodów ciężarowych. Drugi oddział może wyprodukować
// maksymalnie 1200 silników do samochodów osobowych oraz 1440 silników do samochodów ciężarowych. Trzeci oddział
// może zmontować maksymalnie 1100 samochodów osobowych. Natomiast czwarty oddział może zmontować maksymalnie
// 1200 samochodów ciężarowych. Zysk przy produkcji samochodu osobowego wynosi 3200 złotych, a przy produkcji
// samochodu ciężarowego 2200 złotych. Ile fabryka powinna produkować miesięcznie samochodów osobowych a ile
// ciężarowych, aby zysk z produkcji był największy?
// Odp.: Maksymalny zysk 5840000 złotych uzyskamy, jeżeli fabryka wyprodukuje co miesiąc 1000 samochodów osobowych
//       i 1200 samochodów ciężarowych.

public class SamochodyBrutalnie
{
    public static void main(String[] args)
    {
        int[][] samochody = {{1000, 1200, 1100, 3200},            // Osobowe
                             {2000, 1440, 1200, 2200}};           // Ciężarowe
        StringBuilder jakieModele = new StringBuilder();
        int zyskMax = 0;

        for (int osobowe = 0; osobowe <= samochody[0][2]; osobowe++)
        {
            for (int ciezarowe = 0; ciezarowe <= samochody[1][2]; ciezarowe++)
            {
                if (osobowe <= samochody[0][0] && osobowe <= samochody[0][1] && ciezarowe <= samochody[1][0] && ciezarowe <= samochody[1][1])
                {
                    int zysk = osobowe * samochody[0][3] + ciezarowe * samochody[1][3];                // Aktualny zysk
                    if (zysk >= zyskMax)
                    {
                        zyskMax = zysk;
                        jakieModele.delete(0, jakieModele.length());
                        jakieModele.append(osobowe).append(" sztuk samochodów osobowych, ").append(ciezarowe).append(" sztuk samochodów ciężarowych");
                    }
                }
            }
        }
        System.out.println("Wyprodukowane modele: " + jakieModele);
        System.out.println("Maksymalny zysk: " + zyskMax + "zł");
    }
}
