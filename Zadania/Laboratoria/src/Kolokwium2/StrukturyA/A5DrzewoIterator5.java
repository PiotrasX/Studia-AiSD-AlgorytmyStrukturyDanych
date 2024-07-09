package Kolokwium2.StrukturyA;

// Iterator do drzewa poszukiwań binarnych

import java.util.ArrayList;

public class A5DrzewoIterator5
{
    private ArrayList<A5WezelDrzewa5> listaWezlow;
    private int obecnyIndeksWezla;
    
    public A5DrzewoIterator5(ArrayList<A5WezelDrzewa5> listaWezlow)
    {
        obecnyIndeksWezla = 0;
        this.listaWezlow = listaWezlow;
    }

    public boolean jakiNastepny() { return obecnyIndeksWezla <= listaWezlow.size() - 1; }

    public A5WezelDrzewa5 nastepny()
    {
        if (obecnyIndeksWezla == listaWezlow.size()) return null;
        A5WezelDrzewa5 obecnyWezel = listaWezlow.get(obecnyIndeksWezla);
        obecnyIndeksWezla++;
        return obecnyWezel;
    }
}
