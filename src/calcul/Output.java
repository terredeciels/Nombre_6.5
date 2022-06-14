package calcul;

import java.util.List;

public class Output// extends ArrayList<Output.Paire>
{

    public List<Paire> L;
    public Paire p;
    public int m;

    public Output(Paire p, int m, List<Paire> l) {
        L = l;
        this.p = p;
        this.m = m;
    }

//    public Output(Paire paire, int mult) {
//        p = paire;
//        m = mult;
//        L.add(paire);
//    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Paire value : L) ret.append(value);
        return "(" + m + ")" + "  " + ret + "\n";
    }


    public record Paire(int i, int j) {
        @Override
        public String toString() {
            return "(" + i + "," + j + ')';
        }
    }
}
