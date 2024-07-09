package P23;

// W pewnej zamkniętej społeczności liczącej 100000 osób pojawiło się 10 osób chorych na katar, co spowodowało
// „epidemię kataru”. Wiedząc, że spośród 10 osób chorych na katar każda zaraża codziennie jeszcze dwie osoby,
// podać przewidywany przebieg epidemii. W szczególności odpowiedzieć na pytania: kiedy będzie najwięcej chorych
// i kiedy epidemia wygaśnie z powodu braku osób podatnych na zachorowanie? Założyć przy tym, że katar trwa 7 dni
// od dnia zarażenia i przez ten okres chorzy mogą zarażać inne osoby. Oprócz tego osoby, które wyzdrowiały nie
// mogą już zachorować. Jak zmieni się przebieg epidemii, jeśli dopuścimy, że po 2 tygodniach po wyzdrowieniu,
// znowu można zachorować na katar?

public class EpidemiaBrutalnie
{
    static int chorychMAX = 0;
    static int dzienChorychMAX = 0;

    public static void main(String[] args)
    {
        System.out.println("Wariant 1 - wyzdrowiałe osoby nie mogą zarażać:");
        wariant1(99990, 10, 0, 99990, 1, new int[] {10, 0, 0, 0, 0, 0, 0, 0});
        chorychMAX = 0;
        System.out.println("\nWariant 2 - wyzdrowiałe osoby mogą zarażać po 2 tygodniach:");
        wariant2(99990, 10, 0, 99990, 1, new int[] {10, 0, 0, 0, 0, 0, 0, 0}, new int[15]);
    }

    public static void wariant1(int zdrowiNowi, int chorzy, int zdrowiOzdrowiency, int zdrowi, int dzien, int[] chorzyDni)
    {
        System.out.println("Dzień epidemii: " + dzien + ", chore osoby: " + chorzy + ", zdrowe osoby: " + zdrowi + " ");
        int chorzyNowi = chorzyDni[0] * 2 + chorzyDni[1] * 2 + chorzyDni[2] * 2 + chorzyDni[3] * 2 + chorzyDni[4] * 2 + chorzyDni[5] * 2 + chorzyDni[6] * 2; // Ile przybędzie nowych chorych osób
        if (chorzyNowi > zdrowiNowi) { chorzyNowi = zdrowiNowi; } // Jeśli chorych ma być więcej niż może być to redukujemy do ilości nigdy nie zachorowanych
        for (int i = 7; i >= 1; i--) { chorzyDni[i] = chorzyDni[i - 1]; } // Przesunięcie chorych o 1 dzień choroby
        zdrowiOzdrowiency += chorzyDni[7]; // Ile już wyzdrowiało osób
        chorzyDni[0] = chorzyNowi; // Do pierwszego dnia choroby przypisujemy nowych chorych
        zdrowiNowi -= chorzyNowi; // Ile osób nigdy nie chorowało
        zdrowi = zdrowiNowi + zdrowiOzdrowiency; // Ile jest wszystkich zdrowych osób
        chorzy = chorzyDni[0] + chorzyDni[1] + chorzyDni[2] + chorzyDni[3] + chorzyDni[4] + chorzyDni[5] + chorzyDni[6]; // Ile osób choruje aktualnie
        dzien++; // Dzień epidemii
        if (chorzy > chorychMAX) { chorychMAX = chorzy; dzienChorychMAX = dzien; }
        if (chorzy > 0) { wariant1(zdrowiNowi, chorzy, zdrowiOzdrowiency, zdrowi, dzien, chorzyDni); }
        else { System.out.println("Dzień epidemii: " + dzien + ", chore osoby: " + chorzy + ", zdrowe osoby: " + zdrowi + " ");
               System.out.println("\tEpidemia skończy się po " + dzien + " dniach");
               System.out.println("\tNajwięcej chorych będzie w " + dzienChorychMAX + " dzień"); }
    }

    public static void wariant2(int zdrowiNowi, int chorzy, int zdrowiOzdrowiency, int zdrowi, int dzien, int[] chorzyDni, int[] zdroweOsoby)
    {
        System.out.println("Dzień epidemii: " + dzien + ", chore osoby: " + chorzy + ", zdrowe osoby: " + zdrowi + " ");
        int chorzyNowi = chorzyDni[0] * 2 + chorzyDni[1] * 2 + chorzyDni[2] * 2 + chorzyDni[3] * 2 + chorzyDni[4] * 2 + chorzyDni[5] * 2 + chorzyDni[6] * 2; // Ile przybędzie nowych chorych osób
        if(chorzyNowi > zdrowiNowi) { chorzyNowi = zdrowiNowi; } // Jeśli chorych ma być więcej niż może być to redukujemy do ilości nigdy nie zachorowanych
        for (int i = 7; i >= 1; i--) { chorzyDni[i] = chorzyDni[i - 1]; } // Przesunięcie chorych o 1 dzień choroby
        for (int i = 14; i >= 1; i--) { zdroweOsoby[i] = zdroweOsoby[i - 1]; } // Przesunięcie ozdrowieńców o 1 dzień
        zdrowiOzdrowiency += chorzyDni[7]; // Ile już wyzdrowiało osób
        zdrowiOzdrowiency -= zdroweOsoby[14]; // Ile osób wyzdrowiało minus osoby, które znowu mogą zachorować
        chorzyDni[0] = chorzyNowi; // Do pierwszego dnia choroby przypisujemy nowych chorych
        zdroweOsoby[0] = chorzyDni[7]; // Ile osób wyzdrowiało, ale jeszcze nie może zarażać
        zdrowiNowi -= chorzyNowi; // Ile osób nigdy nie chorowało
        zdrowiNowi += zdroweOsoby[14]; // Ile osób znowu może zachorować
        zdrowi = zdrowiNowi + zdrowiOzdrowiency; // Ile jest wszystkich zdrowych osób
        chorzy = chorzyDni[0] + chorzyDni[1] + chorzyDni[2] + chorzyDni[3] + chorzyDni[4] + chorzyDni[5] + chorzyDni[6]; // Ile osób choruje aktualnie
        dzien++; // Dzień epidemii
        if(chorzy > chorychMAX) { chorychMAX = chorzy; dzienChorychMAX = dzien; }
        if(chorzy > 0) { wariant2(zdrowiNowi, chorzy, zdrowiOzdrowiency, zdrowi, dzien, chorzyDni, zdroweOsoby); }
        else { System.out.println("Dzień epidemii: " + dzien + ", chore osoby: " + chorzy + ", zdrowe osoby: " + zdrowi + " ");
            System.out.println("\tEpidemia skończy się po " + dzien + " dniach");
            System.out.println("\tNajwięcej chorych będzie w " + dzienChorychMAX + " dzień"); }
    }
}
