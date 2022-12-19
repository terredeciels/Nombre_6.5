package calcul;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static calcul.Calcul.Output.Paire;
import static ext.ReadWriteFile.writeTextToFile;
import static java.util.stream.IntStream.rangeClosed;

public class Calcul {

    static final String filename = "/Users/gilles/Downloads/";
    static final TreeMap<Integer, Output> T = new TreeMap<>();

    static int entiermax;

    private static Integer[][] tab;
    private static String[][] Ts;

    static void calcul() {

        rangeClosed(2, entiermax).forEach(i ->
                rangeClosed(2, entiermax).forEach(j -> {
                            if (i <= j) {
                                {
                                    int produit = i * j;
                                    Paire p = new Paire(i, j);
                                    if (T.containsKey(produit)) {
                                        T.get(produit).m += 1;
                                        T.get(produit).L.add(p);
                                    } else {
                                        ArrayList<Paire> L = new ArrayList<>();
                                        L.add(p);
                                        T.put(produit, new Output(p, 1, L));
                                    }
                                }
                            }
                        }
                )
        );
        tab = new Integer[entiermax + 1][entiermax + 1];
        T.keySet().stream().map(T::get).forEach(O -> O.L.forEach(p -> tab[p.i()][p.j()] = O.m));
        // writeTextToFile(tab, filename, entiermax);
        // System.out.println(T);

    }

    static void calculFormel() {

        Ts = new String[entiermax + 1][entiermax + 1];
        rangeClosed(2, entiermax).forEach(i ->
                rangeClosed(2, entiermax).forEach(j ->
                        {
                            String produitS = "a" + i + "." + "a" + j;
                            Ts[i][j] = produitS;
                        }
                )
        );

        // writeTextToFile(Ts, filename, entiermax);
    }

    public static void main(String[] args) {
        entiermax = 20;
        calcul();
        calculFormel();
        StringBuilder Sb = new StringBuilder();
        T.keySet().stream().map(T::get).forEach(O -> {
            for (Paire p : O.L) {
                int i = p.i();
                int j = p.j();
                if (O.m != 1)
                    Sb.append(Ts[i][j]).append(" = ");
            }

            if (O.m != 1) {
                Sb.delete(Sb.length() - 3, Sb.length());
                Sb.append("\n");
            }
        });
        System.out.println(Sb);
        writeTextToFile(String.valueOf(Sb), filename, entiermax);
    }

    public static class Output {
        Paire p;
        List<Paire> L;
        int m;

        public Output(Paire p, int m, List<Paire> l) {
            this.p = p;
            this.L = l;
            this.m = m;
        }


        public record Paire(int i, int j) {
        }
    }
}
