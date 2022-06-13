package calcul;

import java.util.ArrayList;
import java.util.List;

public class Output// extends ArrayList<Output.Paire>
{

    public List<Paire> L = new ArrayList<>();
    public Paire p;
    public int m;

    public Output(Paire paire, int mult) {
        p = paire;
        m = mult;
        L.add(paire);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Paire value : L) ret.append(value);
        return "(" + m + ")" + "  " + ret + "\n";
    }


    public record Paire(int i, int j) {
    }
}
