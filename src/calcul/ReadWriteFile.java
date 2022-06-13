package calcul;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {
    ///home/me/Documents/ToWindows/matrix1.txt

    public static String readFromFile(String fileaddr) throws FileNotFoundException {
        StringBuilder ret = new StringBuilder();
        Scanner scanner = new Scanner(new File(fileaddr));
        while (scanner.hasNextLine()) {
            ret.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return ret.toString();
    }

    public static void writeTextToFile(Integer[][] tab, String fileaddr, int n) {
        StringBuilder ret = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                ret.append(tab[i][j]).append(",");
            }
            ret.append("\n");
        }
        writeTextToFile(ret.toString(), fileaddr + n + ".txt");
    }

    public static void writeTextToFile(String texttowrite, String fileaddr) {
        try {
            FileWriter fw = new FileWriter(fileaddr, false);
            BufferedWriter output = new BufferedWriter(fw);
            output.write(texttowrite);
            output.flush();
            output.close();
        } catch (IOException ioe) {
            System.out.println("error " + ioe);
        }
    }


}
