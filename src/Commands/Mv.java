package Commands;

import LeoOS.LeoOs;
import LeoOS.TextColor;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Mv implements Command{
    @Override
    public String[] execute(String[] arguments) throws IOException {
        boolean mvSucsess = false;
        if(arguments.length > 1) {
            File cur;
            if (arguments[0].contains("\\")) {
                cur = new File(arguments[0]);
            } else {
                cur = new File(LeoOs.currendDir + "\\" + arguments[0]);
            }
            File mv = new File(LeoOs.currendDir + "\\" + arguments[1]);
            if (mv.exists()) {
                throw new FileAlreadyExistsException("Die Datei existiert bereits in dem Ordner");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(cur));
                String output = "";
                String o;
                while ((o = br.readLine()) != null) {
                    output += o + "\n";
                }
                if (cur.exists()) {
                    FileWriter fw = new FileWriter(mv);
                    fw.write(output);
                    fw.close();
                    mvSucsess = true;
                }
            }
        }
        if(mvSucsess) {
            File cur;
            if (arguments[0].contains("\\")) {
                cur = new File(arguments[0]);
            } else {
                cur = new File(LeoOs.currendDir + "\\" + arguments[0]);
            }
            cur.delete();
        }
        return null;
    }
}
