package calcul;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Stream;

import static calcul.Output.Paire;
import static calcul.ReadWriteFile.writeTextToFile;
import static java.util.stream.IntStream.rangeClosed;

public class Calcul
{


    static final String filename = "C:\\Users\\gille\\IdeaProjects\\" +
            "Nombre_6.5\\src\\M_";
    static final TreeMap<Integer, Output> T = new TreeMap<>();
    int entiermax;
    Stream<Integer> stream = T.keySet().stream();

    public Calcul() {
        entiermax = 32;
        rangeClosed(2, entiermax).forEach(i ->
                rangeClosed(2, entiermax).forEach(j ->
                        {
                            int produit = i * j;
                            Paire p = new Paire(i, j);
                            if (T.containsKey(produit)) {
                                T.get(produit).m += 1;
                                T.get(produit).L.add(p);
                            } else {
                                ArrayList<Paire> L= new ArrayList<>();L.add(p);

                                T.put(produit, new Output(p, 1 ,L  ));
                            }
                        }
                )
        );
        Integer[][] tab = new Integer[entiermax + 1][entiermax + 1];
        stream.map(T::get).forEach(O -> O.L.forEach(p -> tab[p.i()][p.j()] = O.m));
        writeTextToFile(tab, filename, entiermax);
        System.out.println(T);
    }

    public static void main(String[] args) {
        new Calcul();
    }

}
