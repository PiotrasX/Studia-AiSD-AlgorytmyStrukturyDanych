package P23;

// W pewnej zamkniętej społeczności liczącej 100000 osób pojawiło się 10 osób chorych na katar, co spowodowało
// „epidemię kataru”. Wiedząc, że spośród 10 osób chorych na katar każda zaraża codziennie jeszcze dwie osoby,
// podać przewidywany przebieg epidemii. W szczególności odpowiedzieć na pytania: kiedy będzie najwięcej chorych
// i kiedy epidemia wygaśnie z powodu braku osób podatnych na zachorowanie? Założyć przy tym, że katar trwa 7 dni
// od dnia zarażenia i przez ten okres chorzy mogą zarażać inne osoby. Oprócz tego osoby, które wyzdrowiały nie
// mogą już zachorować. Jak zmieni się przebieg epidemii, jeśli dopuścimy, że po 2 tygodniach po wyzdrowieniu,
// znowu można zachorować na katar?

public class EpidemiaDzielZwyciezaj
{
    static int chorychMAX = 0; // Liczba maksymalnie chorych osób
    static int dzienChorychMAX = 0; // Liczba chorych w danym dniu
    static final int LUDZI = 100000; // Ile ludzi bierzemy pod lupę
    static final int DNI_CHOROBY = 7; // Ile trwa chorowanie
    static final int DNI_OKRESU_PRZEJSCIOWEGO = 14; // Po ilu dniach można znowu zarażać
    static int[] chorzyDni = new int[DNI_CHOROBY]; // Tablica ile w danym dniu jest chorych osób
    static int[] zdroweOsoby = new int[DNI_OKRESU_PRZEJSCIOWEGO]; // Tablica ile w danym dniu jest zdrowych osób

    public static void main(String[] args)
    {
        System.out.println("Wariant 1 - wyzdrowiałe osoby nie mogą zarażać:");
        wykonajSymulacje(false);
        chorychMAX = 0;
        System.out.println("\nWariant 2 - wyzdrowiałe osoby mogą zarażać po 2 tygodniach:");
        wykonajSymulacje(true);
    }

    private static void wykonajSymulacje(boolean czyMogaZarazac)
    {
        int zdrowiNowi = LUDZI - 10; // Ile zdrowych osób
        int zdrowiOzdrowiency = 0; // Ile zdrowych osób co już przechorowało
        int chorzy = 10; // Ile chorych osób
        int dzien = 1; // Dzień epidemii
        chorzyDni[0] = 10;

        while (chorzy > 0)
        {
            int chorzyNowi = obliczNowychChorych();
            if (czyMogaZarazac)
            {
                aktualizujOzdrowiency(chorzyNowi);
            }
            else
            {
                if (chorzyNowi > zdrowiNowi) { chorzyNowi = zdrowiNowi; }
                zdrowiNowi -= chorzyNowi;
            }
            aktualizujChorych(chorzyNowi);

            chorzy = obliczLiczbeChorych();
            zdrowiOzdrowiency += chorzyDni[DNI_CHOROBY - 1];
            if (chorzy > chorychMAX)
            {
                chorychMAX = chorzy;
                dzienChorychMAX = dzien;
            }
            dzien++;
        }

        System.out.println("Epidemia skończy się po " + dzien + " dniach");
        System.out.println("Najwięcej chorych będzie w " + dzienChorychMAX + " dzień");
    }

    private static int obliczNowychChorych()
    {
        int nowiChorzy = 0;
        for (int i = 0; i < DNI_CHOROBY; i++) { nowiChorzy += chorzyDni[i] * 2; }
        return nowiChorzy;
    }

    private static void aktualizujChorych(int chorzyNowi)
    {
        System.arraycopy(chorzyDni, 0, chorzyDni, 1, DNI_CHOROBY - 1);
        chorzyDni[0] = chorzyNowi;
    }

    private static void aktualizujOzdrowiency(int chorzyNowi)
    {
        System.arraycopy(zdroweOsoby, 0, zdroweOsoby, 1, DNI_OKRESU_PRZEJSCIOWEGO - 1);
        zdroweOsoby[0] = chorzyDni[DNI_CHOROBY - 1];
        chorzyDni[0] = chorzyNowi + zdroweOsoby[DNI_OKRESU_PRZEJSCIOWEGO - 1];
    }

    private static int obliczLiczbeChorych()
    {
        int sumaChorych = 0;
        for (int i = 0; i < DNI_CHOROBY; i++) { sumaChorych += chorzyDni[i]; }
        return sumaChorych;
    }
}
