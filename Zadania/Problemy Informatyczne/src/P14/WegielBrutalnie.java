package P14;

// Kopalnie A i B dostarczają węgiel do miast C, D i E. Kopalnia A dostarcza dziennie 500 ton, natomiast kopalnia B
// dostarcza dziennie 800 ton węgla. Miasta C, D i E zużywają odpowiednio 500, 400 i 400 ton węgla dziennie.
// Koszt transportu, w dziesiątkach złotych, jednej tony węgla do poszczególnych miast podaje następująca tabelka:
//                                           | z\do|  C  |  D  |  E  |
//                                           |  A  |  8  |  5  |  5  |
//                                           |  B  |  4  |  6  |  8  |
// Jak należy zorganizować transport węgla, aby koszt był możliwie najmniejszy?
// Odp.: Aby uzyskać minimalny koszt transportu węgla wynoszący 6300 dziesiątek złotych, należy z kopali A i B
//       przetransportować do miast C, D i E węgiel w następujących proporcjach:
//                                           | z\do|  C  |  D  |  E  |
//                                           |  A  |  0  | 100 | 400 |
//                                           |  B  | 500 | 300 |  0  |

public class WegielBrutalnie
{
    public static void main(String[] args)
    {
        int[][] koszty = {{8, 5, 5},
                          {4, 6, 8}};         // Koszty transportu
        StringBuilder jakieModele = new StringBuilder();
        double kosztMin = 99999;

        for (int wAC = 0; wAC <= 500; wAC++)
        {
            for (int wAD = 0; wAD <= 400; wAD++)
            {
                for (int wAE = 0; wAE <= 400; wAE++)
                {
                    int wBC = 500 - wAC, wBD = 400 - wAD, wBE = 400 - wAE;
                    if (wAC + wAD + wAE > 500) continue;                                                                         // Sprawdzenie czy węgiel A nie przekracza pojemności
                    if (wBC + wBD + wBE > 800) continue;                                                                         // Sprawdzenie czy węgiel B nie przekracza pojemności
                    int koszt = wAC * koszty[0][0] + wBC * koszty[1][0] + wAD * koszty[0][1] + wBD * koszty[1][1] + wAE * koszty[0][2] + wBE * koszty[1][2];  // Aktualny minimalny koszt
                    if (koszt <= kosztMin)
                    {
                        kosztMin = koszt;
                        jakieModele.delete(0, jakieModele.length());
                        jakieModele.append("Miasto C (").append(wAC).append(" ton z kopalni A, ").append(wBC).append(" ton z kopalni B), ").
                                append("\n\t\t\t\t Miasto D (").append(wAD).append(" ton z kopalni A, ").append(wBD).append(" ton z kopalni B), ").
                                append("\n\t\t\t\t Miasto E (").append(wAE).append(" ton z kopalni A, ").append(wBE).append(" ton z kopalni B), ");
                    }
                }
            }
        }
        System.out.println("Transport węgla: " + jakieModele);
        System.out.println("Minimalny koszt: " + kosztMin + "zł");
    }
}
