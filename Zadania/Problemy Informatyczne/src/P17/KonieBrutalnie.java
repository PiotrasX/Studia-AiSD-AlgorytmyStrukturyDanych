package P17;

// Pewna firma jest właścicielem pięciu stadnin koni: A, B, C, D i E. Po inwentaryzacji stwierdzono, że w stadninie
// A jest o 8, a w stadninie B o 6 koni za dużo. Konie te postanowiono rozdzielić między pozostałe gospodarstwa
// następująco: 5 koni posłać do gospodarstwa C, 5 do D oraz 4 do E. Koszty transportu koni pomiędzy stadninami
// w dziesiątkach złotych podaje następująca tabela.
//                                           | z\do|  C  |  D  |  E  |
//                                           |  A  |  16 |  10 |  15 |
//                                           |  B  |  10 |  12 |  10 |
// Jak rozesłać konie z gospodarstw A i B, aby koszt transportu był najmniejszy?
// Odp.: Aby uzyskać minimalny koszt transportu koni wynoszący 155 dziesiątek złotych, należy ze stadnin A i B
//       przetransportować do stadnin C, D i E konie w następujących ilościach:
//                                           | z\do|  C  |  D  |  E  |
//                                           |  A  |  0  |  5  |  3  |
//                                           |  B  |  5  |  0  |  1  |

public class KonieBrutalnie
{
    public static void main(String[] args)
    {
        int[][] koszty = {{16, 10, 15},
                          {10, 12, 10}};         // Koszty transportu
        StringBuilder jakieModele = new StringBuilder();
        double kosztMin = 99999;

        for (int kAC = 0; kAC <= 5; kAC++)
        {
            for (int kAD = 0; kAD <= 5; kAD++)
            {
                for (int kAE = 0; kAE <= 4; kAE++)
                {
                    int kBC = 5 - kAC, kBD = 5 - kAD, kBE = 4 - kAE;
                    if (kAC + kAD + kAE > 8) continue;                                                                          // Sprawdzenie czy konie z miasta A nie przekraczają liczby dozwolonych
                    if (kBC + kBD + kBE > 6) continue;                                                                          // Sprawdzenie czy konie z miasta B nie przekraczają liczby dozwolonych
                    int koszt = kAC * koszty[0][0] + kBC * koszty[1][0] + kAD * koszty[0][1] + kBD * koszty[1][1] + kAE * koszty[0][2] + kBE * koszty[1][2];  // Aktualny minimalny koszt
                    if (koszt <= kosztMin)
                    {
                        kosztMin = koszt;
                        jakieModele.delete(0, jakieModele.length());
                        jakieModele.append("Miasto C (").append(kAC).append(" koni z miasta A, ").append(kBC).append(" koni z miasta B), ").
                                append("\n\t\t\t\t Miasto D (").append(kAD).append(" koni z miasta A, ").append(kBD).append(" koni z miasta B), ").
                                append("\n\t\t\t\t Miasto E (").append(kAE).append(" koni z miasta A, ").append(kBE).append(" koni z miasta B), ");
                    }
                }
            }
        }
        System.out.println("Transport koni: " + jakieModele);
        System.out.println("Minimalny koszt: " + kosztMin + "zł");
    }
}
