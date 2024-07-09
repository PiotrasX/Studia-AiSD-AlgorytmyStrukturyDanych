package P3;

// Liczby pitagorejskie są to trzy liczby naturalne x, y, z, które spełniają warunek x^2 + y^2 = z^2.
// Znaleźć wszystkie takie trójki liczb, przy założeniu, że każda z tych liczb ma należy do zbioru {1, ..., 30}.

public class LiczbyPitagorasaBrutalnie
{
    public static void main(String[] args)
    {
        System.out.println("Wszystkie trójki pitagorejskie: ");
        for (int x = 1; x <= 30; x++)
        {
            for (int y = x; y <= 30; y++)
            {
                for (int z = y; z <= 30; z++)
                {
                    if (x * x + y * y == z * z)
                    {
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
    }
}
