package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Wr implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        if(arguments.length == 1) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            if (f.exists()) {
                System.out.println("Schreiben sie ihren Text. Enter fuer neue Zeile und \\e fuer exit");
                String datenInhalt = "";
                String neu = "";
                boolean exit = false;
                while (!exit) {
                    neu = LeoOs.scan.nextLine();
                    if (neu.equals("\\e")) {
                        exit = true;
                    } else {
                        datenInhalt += neu + "\n";
                    }
                }
                FileWriter fw = new FileWriter(f);
                fw.write(datenInhalt);
                fw.close();
            } else {
                throw new FileNotFoundException("Die ausgewaehlte Datei existiert nicht!");
            }
        } else if (arguments.length == 2) {
            File f = new File(LeoOs.currendDir + "\\" + arguments[0]);
            if (f.exists()) {
                FileWriter fw = new FileWriter(f);
                fw.write(arguments[1]);
                fw.close();
            } else {
                throw new FileNotFoundException("Die ausgewaehlte Datei existiert nicht!");
            }
        }
        return null;
    }
}
