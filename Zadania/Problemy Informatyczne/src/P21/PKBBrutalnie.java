package P21;

// W roku 1998 produkt krajowy brutto (w skrócie PKB) Polski wyniósł 6000 dolarów, a przyrost PKB utrzymywał się na
// poziomie 6 procent w skali roku. Załóżmy, że przyrost PKB Polski w następnych latach utrzyma się na takim samym
// poziomie. Ile lat musi upłynąć, aby PKB Polski podwoił się? W roku 1998 PKB Niemiec wyniósł 12000 dolarów,
// a przyrost PKB utrzymywał się na poziomie 1.2 procenta w skali roku. Załóżmy, że przyrost PKB Niemiec w następnych
// latach utrzyma się na takim samym poziomie. Czy jest szansa, aby w ciągu następnych 20 lat PKB Polski dorównał
// PKB Niemiec?
// Odp.: PKB Polski podwoi się po 12 latach.
//       PKB Polski dorówna PKB Niemiec po 15 latach.

public class PKBBrutalnie
{
    public static void main(String[] args) { pkb(6000, 12000, false, false, 0); }

    static void pkb(double polska, double niemcy, boolean podwojone, boolean dogonione, int rok)
    {
        System.out.println("Rok " + rok + ", PKB POLSKI: " + ((double) Math.round(polska*100)/100) + "$, PKB NIEMIEC: " + ((double) Math.round(niemcy*100)/100) + "$");
        polska = polska + polska * 0.06;
        niemcy = niemcy + niemcy * 0.012;
        rok++;
        if (polska >= 12000 && !podwojone) { System.out.println("\t\tPo " + rok + " latach PKB Polski podwoiło się"); podwojone=true; }
        if (polska >= niemcy && !dogonione) { System.out.println("\t\tPo " + rok + " latach PKB Polski dogoni PKB Niemiec"); dogonione=true; }
        if (!podwojone || !dogonione) { pkb(polska, niemcy, podwojone, dogonione, rok); }
    }
}
